package com.yy.aipay.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.yy.aipay.dao.QuserMapper;
import com.yy.aipay.pojo.Quser;
import com.yy.aipay.service.QCodeService;
import com.yy.aipay.util.QRCodeUtil;

@Service("qCodeService")
public class QCodeServiceImpl implements QCodeService {

	@Resource
	private QuserMapper quserMapper;
	
	private String url;
	
	@Override
	public Map<String, String> getInfo(String filePath) {
		Map<String, String> map = new HashMap<String, String>();
		String str = QRCodeUtil.decodeQr(filePath);
		url = str;
		String qid = str.substring(str.indexOf("ac=") + 3, str.lastIndexOf("&n="));
		String qname = str.substring(str.indexOf("n=") + 2, str.lastIndexOf("&f="));
		map.put("qid", qid);
		map.put("qname", qname);
		return map;
	}
	
	@Override
	public String createQcode(String filePath) {
		
		return QRCodeUtil.createQrcode(url, filePath);
	}
	
	
	@Override
	public boolean addQuser(Quser quser) {
		if (quserMapper.addQuser(quser) > 0)
			return true;
		else
			return false;
	}

	@Override
	public Quser getQUserByid(String qid) {
		
		return quserMapper.findById(qid);
	}


}
