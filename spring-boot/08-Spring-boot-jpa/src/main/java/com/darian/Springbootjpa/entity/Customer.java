package com.darian.Springbootjpa.entity;

import com.darian.Springbootjpa.entity.listener.CustomerListener;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Access(AccessType.FIELD)
@Data
@Table(name="customers")
@EntityListeners(value = CustomerListener.class)
public class Customer {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 32)
    private String name;

    @OneToOne(cascade = CascadeType.REMOVE)
    private CreadicCard creadicCard;

    @ManyToOne
    private Store store;

    @ManyToMany
    private Collection<Book> books;
}
