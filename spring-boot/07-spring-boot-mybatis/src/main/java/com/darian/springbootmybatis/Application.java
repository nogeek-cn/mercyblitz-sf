package com.darian.springbootmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.darian.springbootmybatis")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
