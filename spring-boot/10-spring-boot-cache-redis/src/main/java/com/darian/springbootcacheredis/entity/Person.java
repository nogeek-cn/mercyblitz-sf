package com.darian.springbootcacheredis.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class Person  implements Serializable {
    private String id;
    private String name;
    private String age;
}
