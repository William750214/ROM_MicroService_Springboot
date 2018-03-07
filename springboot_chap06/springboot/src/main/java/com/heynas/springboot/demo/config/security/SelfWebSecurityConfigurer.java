package com.heynas.springboot.demo.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * <p> Description:  SelfWebSecurityConfigurer </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 Heynas Studio. All rights reserved.
 *
 * @author William
 * @version 1.0
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SelfWebSecurityConfigurer extends WebSecurityConfigurerAdapter {
//    @Autowired
//    SelfAuthenticationProvider provider;

    @Autowired
    AjaxAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    AjaxAuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    AjaxAuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    AjaxAccessDeniedHandler accessDeniedHandler;

    @Autowired
    SelfUserDetailsService userDetailsService;

    @Autowired
    SelfLogoutSuccessHandler logoutSuccessHandler;

    @Autowired
    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.authenticationProvider(provider);
//        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
////        auth.inMemoryAuthentication()
////                .withUser("admin").password("admin").roles("ADMIN")
////                .and()
////                .withUser("user").password("passwd").roles("USER");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .httpBasic().authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .authorizeRequests()
//                .antMatchers("/hello/sayHello").hasRole("ADMIN")
//                .antMatchers("/hello/sayHello").hasRole("ADMIN123")
                .anyRequest()
//                .access("@rbacauthorityservice.hasPermission(request,authentication)")
                .authenticated()
                .and()
                .formLogin().loginPage("/login")
//                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler(logoutSuccessHandler)
                .permitAll()
                .and()
                .csrf().disable();

        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler);

//        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        // 禁用缓存
//        http.headers().cacheControl();

//        http.rememberMe().rememberMeParameter("remember-me")
//                .userDetailsService(userDetailsService).tokenValiditySeconds(300);
    }

}
