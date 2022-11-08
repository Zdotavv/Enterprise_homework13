package com.zdotavv.enterprise_homework10.service.implementation;

import com.zdotavv.enterprise_homework10.model.Person;
import com.zdotavv.enterprise_homework10.service.interfaces.EmailService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    @Override
    public void sendRegistrationEmail(Person person) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(person.getEmail());
            helper.setSubject("Registration in online shop");
            helper.setText("Dear, " + person.getFirstName() + "!<br>" +
                    "You are successfully registered in our online shop.<br>" +
                    "You can start shopping by this link: " +
                    "<a href=\"http://localhost:8080/login\" target=\"_blank\">Log in</a>", true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
