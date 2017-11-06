package com.yy.aipay.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.yy.aipay.dao.WuserMapper;
import com.yy.aipay.pojo.Wuser;
import com.yy.aipay.service.WCodeService;
import com.yy.aipay.util.QRCodeUtil;

@Service("wCodeService")
public class WCodeServiceImpl implements WCodeService {

	@Resource
	private WuserMapper wuserMapper;
	
	private String url;
	
	@Override
	public String getInfo(String filePath) {
		String str = QRCodeUtil.decodeQr(filePath);
		url = str;
		String wid = str.substring(6);
		return wid;
	}
	
	@Override
	public String createWcode(String filePath) {
		
		return QRCodeUtil.createQrcode(url, filePath);
	}
	
	
	@Override
	public boolean addWuser(Wuser wuser) {
		if (wuserMapper.addWuser(wuser) > 0)
			return true;
		else
			return false;
	}

	@Override
	public Wuser getWUserById(String wid) {
		
		return wuserMapper.findById(wid);
	}
}
