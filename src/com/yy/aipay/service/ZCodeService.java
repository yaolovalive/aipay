package com.yy.aipay.service;

import org.apache.ibatis.annotations.Param;
import com.yy.aipay.pojo.Zuser;

public interface ZCodeService {
	
	String getUrl(String filePath);
	
	boolean addZuser(Zuser zuser);
	
	Zuser findById(@Param("zid") String zid);
	
	
}
