package com.yy.aipay.dao;

import org.apache.ibatis.annotations.Param;

import com.yy.aipay.pojo.Auser;

public interface AuserMapper {
	
	int addAuser(Auser auser);
	
	Auser findById(@Param("aid") String aid);
}
