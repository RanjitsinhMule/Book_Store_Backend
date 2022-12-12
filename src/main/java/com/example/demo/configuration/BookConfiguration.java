package com.example.demo.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfiguration {
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
