package com.yy.aipay.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yy.aipay.dao.AuserMapper;
import com.yy.aipay.pojo.Auser;
import com.yy.aipay.service.ACodeService;
import com.yy.aipay.util.QRCodeUtil;

@Service("aCodeService")
public class ACodeServiceImpl implements ACodeService {

	@Resource(name = "auserMapper")
	private AuserMapper aDao;

	@Override
	public boolean addAuser(Auser auser) {
		if (aDao.addAuser(auser) > 0)
			return true;
		else
			return false;
	}

	@Override
	public Auser findById(String aid) {
		
		return aDao.findById(aid);
	}

	@Override
	public String createCode(String text, String filePath) {

		return QRCodeUtil.createQrcode(text, filePath);
	}

}
