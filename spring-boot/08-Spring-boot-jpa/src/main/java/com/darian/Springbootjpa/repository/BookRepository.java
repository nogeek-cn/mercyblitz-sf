package com.darian.Springbootjpa.repository;

import com.darian.Springbootjpa.entity.Book;
import com.darian.Springbootjpa.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional(readOnly = false)
public class BookRepository extends SimpleJpaRepository<Book, Integer> {

    @Autowired
    public BookRepository( EntityManager em) {
        super(Book.class, em);
    }
}
