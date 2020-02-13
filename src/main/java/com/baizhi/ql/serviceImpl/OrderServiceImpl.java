package com.baizhi.ql.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.ql.dao.OrderDao;
import com.baizhi.ql.entity.Address;
import com.baizhi.ql.entity.Order;
import com.baizhi.ql.service.OrderService;
import com.baizhi.ql.util.MybatisUtil;
import com.baizhi.ql.util.SnowflakeIdWorker;

public class OrderServiceImpl implements OrderService {

	//添加
	@Override
	public void insert() {
		try {
			HttpSession session = ServletActionContext.getRequest().getSession();
			//获取地址
			Address address = (Address)session.getAttribute("address");
			//获取总价
			Double totalPrice = (Double)session.getAttribute("totalPrice");
			//新建一个order对象
			Order order = new Order();
			//用uuid添加id
			String uuid = UUID.randomUUID().toString();
			order.setId(uuid);
			//使用雪花算法给订单编号
			String orderNumber = SnowflakeIdWorker.getOrderNumber();
			order.setOrderNumber(orderNumber);
			//将地址是里的有用信息添加进order对象里
			order.setOrderTimes(new Date());
			order.setAddrUser(address.getName());
			order.setAddrName(address.getDetail());
			order.setTotalPrice(totalPrice);
			order.setStatus("未支付");
			order.setAddrId(address.getId());
			order.setUserId(address.getUserId());
			
			OrderDao orderDao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
			orderDao.insert(order);
			
			session.setAttribute("order", order);
			
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}

	}

	//查所有
	@Override
	public List<Order> checkAll() {
		try {
			OrderDao orderDao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
			List<Order> checkAll = orderDao.checkAll();
			
			return checkAll;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
	}

	//修改状态
	@Override
	public void update(Order order) {
		try {
			OrderDao orderDao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
			order.setStatus("已支付");
			orderDao.update(order);
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
	}

	//查一个
	@Override
	public Order checkOne(String id) {
		try {
			OrderDao orderDao = MybatisUtil.getSqlSession().getMapper(OrderDao.class);
			Order checkOne = orderDao.checkOne(id);
			
			return checkOne;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
	}

}
