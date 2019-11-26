package com.darian.springbootJDBC.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;


@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;

    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User(1, "darian", null),
                new User(2, "darian", null),
                new User(3, "mic", null),
                new User(4, "mic", null)
                );

        Map<String, List<Integer>> collect = users.stream().collect(
                groupingBy(User::getUsername,
                        mapping(User::getId,toList())));

        System.out.println(collect);
    }
}
