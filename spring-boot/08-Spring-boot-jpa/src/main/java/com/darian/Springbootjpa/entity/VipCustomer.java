package com.darian.Springbootjpa.entity;




import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Inheritance;


@Inheritance
@Entity
@Data
public class VipCustomer extends Customer {

    private Double discount;

}
