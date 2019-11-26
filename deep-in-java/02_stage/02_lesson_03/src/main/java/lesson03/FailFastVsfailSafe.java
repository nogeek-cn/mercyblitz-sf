package lesson03;

import java.io.PipedReader;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastVsfailSafe {
    public static void main(String[] args) {
        demoFailFast();
        demoFailSafe();
    }

    private static void demoFailSafe() {
        removeForEach(new CopyOnWriteArrayList<>(List.of(1, 3, 5, 7, 8)));
    }

    private static void demoFailFast() {
        removeForEach(new ArrayList<>(List.of(1, 3, 34, 5, 5)));
    }

    private static void removeForEach(Collection<?> values) {
        // for- each 语法有问题
        try {
            // 如果是 Fast-fast 设计抛出 java.util.ConcurrentModificationException 如： ArrayList
            // 如果 Fast-safe, 那么就没有关系，如 java.util.concurrent.CopyOnWriteArrayList
            for (Object value : values) {
                values.remove(value);
            }
            System.out.println("集合删除成功：" + values);
        } catch (ConcurrentModificationException e) {
            System.err.println(e.getClass());
        }

    }
}

