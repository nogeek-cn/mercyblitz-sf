package com.darian.springbootweb.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "test")
public class TestProperties {
    public final static String test = "default2";
}
