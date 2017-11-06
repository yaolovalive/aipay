package com.yy.aipay.dao;

import org.apache.ibatis.annotations.Param;

import com.yy.aipay.pojo.Wuser;

public interface WuserMapper {
	
	int addWuser(Wuser wuser);	
	Wuser findById(@Param("wid") String wid);
}
