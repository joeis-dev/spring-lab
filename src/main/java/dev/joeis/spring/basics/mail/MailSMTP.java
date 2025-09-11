package dev.joeis.spring.basics.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

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
