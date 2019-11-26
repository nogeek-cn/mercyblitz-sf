package com.darian.springbootweb.controller;

import com.darian.springbootweb.entity.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class JsonRestController {
    @Bean
    public Person currentPerson() {
        Person person = new Person("aa", 11);
        return person;
    }

    @Autowired
    @Qualifier("currentPerson")
    private Person person;

    @GetMapping(value = "/json/person", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person user() {
        person.add(linkTo(methodOn(JsonRestController.class).setName(person.getName())).withSelfRel());
        return person;
    }

    @GetMapping(value = "/json/person/set/name")
    public Person setName(@RequestParam String name) {
        person.setName(name);

        return person;
}
}