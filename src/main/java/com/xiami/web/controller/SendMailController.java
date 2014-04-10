package com.xiami.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SendMailController {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
	
	@RequestMapping(value="/sendMail",method=RequestMethod.POST)
	@ResponseBody
	public String sendMail(HttpServletRequest request) {
		System.out.println("enter the sendMail Controller.......");
		String rst = "";
		
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(new String[]{"944314588@qq.com","875815934@qq.com"});
			mailMessage.setSubject("测试邮件的收发");
			mailMessage.setFrom("13197367227@163.com");
			mailMessage.setText("[来自足球数据中心的错误提交]" + sdf.format(new Date()) +  "\r\n"
			                    + "提交者：谢超\r\n" 
						        + "提交者联系方式:" + email + "\r\n"
						        + "错误描述:" + content);
			System.out.println(javaMailSender == null);
			javaMailSender.send(mailMessage);
			rst = "success";
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rst;
	}

}
