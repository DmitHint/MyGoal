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
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender emailSender;
    private final Environment environment;

    @Async
    public void sendEmailParams(User user) throws MailException {
        System.out.println("Prepare to send mail");
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(environment.getProperty("spring.mail.username"));
        mail.setTo(user.getEmail());
        mail.setSubject("Параметры тела (" + DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                .format(LocalDateTime.now()) + ")");

        mail.setText(
                String.format(
                        """
                                Ваши параметры тела на %s:

                                Рост: %.1f см

                                Вес: %.1f кг

                                Жир: %.1f%%

                                Ширина плеч: %.1f см

                                Обхват плеча: %.1f см

                                Обхват груди: %.1f см

                                Обхват талии: %.1f см

                                Обхват бедер: %.1f см

                                Обхват икр: %.1f см
                              """,
                        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(LocalDateTime.now()),
                        user.getHeight(),
                        user.getWeight(),
                        user.getFat(),
                        user.getShoulderWidth(),
                        user.getShoulderCircumference(),
                        user.getChestCircumference(),
                        user.getWaistCircumference(),
                        user.getHipCircumference(),
                        user.getCalfCircumference()
                )
        );

        emailSender.send(mail);
    }
}

