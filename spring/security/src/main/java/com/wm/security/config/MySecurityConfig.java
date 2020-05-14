package com.wm.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1").hasRole("VIP1")
                .antMatchers("/level2").hasRole("VIP2")
                .antMatchers("/level3").hasRole("VIP3");

        http.formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("zhangsan").password("123456").roles("VIP1","VIP2")
                                     .and()
                                     .withUser("lisi").password("123456").roles("VIP2")
                                     .and()
                                     .withUser("wangwu").password("123456").roles("VIP1","VIP3");
    }
}
