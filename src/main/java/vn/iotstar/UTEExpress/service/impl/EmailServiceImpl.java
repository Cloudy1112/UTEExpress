package vn.iotstar.UTEExpress.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import vn.iotstar.UTEExpress.service.IEmailService;
@Service
public class EmailServiceImpl  implements IEmailService {

	 @Autowired
	    private JavaMailSender javaMailSender;

	    @Override
	    public void sendOtp(String email, String otp) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(email);
	        message.setSubject("Lấy lại mật khẩu của UTEEXPRESS");
	        message.setText("Your OTP code is: " + otp);
	        
	        // Gửi email
	        javaMailSender.send(message);
	    }
	    @Override
	    public void sendRegisterOtp(String email, String otp) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(email);
	        message.setSubject("Xác nhận đăng kí tài khoản");
	        message.setText("Your OTP code is: " + otp);
	        
	        // Gửi email
	        javaMailSender.send(message);
	    }
}