package com.baizhi.ql.service;

import com.baizhi.ql.entity.Admin;

public interface AdminService {
	//登陆
	String checkByUsername(Admin admin,String clientCode);
}
