package com.yy.aipay.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
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
@RequestMapping("/upload")
public class UploadController {

	@Resource(name = "aCodeService")
	private ACodeService aService;

	@Resource(name = "qCodeService")
	private QCodeService qService;
	@Resource(name = "wCodeService")
	private WCodeService wService;
	@Resource(name = "zCodeService")
	private ZCodeService zService;

	/**
	 * 上传QQ二维码
	 * 
	 * @param file
	 * @param request
	 * @return result:状态,message:信息
	 */
	@RequestMapping("q")
	@ResponseBody
	public Object doQ(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
		String path = request.getSession().getServletContext()
				.getRealPath("statics" + File.separator + "images" + File.separator + "code");
		Map<String, String> map = new HashMap<String, String>();
		if (!file.isEmpty()) {
			try {
				String fileName_old = file.getOriginalFilename();// 获取文件名
				String filePath = path + File.separator + "temp" + File.separator + UUID.randomUUID() + "."
						+ FilenameUtils.getExtension(fileName_old);
				File file2 = new File(filePath);
				file.transferTo(file2);
				// 解析并生成二维码
				Map<String, String> qinfo = null;
				try {
					qinfo = qService.getInfo(filePath);
				} catch (Exception e) {
					map.put("result", "error");
					map.put("message", "请上传QQ收款码!");
				}
				if (qService.getQUserByid(qinfo.get("qid")) == null) {
					Quser quser = new Quser();
					quser.setQid(qinfo.get("qid"));
					quser.setQname(qinfo.get("qname"));
					quser.setQfile(qService.createQcode(path + File.separator + "q" + File.separator));
					qService.addQuser(quser);
					map.put("result", "true");
					map.put("qid", quser.getQid());
				} else {
					map.put("result", "error");
					map.put("message", "该二维码已存在!");
				}
				file2.delete();
			} catch (Exception e) {
				map.put("result", "error");
				map.put("message", e.toString());
			}
		} else {
			map.put("result", "error");
			map.put("message", "文件不能为空!");
		}
		return JSON.toJSONString(map);
	}

	@RequestMapping("w")
	@ResponseBody
	public Object doW(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
		String path = request.getSession().getServletContext()
				.getRealPath("statics" + File.separator + "images" + File.separator + "code");
		Map<String, String> map = new HashMap<String, String>();
		if (!file.isEmpty()) {
			try {
				String fileName_old = file.getOriginalFilename();// 获取文件名
				String filePath = path + File.separator + "temp" + File.separator + UUID.randomUUID() + "."
						+ FilenameUtils.getExtension(fileName_old);
				File file2 = new File(filePath);
				file.transferTo(file2);
				// 解析并生成二维码
				String wid = "";
				try {
					wid = wService.getInfo(filePath);
				} catch (Exception e) {
					map.put("result", "error");
					map.put("message", "请上传微信收款码!!");
				}
				if (wService.getWUserById(wid) == null) {
					Wuser wuser = new Wuser();
					wuser.setWid(wid);
					wuser.setWfile(wService.createWcode(path + File.separator +"w"+File.separator));
					wService.addWuser(wuser);
					map.put("result", "true");
					map.put("wid", wuser.getWid());
				} else {
					map.put("result", "error");
					map.put("message", "该二维码已存在!");
				}
				file2.delete();
			} catch (Exception e) {
				map.put("result", "error");
				map.put("message", e.toString());
			}
		} else {
			map.put("result", "error");
			map.put("message", "文件不能为空!");
		}
		return JSON.toJSONString(map);
	}

	@RequestMapping("z")
	@ResponseBody
	public Object doZ(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
		String path = request.getSession().getServletContext()
				.getRealPath("statics" + File.separator + "images" + File.separator + "code");
		Map<String, String> map = new HashMap<String, String>();
		if (!file.isEmpty()) {
			try {
				String fileName_old = file.getOriginalFilename();// 获取文件名
				String filePath = path + File.separator + "temp" + File.separator + UUID.randomUUID() + "."
						+ FilenameUtils.getExtension(fileName_old);
				File file2 = new File(filePath);
				file.transferTo(file2);
				// 解析并生成二维码
				String zid = "";
				try {
					zid = zService.getUrl(filePath);
				} catch (Exception e) {
					map.put("result", "error");
					map.put("message", "请上传支付宝收款码!!");
				}
				if (zService.findById(zid) == null) {
					Zuser zuser = new Zuser();
					zuser.setZid(zid);
					zuser.setZfile("HTTPS://QR.ALIPAY.COM/" + zid);
					zService.addZuser(zuser);
					map.put("result", "true");
					map.put("zid", zuser.getZid());
				} else {
					map.put("result", "error");
					map.put("message", "该二维码已存在!");
				}
				file2.delete();
			} catch (Exception e) {
				map.put("result", "error");
				map.put("message", e.toString());
			}
		} else {
			map.put("result", "error");
			map.put("message", "文件不能为空!");
		}
		return JSON.toJSONString(map);
	}

	@RequestMapping("/a")
	public String doA(@RequestParam(value = "qid") String qid, @RequestParam(value = "wid") String wid,
			@RequestParam(value = "zid") String zid, HttpServletRequest request, Model model) {
		String path = request.getSession().getServletContext()
				.getRealPath("statics" + File.separator + "images" + File.separator + "code");
		String url = "http://" + "yaolovelive.site" + ":6060/aipay/";
		Auser auser = new Auser();
		String aid = UUID.randomUUID().toString();
		auser.setAid(aid);
		auser.setQid(qid);
		auser.setWid(wid);
		auser.setZid(zid);
		auser.setAfile(QRCodeUtil.createQrcode(url + aid, path + File.separator + "a" + File.separator));
		aService.addAuser(auser);
		model.addAttribute("url", auser.getAfile());
		return "created";
	}

}
