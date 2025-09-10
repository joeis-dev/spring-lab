package dev.joeis.spring.basics.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration

public class MailConfig {

    // Primary available only on "dev" env
    @Primary
    @Bean
    @Profile("dev")
    public MailSender getNormalImplementation() {
        return new MailSenderImpl();
    }

    @Primary
    @Bean

    // We can also set !dev but if there is others environments will be available also there
    @Profile("prod")
    public MailSender getSMTPImplementation() {
        return new MailSMTP();
    }
}
