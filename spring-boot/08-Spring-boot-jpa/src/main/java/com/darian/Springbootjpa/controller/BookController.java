package com.darian.Springbootjpa.controller;

import com.darian.Springbootjpa.entity.Book;
import com.darian.Springbootjpa.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("getBookListByName")
    public List<Book> getBookListByName(@RequestParam String name) {
        return bookService.findLikeNames(name);
    }

    @PostMapping("bypage")
    public Page<Book> bypage(@RequestParam Integer page,
                             @RequestParam Integer size,
                             @RequestBody Book book) {
        return bookService.bypage(page, size, book);
    }

}
