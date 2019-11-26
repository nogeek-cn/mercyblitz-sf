package lesson2;

import java.util.*;

public class LegacyCollectionDemo {
    public static void main(String[] args) {
        vectorVsList();
        vectorVsStack();
        hashMapVsHashTable();
        EnumerationVsEnum();
        bitSet();
    }

    private static void bitSet() {
        // 线程不安全
        // BitSet 用于 位集合操作,可以搭配 NIO ByteBuffer
//        BitSet.valueOf()
    }

    private static void EnumerationVsEnum() {
        // Enumeration 主要用于迭代
        // 由于 java.util.Iterator 从 Java 1.2 引入
        String value = "1,2,3";
        Enumeration enumeration = new StringTokenizer(value,",");
        while (enumeration.hasMoreElements()){ // 等价于 Iterator.hashNext()
            String element = String.valueOf(enumeration.nextElement()); // 等价于 Iterator.next();
            System.out.println(element);
        }

        // Iterable 从 Java 5 引入,用于 for-each 语句语法提升
    }

    private static void hashMapVsHashTable() {
        // HashTable 与 HashMap
        // HashTable
        //      实现了 java.util.Dictionary 和 Map 接口
        //      线程安全
        //      key 与 value 不允许null
        // HashMap
        //      实现 Map 接口
        //      线程非安全(写操作)
        //      key 与 value 允许null

        // 特殊 java.util.concurrent.ConcurrentHashMap
        // key 与 value 不允许为 null
        //  的原因：
        //  它在查询数据的时候的拿到为 null 的时候，究竟是线程不可见还是拿到的值为 null ，这个时候会产生歧义。

        // 它也是 HashMap

        Map<String, String> map = new HashMap<>();
        map.put(null, null);
    }

    private static void vectorVsStack(){
        // Verctor FIFO
        // Stack    LIFO
        // class Stack<E> extends Vector<E> 就是把方法给调转一下
        // Stack 每一次都会扩容,它不能显示的设定它的大小,所以它达到阈值扩容比较麻烦.
        // 每次都会扩容，不能显示的设置它的阈值。
    }

    private static void vectorVsList() {
        // 1. 几乎所有实现都是线程安全的
        // Vector 是数组实现， Vector 和 List 什么区别？
        // 确切的说应该说 Vector 和 ArrayList 什么区别？
        // Vector 实现了 List ,也是基于 AbstractList 来实现的
        // Vector 的所有方法都是操作线程安全，使用了关键字 “synchronized” 来修饰
        Vector<String> vector = new Vector<>();
        List<String> list = new ArrayList<>();

        // 如果 Vector 在方法内部使用，
        // synchronized 修饰的方法基本上没有线程同步的消耗
        // 要看会不会存在线程竞争，首先看这个线程是不是在监控的情况下，
        // 它在方法的内部，所以没有太多的消耗，
        // 字节码还是老的字节码,但是实现的时候会进行优化
        vector.add("1");
        list.add("2");
    }

}
