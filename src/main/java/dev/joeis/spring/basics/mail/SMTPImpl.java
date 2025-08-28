package dev.joeis.spring.basics.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SMTPImpl implements MailSender {

    private static final Logger log = LoggerFactory.getLogger(SMTPImpl.class);

    @Override
    public void send(String to, String subject, String body) {
        log.info("📤 Sending email... ");
        log.info("\uD83E\uDDD1\uD83C\uDFFD To: {}", to);
        log.info("\uD83D\uDCD5 Subject: {}", subject);
        log.info("\uD83D\uDCDC Body message: {}", body);
    }
}
