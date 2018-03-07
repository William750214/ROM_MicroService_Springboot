package com.heynas.springboot.demo;

import com.heynas.springboot.demo.web.MyFilter;
import com.heynas.springboot.demo.web.MyHttpSessionListener;
import com.heynas.springboot.demo.web.MyServlet;
import com.heynas.springboot.demo.web.MyServletContextListener;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan
public class SpringbootApplication {

//    @Bean
//    public ServletRegistrationBean MyServlet() {
//        return new ServletRegistrationBean(new MyServlet(), "/myServlet/*");
//    }
//
//    @Bean
//    public FilterRegistrationBean MyFilter() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new MyFilter());
//        filterRegistrationBean.setOrder(1);
//
//        return filterRegistrationBean;
//    }
//
//    @Bean
//    public ServletListenerRegistrationBean MyServletContextListener() {
//        return new ServletListenerRegistrationBean(new MyServletContextListener());
//    }
//
//    @Bean
//    public ServletListenerRegistrationBean MyHttpSessionListener() {
//        return new ServletListenerRegistrationBean(new MyHttpSessionListener());
//    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringbootApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }
}
