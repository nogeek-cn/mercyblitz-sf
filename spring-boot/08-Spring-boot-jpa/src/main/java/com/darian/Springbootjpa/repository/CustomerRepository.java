package com.darian.Springbootjpa.repository;

import com.darian.Springbootjpa.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


/***
 * 客户仓储
 */
@Repository
@Transactional(readOnly = false)
public class CustomerRepository extends SimpleJpaRepository<Customer,Integer> {

    @Autowired
    public CustomerRepository( EntityManager em) {
        super(Customer.class, em);
    }
}
