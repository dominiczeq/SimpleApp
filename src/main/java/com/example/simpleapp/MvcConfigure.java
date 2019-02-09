//package com.example.simpleapp;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.UrlBasedViewResolverRegistration;
//import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;
//
//@Configuration
//public class MvcConfigure extends WebMvcConfigurerAdapter {
//
//
//    public UrlBasedViewResolverRegistration jsp(String prefix, String suffix) {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setViewClass(JstlView.class);
//        resolver.setPrefix("/WEB-INF/jsp");
//        resolver.setSuffix(".jsp");
//        return new UrlBasedViewResolverRegistration(resolver);
//    }
//}
//
