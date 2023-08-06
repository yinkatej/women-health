package com.healthcaredelivery.healthcareblog.service;

import com.healthcaredelivery.healthcareblog.entity.Email;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.TemplateEngine;

@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private SpringTemplateEngine templateEngine;

    @Value("HealthBot") private String sender;
    @Override
    public String sendSimpleMail(String toEmail, String subject, String body, String name,  String title, String url) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try{
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(toEmail);
            mimeMessageHelper.setSubject(subject);


            Context context = new Context();
            context.setVariable("name", name);
            context.setVariable("url", url);
            context.setVariable("title", title);

            String emailContent = templateEngine.process("emailTemp.html", context);
            mimeMessageHelper.setText(body);


            javaMailSender.send(mimeMessage);

        }catch (Exception e){

        }
        return "Mail sent successfully";

    }

    @Override
    public String sendEmailWithAttachment(Email email) {
        return null;
    }
}
