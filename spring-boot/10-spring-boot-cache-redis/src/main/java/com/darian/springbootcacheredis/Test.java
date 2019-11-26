package com.darian.springbootcacheredis;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    // lock-free
    private volatile int data;

    private synchronized void doSome(){
        Lock outterlock = new ReentrantLock();
        Lock interLock = new ReentrantLock();
        try {
            // 重入锁。
            outterlock.tryLock();
            interLock.tryLock();
        }finally {
            outterlock.unlock();
            interLock.unlock();
        }
    }

    public static void main(String[] args) {
        Integer var1 = new Integer(1);
        Integer var2 = new Integer(1);

        System.out.println(var1.equals(var2));
        System.out.println(var1 == var2);

        System.out.println(System.identityHashCode(var1));
        System.out.println(System.identityHashCode(var2));
    }
}
