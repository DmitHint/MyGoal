package org.mygoal.fitnessapp.backend.service;

import lombok.RequiredArgsConstructor;
import org.mygoal.fitnessapp.backend.model.User;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * The service is responsible for sending a letter with body parameters to the specified address.
 */
@Service
@RequiredArgsConstructor
public class EmailService {

    /**
     * JavaMailSender for sending an email.
     */
    private final JavaMailSender emailSender;

    /**
     * Environment for getting properties from the application.properties file.
     */
    private final Environment environment;

    /**
     * This method asynchronously sends email with user's body parameters to the specified address.
     *
     * @param user the user who will receive an email
     * @throws MailException if an error occurs while sending an email
     */
    @Async
    public void sendEmailParams(User user) throws MailException {
        LocalDateTime moscowTime = LocalDateTime.now(ZoneId.of("Europe/Moscow"));
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        String formattedDate = moscowTime.format(formatter);
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(environment.getProperty("spring.mail.username"));
        mail.setTo(user.getEmail());
        mail.setSubject("Body Parameters (" + formattedDate + ")");

        mail.setText(String.format(
                """
                Your body parameters as of %s:
        
                Height: %.1f cm
        
                Weight: %.1f kg
        
                Fat: %.1f%%
        
                Shoulder Width: %.1f cm
        
                Shoulder Circumference: %.1f cm
        
                Chest Circumference: %.1f cm
        
                Waist Circumference: %.1f cm
        
                Hip Circumference: %.1f cm
        
                Calf Circumference: %.1f cm
                """,
                formattedDate,
                user.getHeight(),
                user.getWeight(),
                user.getFat(),
                user.getShoulderWidth(),
                user.getShoulderCircumference(),
                user.getChestCircumference(),
                user.getWaistCircumference(),
                user.getHipCircumference(),
                user.getCalfCircumference()
        ));

        emailSender.send(mail);
    }
}
