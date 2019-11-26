package com.darian.springbootmybatis.controller;

import com.darian.springbootmybatis.dao.common.BookMapper;
import com.darian.springbootmybatis.entity.User;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
//    private final SqlSessionTemplate sqlSessionTemplate;
//
//    @RequestMapping("/user/{id}" )
//    public User getUser(@PathVariable int id){
//        User user = sqlSessionTemplate.selectOne("selectOne",id);
//        return user;
//    }
    private final BookMapper bookMapper;

    @GetMapping("/d")
    public void ddd(){
        bookMapper.deleteByPrimaryKey(null);
    }
}
