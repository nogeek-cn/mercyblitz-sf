import java.util.*;

public class TestArrayListVsLinkedList {
    public static void main(String[] args) {
        long count = 100000000L;
        int itemCount = 100;

        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            funArrayList(itemCount);
        }
        long middle = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            funLinkedList(itemCount);
        }
        long end = System.currentTimeMillis();

        System.out.println("arrayList:运行（" + count + "次）一次插入" + itemCount + "个元素->遍历,耗时:" + (middle - start) + "ms");
        System.out.println("linkedList:运行（" + count + "次）一次插入" + itemCount + "个元素->遍历,耗时:" + (end - middle) + "ms");
    }

    public static void funArrayList(int itemCount) {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < itemCount; i++) {
            list1.add(i);
        }
        for (int i = 0; i < itemCount; i++) {
            list1.get(i);
        }
    }

    public static void funLinkedList(int itemCount) {
        List<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < itemCount; i++) {
            list2.add(i);
        }
        for (int i = 0; i < itemCount; i++) {
            list2.get(i);
        }
    }

}
