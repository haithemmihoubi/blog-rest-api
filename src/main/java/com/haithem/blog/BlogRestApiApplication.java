package com.haithem.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import model mapper
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogRestApiApplication {
	@Bean
public ModelMapper modelMapper() {
	return new ModelMapper();
}
	public static void main(String[] args) {
		SpringApplication.run(BlogRestApiApplication.class, args);
	}

}
