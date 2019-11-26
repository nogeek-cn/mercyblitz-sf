package com.darian.Springbootjpa.controller;

import com.darian.Springbootjpa.entity.Customer;
import com.darian.Springbootjpa.repository.CustomerRepository;
import com.darian.Springbootjpa.service.CustomerService;
import javafx.collections.transformation.SortedList;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    @GetMapping("all")
    public List<Customer> findall() {
        return customerRepository.findAll();
    }

    @PostMapping("get/page")
    public Page<Customer> getCustomersPage(@RequestParam("page") Integer id,
                                           @RequestParam("size") Integer size,
                                           @RequestBody Customer customer) {
        //int page, int size, Direction direction, String... properties

        PageRequest pageRequest = new PageRequest(1, 10, Sort.Direction.ASC, "id");
        Page<Customer> all = customerRepository.findAll(
                (root, query, cb) -> {
                    List<Predicate> list = new ArrayList<>();
                    Expression<String> nameExpression = root.get("name").as(String.class);
                    String name = nameExpression.getAlias();
                    if(name!=null && !name.equals("")){
                        list.add(cb.equal(nameExpression, customer.getName()));
                    }
//                    query.where(list.toArray(new Predicate[list.size()]));
                    return cb.and(list.toArray(new Predicate[list.size()]));
                },pageRequest
        );
        return all;
    }


    @GetMapping("get/{id}")
    public Page<Customer> getCustomerById(@PathVariable("id") Integer id) {
        //int page, int size, Direction direction, String... properties

        PageRequest pageRequest = new PageRequest(1, 10, Sort.Direction.ASC, "id");
        Page<Customer> all = customerRepository.findAll(
                (root, query, cb) -> {
                    List<Predicate> list = new ArrayList<>();
                    Path<String> name = root.get("name");
                    if(!StringUtils.isEmpty(name)){
                        list.add(cb.equal(name, name));
                    }
                    query.where(list.toArray(new Predicate[list.size()]));
                    return null;
                },pageRequest
        );
        return all;
    }

    @GetMapping("/{id}")
    public Customer show(@PathVariable("id") Customer customer, Model model) {
        return customer;
    }

    @PostMapping("/customer/add")
    public Customer addCusstomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        Integer id = customer.getId();
        return customerService.getCustomerById(id);
    }
}
