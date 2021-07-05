package com.synechron.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	Logger logger = LoggerFactory.getLogger(MvcConfig.class);

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/unauthorize").setViewName("unauthorize");
	}

}
