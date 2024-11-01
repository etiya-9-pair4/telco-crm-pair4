package com.etiya.identityservice;

import io.github.macidko.annotations.EnableCore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan()
@EnableCore
public class IdentityserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdentityserviceApplication.class, args);
    }

}
