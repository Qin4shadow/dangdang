package com.baizhi.ql.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.ql.dao.BookDao;
import com.baizhi.ql.dao.ItemDao;
import com.baizhi.ql.entity.Book;
import com.baizhi.ql.entity.BuyCar;
import com.baizhi.ql.entity.Item;
import com.baizhi.ql.entity.Order;
import com.baizhi.ql.service.ItemService;
import com.baizhi.ql.util.MybatisUtil;

public class ItemServiceImpl implements ItemService {

	//添加
	@Override
	public void insert() {
		try {
			HttpSession session = ServletActionContext.getRequest().getSession();
			//获取购物车里的图书信息
			Map<String, BuyCar> map = (Map<String, BuyCar>)session.getAttribute("map");
			//获取order
			Order order = (Order)session.getAttribute("order");
			BookDao bookDao = MybatisUtil.getSqlSession().getMapper(BookDao.class);
			ItemDao itemDao = MybatisUtil.getSqlSession().getMapper(ItemDao.class);
			Set<String> keySet = map.keySet();
			for (String key : keySet) {
				BuyCar buyCar = map.get(key);
				if(buyCar.getStatus()=="1"){
					
					Item item = new Item();
					//uuid给id赋值
					String uuid = UUID.randomUUID().toString();
					item.setId(uuid);
					//购物车项里的图书信息给到item对象
					item.setBookName(buyCar.getBook().getBookName());
					item.setBookSrc(buyCar.getBook().getSrc());
					item.setPrice(buyCar.getBook().getDdPrice());
					item.setCount(buyCar.getNumber());
					item.setAmount(buyCar.getSubTotal());
					item.setBookId(buyCar.getBook().getId());
					item.setOrderId(order.getId());
					
					itemDao.insert(item);
					//修改图书
					Book book = new Book();
					book.setId(buyCar.getBook().getId());
					book.setSaleCount(buyCar.getBook().getSaleCount()+buyCar.getNumber());
					book.setStock(buyCar.getBook().getStock()-buyCar.getNumber());
					bookDao.update(book);
					
					//清空购物车
					//session.removeAttribute("map");
				}
			}
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}

	}

	//根据订单id查一个
	@Override
	public List<Item> checkByOrder(String orderId) {
		try {
			ItemDao itemDao = MybatisUtil.getSqlSession().getMapper(ItemDao.class);
			List<Item> checkByOrder = itemDao.checkByOrder(orderId);
			
			return checkByOrder;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
	}

}
