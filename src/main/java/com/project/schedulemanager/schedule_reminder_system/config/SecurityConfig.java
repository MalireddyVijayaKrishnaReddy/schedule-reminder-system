package com.project.schedulemanager.schedule_reminder_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {


    @Bean
    public UserDetailsManager authenticate(DataSource dataSource){

        return new JdbcUserDetailsManager(dataSource);
    }
}
