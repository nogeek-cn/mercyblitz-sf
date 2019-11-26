package com.darian.springbootweb.controller;

import com.darian.springbootweb.entity.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class XMLRestController {

    @GetMapping(value = "/demo/xml",
           /* consumes = {MediaType.APPLICATION_XML_VALUE
            ,MediaType.TEXT_HTML_VALUE},*/
            produces = MediaType.APPLICATION_XML_VALUE)
    public Person user(){
        Person person = new Person("darian-json",12);
        return person;
    }

}
