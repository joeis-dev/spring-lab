package dev.joeis.spring.basics.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

/**
 * The purpose of configuration classes is to define and expose beans and its dependencies into
 * the Spring Context Application by using IoC, the @Bean creates a Singleton subclass for each one
 * and act as proxy to intercept to their methods. Defaults (ie the bean's name) is the same as the method. */
public class MailConfig {

    @Bean("mockMailFromConfig")
    public MailSender getNormalImplementation() {
        return new MailSenderImpl();
    }

    @Bean("smtpMailFromConfig")
    public MailSender getSMTPImplementation() {
        return new MailSMTP();
    }
}
