package com.darian.Springbootjpa.service;

import com.darian.Springbootjpa.entity.Book;
import com.darian.Springbootjpa.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public List<Book> findall() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findallSorted() {
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        return bookRepository.findAll(sort);
    }

    @Override
    public List<Book> findLikeNames(String name) {

        return bookRepository.findAll((root, query, cb) -> {
            List<Predicate> list = new ArrayList<>();
            if (!StringUtils.isEmpty(name)) {
                list.add(cb.equal(root.get("name").as(String.class), name));
            }
            return query.where(list.toArray(new Predicate[list.size()])).getRestriction();
        });
    }

    @Override
    public Page<Book> bypage(Integer page, Integer size, Book book) {
        return bookRepository.findAll((root, query, cb) -> {
                    List<Predicate> list = new ArrayList<>();
                    String name = book.getName();
                    if (name != null && !name.equals("")) {
                        list.add(cb.like(root.get("name").as(String.class), name));
                    }
                    String isbn= book.getIsbn();
                    list.add(cb.greaterThan(root.get("isbn").as(String.class), isbn));
                    return query.where(list.toArray(new Predicate[list.size()])).getRestriction();
                }, new PageRequest(page, size)
        );
    }


}
