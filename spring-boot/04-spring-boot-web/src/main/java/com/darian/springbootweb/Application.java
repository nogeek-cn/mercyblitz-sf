package com.darian.springbootweb;


import com.darian.springbootweb.spring.boot.MyFilter2;
import com.darian.springbootweb.spring.boot.MyServlet2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.servlet.DispatcherType;
import java.util.Collections;
import java.util.EventListener;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.darian.springbootweb.servlet")
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public static ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new MyServlet2());
        servletRegistrationBean.addUrlMappings("/spring-boot/myservlet2");
        servletRegistrationBean.addInitParameter("myname", "myvalue");
        return servletRegistrationBean;
    }

    @Bean
    public static FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter2());
        filterRegistrationBean.setServletNames(Collections.singleton("myServlet2"));
        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST,
                DispatcherType.FORWARD,
                DispatcherType.INCLUDE);

        return filterRegistrationBean;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(Application.class);
        return builder;
    }

    //    /***
//     * 会重复注册
//     */
//    @Bean
//    public static ServletListenerRegistrationBean servletListenerRegistrationBean(){
//        ServletListenerRegistrationBean<EventListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>();
//        servletListenerRegistrationBean.setListener(new MyServletRequestListener());
//        return servletListenerRegistrationBean;
//    }


}
