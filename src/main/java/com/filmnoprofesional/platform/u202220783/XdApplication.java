package com.filmnoprofesional.platform.u202220783;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class XdApplication {

    public static void main(String[] args) {
        SpringApplication.run(XdApplication.class, args);
    }

}
