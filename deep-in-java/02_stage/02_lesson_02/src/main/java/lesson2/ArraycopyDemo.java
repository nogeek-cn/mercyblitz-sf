package lesson2;

import java.util.List;

public class ArraycopyDemo {
    public static void main(String[] args) {
        String[] strings = new String[]{"11", "33"};
        arraycopy(strings, strings);

        Integer value = Integer.MAX_VALUE;
        System.out.println(value + 1);
        System.out.println(value + 1 == Integer.MIN_VALUE);
        System.out.println(value == Integer.MIN_VALUE - 1);
        // int 在 Java 只有 4 字节（32 位）

        // OS 32位 （4字节） 以及 64位（8字节）
        // Java 中的 long 和 double 是非线程安全的，两个四字节，高和低位。
        // Java 中默认是没有正整数（无符号整数）
        // c unsigned int(size_t)

//        List<Integer> integers = List.of(Integer.valueOf(1),
//                Integer.valueOf(3),
//                Integer.valueOf(4),
//                Integer.valueOf(5),
//                Integer.valueOf(6));
//        if (integers.size() < 1) ;


    }

    public static void arraycopy(Object[] src, Object[] destinatioin) {

    }
}
