package lesson4.stream;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectDemo {
    public static void main(String[] args) {
        // Stream 不做参数，主要是它变化很多，
        // 如果它是不是并行的
        List<Integer> collect = Stream.of(1, 4, 6, 4, 3)
                .collect(Collectors.toList());

        Stream.of(1, 3, 5, 6, 3)
                .collect(LinkedList::new,
                        List::add,
                        List::add);

        System.out.println(collect.getClass());  // Java.util.ArrayList



    }
}
