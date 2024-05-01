package org.mygoal.fitnessapp.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration 
@EnableJpaRepositories(basePackages = "org.mygoal.fitnessapp.backend.repository")
@EnableAspectJAutoProxy
@EnableAsync
@EnableScheduling
public class AppConfig {
}
