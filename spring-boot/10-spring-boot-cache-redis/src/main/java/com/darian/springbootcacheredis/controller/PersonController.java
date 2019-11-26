package com.darian.springbootcacheredis.controller;

import com.darian.springbootcacheredis.entity.Person;
import com.darian.springbootcacheredis.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepositoryImpl;

    @PostMapping("person/save")
    public Person save(@RequestBody Person person){
        personRepositoryImpl.savePerson(person);
        return person;
    }

    @GetMapping("person/get/{id}")
    public Person get(@PathVariable String id){
        return personRepositoryImpl.findPerson(id);
    }
}
