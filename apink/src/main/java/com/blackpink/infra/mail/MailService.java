package com.blackpink.infra.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
    public void sendMailSimple() {
    	SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    	
    	simpleMailMessage.setTo("dlaudfh01@naver.com");
    	simpleMailMessage.setSubject("안녕하세요");
    	simpleMailMessage.setText("새로운 회원가입이 완료되었습니다.");

    	javaMailSender.send(simpleMailMessage);

    }

	
}
