package com.darian.springbootcacheredis.question;

import lombok.Data;

@Data
public class Switcher {
    private volatile boolean on;
}
