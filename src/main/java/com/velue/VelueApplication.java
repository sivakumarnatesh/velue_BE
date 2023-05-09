package com.velue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import com.velue.config.CorsConfig;

@SpringBootApplication
@Import(CorsConfig.class)
public class VelueApplication {

    public static void main(String[] args) {
        SpringApplication.run(VelueApplication.class, args);
    }
}

