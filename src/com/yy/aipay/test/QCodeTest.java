package com.yy.aipay.test;

import java.io.File;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yy.aipay.pojo.Auser;
import com.yy.aipay.pojo.Quser;
import com.yy.aipay.service.ACodeService;
import com.yy.aipay.service.QCodeService;
import com.yy.aipay.service.WCodeService;
import com.yy.aipay.service.ZCodeService;
import com.yy.aipay.util.QRCodeUtil;

public class QCodeTest {

	@Test
	public void createCode() {

		String str = "https://i.qianbao.qq.com/wallet/sqrcode.htm?m=tenpay&a=1&u=740362041&ac=B79BAF41E57503C149AA4B691EF2140E645D9EB19694D9C7F2B6E1F1A8800BA9&n=云烟&f=wallet";
		System.out.println(QRCodeUtil.createQrcode(str, "D:\\"));

	}

	@Test
	public void createMyCode() {

		System.out.println(QRCodeUtil.createQrcode("http://192.168.2.239:8080/aipay/" + UUID.randomUUID(), "D:\\"));

	}

}
