package com.darian.Springbootjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "stores")
@Data
public class Store {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "store")
    private Collection<Customer> customers;
}
