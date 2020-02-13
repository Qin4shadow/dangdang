package com.baizhi.ql.dao;

import com.baizhi.ql.entity.Admin;

public interface AdminDao {
	//登陆
	Admin checkByUsername(String username);
}
