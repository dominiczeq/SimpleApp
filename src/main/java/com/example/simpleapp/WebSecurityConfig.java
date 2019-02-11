package com.example.simpleapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**", "/login").permitAll()
                .antMatchers("/person/edit/**","/person/add").hasRole("ADMIN")
                .and()
                .formLogin();

    }
    
    //Get users from database source
    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("SELECT username, password, enabled  FROM `simple-app`.user where username=?")
                .authoritiesByUsernameQuery("select username, user_role from `simple-app`.user where username=?");
    }
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        BCryptPasswordEncoder encoder = passwordEncoder();
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin").password(encoder.encode("admin")).roles("ADMIN")
//                .and()
//                .withUser("user").password(encoder.encode("password")).roles("USER");
//    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}