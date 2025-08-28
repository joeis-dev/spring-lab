package dev.joeis.spring.basics.mail;

public interface MailSender {
    public void send(String to, String subject, String body);
}
