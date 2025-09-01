package dev.joeis.spring.basics.controllers;

import dev.joeis.spring.basics.mail.MailSender;
import dev.joeis.spring.basics.mail.MailSenderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailSenderController {

    // method 1: injects the whole bean directly into this reference
    // @Autowired
    MailSender mailSender;

    // method 2: Injects only the required method from the bean referenced
//    @Autowired
//    public void setMailSender(MailSender mailSender) {
//        this.mailSender = mailSender;
//    }

    // method 3: injects the bean in the constructor
//    @Autowired
//    public MailSenderController(MailSender mailSender) {
//       this.mailSender = mailSender;
//    }

    // study case 1: N beans from the same interface can collide if we don't specify which one is the required.
    // solution recommended: set bean's id when defined them as components -> @Component(name="myBeanId")
    @Autowired
    public MailSenderController(MailSender smtp) {
        this.mailSender = smtp;
    }

    // alternative: use its bean's default ids (MailSMTP, MailPOP3 -> mailPOP3)
//    @Autowired
//    public MailSenderController(MailSender mailSMTP) {
//        this.mailSender = mailSMTP;
//    }

    @RequestMapping("/send")
    public void sendMail() {
        mailSender.send("test@joeis.dev", "Spring framework basics", "Lorem ipsum...");
    }
}