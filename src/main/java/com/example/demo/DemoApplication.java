package com.example.demo;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhang
 */
@SpringBootApplication
@RestController
@EnableJpaAuditing
@ComponentScan(basePackages = {"person.zhangyu.utils.bridgeloan","com.example.demo"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}