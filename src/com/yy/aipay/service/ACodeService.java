package com.yy.aipay.service;

import org.apache.ibatis.annotations.Param;

import com.yy.aipay.pojo.Auser;

public interface ACodeService {
	
	boolean addAuser(Auser auser);
	
	Auser findById(@Param("aid") String aid);
	
	String createCode(String text,String filePath);
}
