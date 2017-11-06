package com.yy.aipay.dao;

import org.apache.ibatis.annotations.Param;

import com.yy.aipay.pojo.Zuser;

public interface ZuserMapper {
	
	int addZuser(Zuser zuser);
	Zuser findById(@Param("zid") String zid);
}
