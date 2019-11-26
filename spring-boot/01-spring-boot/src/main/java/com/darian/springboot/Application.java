package com.darian.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@Controller
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/")
    @ResponseBody
    String hello(){
		return "hello, world";
	}

	@RequestMapping("/rest")
	@ResponseBody
    Map<String, Object> rest(){
	    Map<String, Object> data = new HashMap<>();

	    data.put("1","A");
	    data.put("2", 2);
	    return data;
    }

}
