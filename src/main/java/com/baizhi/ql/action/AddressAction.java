package com.baizhi.ql.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.ql.entity.Address;
import com.baizhi.ql.entity.User;
import com.baizhi.ql.serviceImpl.AddressServiceImpl;

public class AddressAction {
	
	//添加地址的地址对象,查一个的对象
	private Address address;
	//根据用户id查所有list
	private List<Address> list;
	//？后接收的id
	private String id;
	
	//根据用户id查所有
	public String checkAll(){
		//获取用户id
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("suser");
		String userId = user.getId();
		AddressServiceImpl impl = new AddressServiceImpl();
		list = impl.checkAll(userId);
		return "checkAll";
	}
	
	//查一个
	public String checkOne(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		AddressServiceImpl impl = new AddressServiceImpl();
		address = impl.checkOne(address.getId());
		session.setAttribute("address", address);
		return "checkOne";
	}
	
	//下一步进行判断是修改还是添加
	public String next(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		AddressServiceImpl impl = new AddressServiceImpl();

		if(id!="0"){
			//修改
			impl.update(address);
		}else{
			//添加
			impl.addOne(address);
		}
		session.setAttribute("address", address);
		return "next";
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Address> getList() {
		return list;
	}

	public void setList(List<Address> list) {
		this.list = list;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
