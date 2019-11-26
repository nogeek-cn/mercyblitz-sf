package com.darian.springbootenableweb;

import org.apache.coyote.http11.Http11Nio2Protocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.awt.*;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Resource
    private MyController myController;

	@Autowired
    private MyController getMyController;

	@RestController
    public static class MyController{

	    @GetMapping("/message")
        public String message(){
	        return "hello, world";
        }
    }


	@Bean
	public static EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
		return container -> {
		    if(container instanceof TomcatEmbeddedServletContainerFactory){
                TomcatEmbeddedServletContainerFactory factory = TomcatEmbeddedServletContainerFactory.class.cast(container);
                factory.addConnectorCustomizers(connector -> {
                    connector.setPort(8888);
                    connector.setProtocol(Http11Nio2Protocol.class.getName());
                });
                factory.addContextCustomizers(context -> {
                    context.setPath("/spring-boot");
                });
            }
        };
	}
}
