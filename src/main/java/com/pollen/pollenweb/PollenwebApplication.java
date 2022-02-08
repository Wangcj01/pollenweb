package com.pollen.pollenweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pollen.pollenweb.mapper")
public class PollenwebApplication{

	public static void main(String[] args) {
		SpringApplication.run(PollenwebApplication.class, args);
	}

}
