package com.darian.Springbootjpa.service;

import com.darian.Springbootjpa.entity.Book;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {

    List<Book> findall();

    List<Book> findallSorted();

    List<Book> findLikeNames(String name);

    Page<Book> bypage(Integer page, Integer size, Book book);
}
