//package com.pollen.pollenweb.configuration;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//
//
//public class ConfigProperties {
//
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        if (!registry.hasMappingForPattern("/assets/**")) {
//            registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
//        }
//    }
//}
