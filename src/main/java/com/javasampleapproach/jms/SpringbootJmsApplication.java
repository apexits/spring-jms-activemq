package com.javasampleapproach.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;

//@SpringBootApplication(exclude = JmsAutoConfiguration.class)
@SpringBootApplication
//@EnableJms
public class SpringbootJmsApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringbootJmsApplication.class);
	}

	public static void main(String[] args) {
//		SpringApplication.run(SpringbootJmsApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootJmsApplication.class, args);

	}
}
