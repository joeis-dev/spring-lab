package dev.joeis.spring.basics.controllers;

import dev.joeis.spring.basics.mail.MailSender;
import dev.joeis.spring.basics.mail.MailSenderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailSenderController {
    MailSender mailSender;

    // method 1: injects the whole bean directly into this reference (there's only 1 bean defined
    // for MailSender interface in the context app)
    // @Autowired
//    MailSender mailSender;

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
//    @Autowired
//    public MailSenderController(MailSender smtp) {
//        this.mailSender = smtp;
//    }
//
    // alternative: use its bean's default ids (MailSMTP, MailPOP3 -> mailPOP3)
//    @Autowired
//    public MailSenderController(MailSender mailSMTP) {
//        this.mailSender = mailSMTP;
//    }

    // Injection via @Primary: even if a custom bean id is set on smtp the priority to choose the right one
    // suggest that MailSenderImpl will be picked as it has @Primary on its definition.
//    @Autowired
//    public MailSenderController(MailSender smtp) {
//        this.mailSender = smtp;
//    }

    // Injection via @Qualifier: this ambiguity resolver overrides the default preference from @Primary
    // and select the specific bean provided.
//    @Autowired
//    public MailSenderController(@Qualifier("myQualifierBean") MailSender mail) {
//        this.mailSender = mail;
//    }

    @Autowired
    public MailSenderController(MailSender mockMailFromConfig) {
        this.mailSender = mockMailFromConfig;
    }

    /***
     * There are others ways to inject dependencies like @Injection or @Resource but @Autowired becomes
     * the facto and the recommended way to go from Spring Framework team. */

    @RequestMapping("/send")
    public String sendMail() {
        mailSender.send("test@joeis.dev", "Spring framework basics", "Lorem ipsum...");
        return "Mail Sent";
    }
}