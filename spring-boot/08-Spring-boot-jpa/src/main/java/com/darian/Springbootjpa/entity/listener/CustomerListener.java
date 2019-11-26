package com.darian.Springbootjpa.entity.listener;


import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

/***
 * 客户持久化监听器
 */
public class CustomerListener {

    /***
     * 存之前
     */
    @PrePersist
    public void persistent(Object source){
        System.out.println("@PrePersist: " + source);
    }

    @PostPersist
    public void postPersist(Object source){
        System.out.println("@PostPersist: " + source);
    }
}
