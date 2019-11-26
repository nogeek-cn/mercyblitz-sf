package com.darian.Springbootjpa.service;

import com.darian.Springbootjpa.entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class CustomerService {

    @PersistenceContext
    private EntityManager entityManager;

    /***
     * 添加客户
     * @param customer
     */
    @Transactional
    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    public Customer getCustomerById(Integer id) {
        return entityManager.find(Customer.class, id);
    }
}
