package com.yy.aipay.service;

import java.util.Map;

import com.yy.aipay.pojo.Quser;

public interface QCodeService {
	/**
	 * 获取QQ用户信息
	 * @param filePath	全二维码路径
	 * @return	qid:qname
	 */
	Map<String, String> getInfo(String filePath);
	/**
	 * 持久化操作
	 * @param quser
	 * @return
	 */
	boolean addQuser(Quser quser);
	
	String createQcode(String filePath);
	
	Quser getQUserByid(String qid);
}
