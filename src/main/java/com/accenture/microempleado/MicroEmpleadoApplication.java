package com.accenture.microempleado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroEmpleadoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroEmpleadoApplication.class, args);
    }
}
