package com.heynas.springboot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpEncodingAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
@ComponentScan(basePackages = {"org.heynas.springboot","com.heynas.springboot.demo"})
public class SpringbootApplication {
    public static void main(String[] args) {
//        SpringApplication.run(SpringbootApplication.class, args);
        SpringApplication springApplication = new SpringApplication(SpringbootApplication.class);
//        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }
}
