package com.darian.Springbootjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "book")
@Data
public class Book {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String isbn;

    private Date publishDate;

    @ManyToMany(mappedBy = "books")
    private Collection<Customer> customers;
}
