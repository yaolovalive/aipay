package com.yy.aipay.service;


import com.yy.aipay.pojo.Wuser;

public interface WCodeService {
	/**
	 * 获取微信用户信息
	 * @param filePath	全二维码路径
	 * @return	wid:ID
	 */
	String getInfo(String filePath);
	/**
	 * 持久化操作
	 * @param quser
	 * @return
	 */
	boolean addWuser(Wuser wuser);
	
	String createWcode(String filePath);
	
	Wuser getWUserById(String wid);
	
}
