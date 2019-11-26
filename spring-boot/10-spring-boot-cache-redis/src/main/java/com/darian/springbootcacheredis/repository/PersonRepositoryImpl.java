package com.darian.springbootcacheredis.repository;

import com.darian.springbootcacheredis.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {
    private final Map<String, Person> repositroy = new HashMap<>();
    private final RedisTemplate redisTemplate;
    @Override
    public Person findPerson(String id) {
//        return repositroy.get(id);
        return (Person) redisTemplate.opsForValue().get(id);
    }

    @Override
    public boolean savePerson(Person person) {
        redisTemplate.opsForValue().set(person.getId(), person);
//        return repositroy.putIfAbsent(person.getId(), person) == null;
        return true;
    }
}
