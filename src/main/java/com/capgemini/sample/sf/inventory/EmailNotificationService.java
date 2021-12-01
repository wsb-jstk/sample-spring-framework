package com.capgemini.sample.sf.inventory;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailNotificationService implements NotificationService {

    @Value("${operation-team.mail}")
    private String operationTeamMail;

    private final JavaMailSender javaMailSender;

    @Override
    public void send(MessageDto message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(operationTeamMail);
        simpleMailMessage.setSubject(message.getTitle());
        simpleMailMessage.setText(message.getText());

        javaMailSender.send(simpleMailMessage);
    }
}
