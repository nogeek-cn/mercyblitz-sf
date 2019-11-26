package lesson2;

import java.io.Serializable;

public class StringDemo {
    public static void main(String[] args) {
        // 前类型约束
        // 1 -> int -> Integer -< Number
        println(1);

        // String 既是 Serializable 也是 CharSequence
        println((CharSequence) "Hello");
    }

    private static void println(Serializable number) {

    }

    private static void println(CharSequence sc) {
        System.out.println(sc.toString());
    }

    public interface A {
        int VALUE = 1;
    }
}
