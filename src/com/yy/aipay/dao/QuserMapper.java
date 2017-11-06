package com.yy.aipay.dao;

import org.apache.ibatis.annotations.Param;

import com.yy.aipay.pojo.Quser;

public interface QuserMapper {
	
	int addQuser(Quser quser);
	
	Quser findById(@Param("qid") String qid);
}
