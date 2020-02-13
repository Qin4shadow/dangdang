package com.baizhi.ql.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.baizhi.ql.dao.AddressDao;
import com.baizhi.ql.entity.Address;
import com.baizhi.ql.entity.User;
import com.baizhi.ql.service.AddressService;
import com.baizhi.ql.util.MybatisUtil;

public class AddressServiceImpl implements AddressService {

	//添加
	@Override
	public void addOne(Address address) {
		try {
			AddressDao addressDao = MybatisUtil.getSqlSession().getMapper(AddressDao.class);
			//添加Id
			String uuid = UUID.randomUUID().toString();
			address.setId(uuid);
			//获取当前用户id
			User user = (User)ServletActionContext.getRequest().getSession(false).getAttribute("suser");
			address.setUserId(user.getId());
			
			addressDao.addOne(address);
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}

	}

	//根据用户id查所有
	@Override
	public List<Address> checkAll(String userId) {
		try {
			AddressDao addressDao = MybatisUtil.getSqlSession().getMapper(AddressDao.class);
			List<Address> checkAll = addressDao.checkAll(userId);
			return checkAll;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
	}

	//查一个
	@Override
	public Address checkOne(String id) {
		try {
			AddressDao addressDao = MybatisUtil.getSqlSession().getMapper(AddressDao.class);
			Address checkOne = addressDao.checkOne(id);
			return checkOne;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
		
	}

	//修改
	@Override
	public void update(Address address) {
		try {
			AddressDao addressDao = MybatisUtil.getSqlSession().getMapper(AddressDao.class);
			
			addressDao.update(address);
			MybatisUtil.commit();
		} catch (Exception e) {
			e.printStackTrace();
			MybatisUtil.rollback();
			throw new RuntimeException(e);
		}finally{
			MybatisUtil.close();
		}
		
	}

}
