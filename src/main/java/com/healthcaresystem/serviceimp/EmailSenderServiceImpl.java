package com.healthcaresystem.serviceimp;

import com.healthcaresystem.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {
    private final JavaMailSender mailSender;


    public EmailSenderServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    public void sendMail(String toEmail,
                        String subject,
                         String body){
        SimpleMailMessage message= new SimpleMailMessage();
        message.setFrom("bashmaistro@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);

        System.out.println("Mail Sent successfully:" + " to " + toEmail );
    }
}
