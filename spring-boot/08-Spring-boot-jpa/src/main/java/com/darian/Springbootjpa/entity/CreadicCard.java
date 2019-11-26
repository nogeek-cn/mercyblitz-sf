package com.darian.Springbootjpa.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/***
 * 信用卡
 */
@Entity
@Table(name = "creadit_cards")
@Data
public class CreadicCard {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 128)
    private String number;

    @Column(name = "register_date")
    private Date registerDate;

    @OneToOne(mappedBy = "creadicCard")
    private Customer customer;


}
