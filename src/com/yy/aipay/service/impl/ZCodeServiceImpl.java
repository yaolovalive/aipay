package com.yy.aipay.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yy.aipay.dao.ZuserMapper;
import com.yy.aipay.pojo.Zuser;
import com.yy.aipay.service.ZCodeService;
import com.yy.aipay.util.QRCodeUtil;

@Service("zCodeService")
public class ZCodeServiceImpl implements ZCodeService {

	@Resource(name = "zuserMapper")
	private ZuserMapper zDao;

	@Override
	public boolean addZuser(Zuser zuser) {
		if (zDao.addZuser(zuser) > 0)
			return true;
		else
			return false;
	}

	@Override
	public Zuser findById(String zid) {

		return zDao.findById(zid);
	}

	@Override
	public String getUrl(String filePath) {
		String str = QRCodeUtil.decodeQr(filePath);
		return str.substring(str.lastIndexOf("/"), str.length());
	}

}
