package com.techolution.pcf.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This is the main class use for starting the Application and has Swagger
 * configuration
 * 
 * @author naveenkumar300@com
 *
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration



public class HashMapServiceBrokerApplication {
    
  
    
    public static void main(String[] args) {
        SpringApplication.run(HashMapServiceBrokerApplication.class, args);
        
    }
    
    
}
