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
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
	
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
			mailMessage.setSubject("�����ʼ����շ�");
			mailMessage.setFrom("13197367227@163.com");
			mailMessage.setText("[���������������ĵĴ����ύ]" + sdf.format(new Date()) +  "\r\n"
			                    + "�ύ�ߣ�л��\r\n" 
						        + "�ύ����ϵ��ʽ:" + email + "\r\n"
						        + "��������:" + content);
			System.out.println(javaMailSender == null);
			javaMailSender.send(mailMessage);
			rst = "success";
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rst;
	}

}
