package com.baizhi.ql.action;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.ql.entity.Book;
import com.baizhi.ql.entity.BuyCar;
import com.baizhi.ql.serviceImpl.BookServiceImpl;

public class BuyCarAction {
	//购物车:获取图书id
	private String id;
	//购物车:购物车里所有图书集合
	private Collection<BuyCar> cars;
	//购物车:获取修改后的商品数量
	private Integer count;
	
	
	//购物车:恢复状态
	public String recover(){
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Object obj = session.getAttribute("map");
		//<String, BuyCar>图书id，购物车对象
		Map<String, BuyCar> map = (Map<String, BuyCar>)obj;
		BuyCar buyCar = map.get(id);
		buyCar.setStatus("1");
		map.put(id, buyCar);
		session.setAttribute("map", map);
		compute(map);
		return "recover";
	}
	
	//购物车:修改状态
	public String delete(){
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Object obj = session.getAttribute("map");
		//<String, BuyCar>图书id，购物车对象
		Map<String, BuyCar> map = (Map<String, BuyCar>)obj;
		BuyCar buyCar = map.get(id);
		buyCar.setStatus("0");
		map.put(id, buyCar);
		session.setAttribute("map", map);
		compute(map);
		return "delete";
	}
	
	
	//购物车:修改数量
	public String update(){
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Object obj = session.getAttribute("map");
		//<String, BuyCar>图书id，购物车对象
		Map<String, BuyCar> map = (Map<String, BuyCar>)obj;
		BuyCar buyCar = map.get(id);
		//把修改后的数量放入buyCar
		buyCar.setNumber(count);
		//修改小计
		buyCar.setSubTotal(buyCar.getBook().getDdPrice()*buyCar.getNumber() );
		map.put(id, buyCar);
		session.setAttribute("map", map);
		compute(map);
		return "update";
		
	}
	
	
	//购物车:查看购物车
	public String showBuyCar(){
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Object obj = session.getAttribute("map");
		//<String, BuyCar>图书id，购物车对象
		Map<String, BuyCar> map = (Map<String, BuyCar>)obj;
		if(map==null){
			map = new HashMap<String, BuyCar>();
		}
		cars = map.values();
		session.setAttribute("map", map);
		compute(map);
		return "showBuyCar";
	}
	
	
	//购物车:添加图书到购物车
	public String addBuyCar(){
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Object obj = session.getAttribute("map");
		//<String, BuyCar>图书id，购物车对象
		Map<String, BuyCar> map = (Map<String, BuyCar>)obj;
		BuyCar car = null;
		if(map==null){
			//map不存在，新建map，添加id对应的图书
			map = new HashMap<String, BuyCar>();
			BookServiceImpl bsi = new BookServiceImpl();
			Book checkOne = bsi.checkOne(id);
			car = new BuyCar(checkOne, 1,"1",checkOne.getDdPrice());
			map.put(id, car);
		}else{
			if(map.containsKey(id)){
				car = map.get(id);
				if(car.getStatus()=="0"){
					car.setStatus("1");
					car.setNumber(1);
				}else{
					car.setNumber(car.getNumber() + 1);
					car.setSubTotal(car.getBook().getDdPrice()*car.getNumber());
				}
			}else{
				BookServiceImpl bsi = new BookServiceImpl();
				Book checkOne = bsi.checkOne(id);
				car = new BuyCar(checkOne, 1,"1",checkOne.getDdPrice());
				map.put(id, car);
			}
		}
		session.setAttribute("map", map);
		compute(map);
		return "addBuyCar";
	}
	
	//购物车:计算总价和节省的方法
	public void compute(Map<String, BuyCar> map){
		//遍历map
		Set<String> keySet = map.keySet();
		//总价
		Double totalPrice=0.0;
		//节省
		Double savePrice=0.0;
		for (String key : keySet) {
			BuyCar buyCar = map.get(key);
				if(buyCar.getStatus()=="1"){
				totalPrice += buyCar.getBook().getDdPrice()*buyCar.getNumber();
				savePrice += (buyCar.getBook().getPrice()-buyCar.getBook().getDdPrice())*buyCar.getNumber();
			}
		}
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		session.setAttribute("totalPrice", totalPrice);
		session.setAttribute("savePrice", savePrice);
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Collection<BuyCar> getCars() {
		return cars;
	}


	public void setCars(Collection<BuyCar> cars) {
		this.cars = cars;
	}


	public Integer getCount() {
		return count;
	}


	public void setCount(Integer count) {
		this.count = count;
	}
	
		
		
}
