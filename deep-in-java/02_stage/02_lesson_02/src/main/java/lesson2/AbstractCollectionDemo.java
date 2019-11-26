package lesson2;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

public class AbstractCollectionDemo {
    public static void main(String[] args) {
        abstractList();
    }

    private static void abstractList() {
        // 反获得 Arrays.ArrayList 不允许写操作，但是允许下标数据交换
        List<Integer> numbers = Arrays.asList(1, 23, 3, 5, 6, 76, 3);
        // Java 1.4 断言
        assert numbers instanceof AbstractList;

        // 报错， java.lang.UnsupportedOperationException
        // numbers.add(0);

        numbers.set(1, 2323);
        System.out.println(numbers);
    }
}
