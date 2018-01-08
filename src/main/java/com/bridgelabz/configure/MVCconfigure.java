package com.bridgelabz.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration

public class MVCconfigure extends WebMvcConfigurerAdapter{
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		//registry.addViewController("/**").setViewName("home");

        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/Archive").setViewName("Archive");
        registry.addViewController("/Trash").setViewName("Trash");
        registry.addViewController("/docDetails").setViewName("docDetails");
        registry.addViewController("/AddDetails").setViewName("AddDetails");
    }

}
