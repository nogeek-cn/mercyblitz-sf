package com.darian.lesson5;

public class Test {

	public static void main(Main[] args) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		while(true) {
			System.err.println(classLoader.getClass().getName());
			
			classLoader = classLoader.getParent();
			if(classLoader == null) {
				break;
			}
		}
		
		ClassLoader systemClassLoder = 	ClassLoader.getSystemClassLoader();
		System.out.println(systemClassLoder.getClass().getName());
	}
}
