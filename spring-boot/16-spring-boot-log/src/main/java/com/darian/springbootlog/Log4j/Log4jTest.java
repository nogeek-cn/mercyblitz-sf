package com.darian.springbootlog.Log4j;


import org.apache.log4j.Logger;

public class Log4jTest {
    public static void main(String[] args) {

        System.setProperties();
        Logger logger = Logger.getLogger(Log4jTest.class.getName());
        logger.info("http,world");
    }
}
