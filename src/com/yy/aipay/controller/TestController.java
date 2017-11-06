package com.yy.aipay.controller;

import java.io.File;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yy.aipay.pojo.Auser;
import com.yy.aipay.pojo.Quser;
import com.yy.aipay.pojo.Wuser;
import com.yy.aipay.pojo.Zuser;
import com.yy.aipay.service.ACodeService;
import com.yy.aipay.service.QCodeService;
import com.yy.aipay.service.WCodeService;
import com.yy.aipay.service.ZCodeService;
import com.yy.aipay.util.QRCodeUtil;

@Controller
@RequestMapping("/qtest")
public class TestController {

	@Resource(name = "aCodeService")
	private ACodeService aService;

	@Resource(name = "qCodeService")
	private QCodeService qService;
	@Resource(name = "wCodeService")
	private WCodeService wService;
	@Resource(name = "zCodeService")
	private ZCodeService zService;

	@RequestMapping("/test")
	public String addUser(HttpServletRequest request,Model model) {
		String path = request.getSession().getServletContext().getRealPath("statics\\images\\code");
		boolean flag = true;
		// 添加QQ
		// --获取ID
		String qfile_old_str = path + "\\" + "temp\\" + "q.jpg";
		Map<String, String> qinfo = qService.getInfo(qfile_old_str);
		if (qService.getQUserByid(qinfo.get("qid")) == null) {
			Quser quser = new Quser();
			quser.setQid(qinfo.get("qid"));
			quser.setQname(qinfo.get("qname"));
			quser.setQfile(qService.createQcode(path + "\\q\\"));
			qService.addQuser(quser);
		} else {
			flag = false;
		}
		File qfile_old = new File(qfile_old_str);
		qfile_old.delete();
		// 添加微信
		String wfile_old_str = path + "\\" + "temp\\" + "w.jpg";
		String wid = wService.getInfo(wfile_old_str);
		if (wService.getWUserById(wid) == null) {
			Wuser wuser = new Wuser();
			wuser.setWid(wid);
			wuser.setWfile(wService.createWcode(path + "\\w\\"));
			wService.addWuser(wuser);
		} else {
			flag = false;
		}
		// 添加支付宝
		String zfile_old_str = path + "\\" + "temp\\" + "z.png";
		String zid = zService.getUrl(zfile_old_str);
		if (zService.findById(zid) == null) {
			Zuser zuser = new Zuser();
			zuser.setZid(zid);
			zuser.setZfile("HTTPS://QR.ALIPAY.COM/" + zid);
			zService.addZuser(zuser);
		} else {
			flag = false;
		}

		if (flag) {
			String url = "http://"+"192.168.2.239"+":8080/aipay/";
			Auser auser = new Auser();
			String aid = UUID.randomUUID().toString();
			auser.setAid(aid);
			auser.setQid(qinfo.get("qid"));
			auser.setWid(wid);
			auser.setZid(zid);
			auser.setAfile(QRCodeUtil.createQrcode(url+aid, path + "\\a\\"));
			aService.addAuser(auser);
			model.addAttribute("url", auser.getAfile());
		}
		System.out.println("over");
		return "created";
	}

}
