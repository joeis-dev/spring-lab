package dev.joeis.spring.basics.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// @Component: creates a default bean identified by mailSMTP
// Recommended: define a custom id
@Qualifier("myQualifierBean")

// Providing a specific default name ONLY for this bean so it can be injected
// by referencing its new id.
@Component("smtp")
public class MailSMTP implements MailSender {

    private static final Logger log = LoggerFactory.getLogger(MailSMTP.class);

    @Override
    public void send(String to, String subject, String body) {
        log.info("📤 Sending email (SMTP protocol)... ");
        log.info("\uD83E\uDDD1\uD83C\uDFFD To: {}", to);
        log.info("\uD83D\uDCD5 Subject: {}", subject);
        log.info("\uD83D\uDCDC Body message: {}", body);
    }
}
