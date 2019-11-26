package lesson03;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorModificationDemo {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>(Arrays.asList(1,3,43,5));
        Iterator<Integer> iterator = values.iterator();
        while (iterator.hasNext()){
            // List.add(T) 方法在 next() 方法调用之前执行会抛异常。 java.util.ConcurrentModificationException
            values.add(4);
//             iterator.remove()方法在 next() 方法调用之前执行会抛异常。 java.lang.IllegalStateException
//            iterator.remove();
            iterator.next();

            // Iterator 只能在 next() 方法后，通过 remove() 方法移除数据，也无法对源 Collection 对象操作
            values.add(4);
        }
    }
}
