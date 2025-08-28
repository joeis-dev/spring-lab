package dev.joeis.spring.basics.controllers;

import dev.joeis.spring.basics.mail.MailSender;
import dev.joeis.spring.basics.mail.MailSenderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailSenderController {

    @Autowired
    MailSender mailSender;

    @RequestMapping("/send")
    public void sendMail() {
        mailSender.send("joe@joeis.dev", "Spring framework basics", "Lorem ipsum...");
    }
}
