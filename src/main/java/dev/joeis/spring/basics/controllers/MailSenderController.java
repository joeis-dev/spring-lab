package dev.joeis.spring.basics.controllers;

import dev.joeis.spring.basics.mail.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailSenderController {
    MailSender mailSender;

    @Autowired
    public MailSenderController(MailSender mail) {
        this.mailSender = mail;
    }

    @RequestMapping("/send")
    public String sendMail(@Value("${app.name}") String appName) {
        mailSender.send("test@joeis.dev", "Spring framework basics", "Lorem ipsum...");
        return "Mail Sent from: " + appName;
    }
}