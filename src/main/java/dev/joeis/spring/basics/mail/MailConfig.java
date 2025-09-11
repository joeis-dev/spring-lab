package dev.joeis.spring.basics.mail;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration

public class MailConfig {
    @Bean
    // if is not set with "foo" or not even declared will load this bean.
    @ConditionalOnProperty(name="spring.mail.host", havingValue="foo",matchIfMissing=true)
    public MailSender getNormalImplementation() {
        return new MailSenderImpl();
    }

    @Bean
    // Loads this bean if such prop is set, no matters its value.
    @ConditionalOnProperty("spring.mail.host")
    public MailSender getSMTPImplementation() {
        return new MailSMTP();
    }
}
