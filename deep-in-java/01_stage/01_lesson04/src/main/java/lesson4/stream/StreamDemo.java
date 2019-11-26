package lesson4.stream;


import java.util.Comparator;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
//        count(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        sort(2, 3, 5, 5, 23, 34, 54, 1);

//        sort((o1, o2) -> (o1 < o2) ? 1 : ((o1 == o2) ? 0 : -1),
//                44, 65, 34, 223, 2);

        parallelsort(3, 3, 2, 4, 5, 2, 3, 5, 2, 54, 3, 2);
    }

    private static void parallelsort(Integer... numbers) {
        Stream.of(numbers)
                .sorted()
                .parallel()
                .forEach(StreamDemo::println);
    }

    private static void println(Object o) {
        System.out.printf("[%s] : %s  \n ", Thread.currentThread().getName(), o);
    }

    private static void sort(Integer... numbers) {
        Stream.of(numbers)
                .sorted()
                .forEach(System.err::println);
    }

    private static void sort(Comparator<Integer> comparator, Integer... numbers) {
        Stream.of(numbers)
                .sorted(comparator)
                .forEach(System.out::println);
    }

    private static void count(Integer... numbers) {
        Stream.of(numbers)
                .reduce(Integer::sum) // 合并
                .map(String::valueOf)
                .ifPresent(System.out::println);
    }
}
