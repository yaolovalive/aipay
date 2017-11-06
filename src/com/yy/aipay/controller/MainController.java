package com.yy.aipay.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yy.aipay.pojo.Auser;
import com.yy.aipay.pojo.Quser;
import com.yy.aipay.pojo.Wuser;
import com.yy.aipay.pojo.Zuser;
import com.yy.aipay.service.ACodeService;
import com.yy.aipay.service.QCodeService;
import com.yy.aipay.service.WCodeService;
import com.yy.aipay.service.ZCodeService;

@Controller
public class MainController {

	@Resource(name = "aCodeService")
	private ACodeService aService;

	@Resource(name = "qCodeService")
	private QCodeService qService;
	@Resource(name = "wCodeService")
	private WCodeService wService;
	@Resource(name = "zCodeService")
	private ZCodeService zService;

	@RequestMapping(value = { "/index.html", "/" })
	public String showIndex() {

		return "index";
	}

	@RequestMapping("/{id}")
	public String showPay(HttpServletRequest request, @PathVariable(value = "id") String aid, Model model) {
		String header = request.getHeader("User-Agent");
		Auser auser = new Auser();
		if (aid != null && !"".equals(aid)) {
			auser = aService.findById(aid);
		}
		/*
		 * 腾讯收款码
		 */
		if (header.indexOf("MQQBrowser") > -1) {
			/**
			 * QQ
			 */
			if (header.lastIndexOf("QQ/") > -1) {
				Quser quser = qService.getQUserByid(auser.getQid());
				model.addAttribute("quser", quser);
			} else if (header.lastIndexOf("MicroMessenger/") > -1) {
				/**
				 * 微信
				 */
				Wuser wuser = wService.getWUserById(auser.getWid());
				model.addAttribute("wuser", wuser);
			}
			return "code";
		} else {
			/**
			 * 跳转支付宝
			 */
			Zuser zuser = zService.findById(auser.getZid());
			return "redirect:" + zuser.getZfile();
		}
	}

}
