package lesson3;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClassCastDemo {
    public static void main(String[] args) {


        Type type = int.class;
        Class intType = int.class;


        List list = new ArrayList();
        list.add(1);
        list.add("AA");

        List<Object> list2 = list;

        List<String> stringList = Collections.emptyList();
        // 编译时报错，运行时不报错的
        // stringList = list2;

        List<Integer> stringList1 = Arrays.asList(1, 3, 4, 5, 5);
        // diamond 语法
        List<Integer> strList3 = new ArrayList<>();
        // Java 8 var
        // var strList = New Arraylist<>();
    }

    /***
     * a String List
     * b Integer List
     * String -> Integer
     * for-Each
     * @param a
     * @param b
     */
    private static void exchange(List a, List b) {
        // 运行时会报错，不知道到底是什么类型
        a.addAll(b);
    }
}
