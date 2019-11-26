package com.darian.springbootmybatis;

import com.darian.springbootmybatis.dao.common.BookMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private BookMapper bookMapper;

    @Test
    public void contextLoads() {
        bookMapper.deleteByPrimaryKey(null);
    }

}
