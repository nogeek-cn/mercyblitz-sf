package lesson3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class GenericWildcardsTypeDemo {

    public static void main(String[] args) {
        // 泛型上界通配符类型
        // Number -> Byte, Short, Integer, Long
        List<Number> numbers = new ArrayList<>();

        upBoundWildcards(numbers);
        unBoundWildcards(numbers);
        lowBoundWildcards(numbers);


    }

    private static void lowBoundWildcards(List<Number> numbers) {
        lowerBoundedWildcardsDemo(numbers, numbers);
    }

    // PECS
    private static void lowerBoundedWildcardsDemo(
            List<? extends Number> producer,
            List<? super Number> consumer) {
        producer.forEach(System.out::println);
        consumer.add(1);
        consumer.add(Short.valueOf("2"));
    }

    private static void unBoundWildcards(List<Number> numbers) {
        // 完全通配符类型
        // 在运行时与非统配泛型出现签名冲突，因为他们两者（声明类型）是相同的
        // 然后完全统配类型，可以适配任意类型，比如集合
        // 反而具体类型泛型会限制类型范围
        println(numbers);
    }

    private static void upBoundWildcards(List<Number> numbers) {
        numbers.add(Byte.valueOf("1"));
        numbers.add(Short.valueOf("2"));
        numbers.add(1);
        numbers.add(Long.valueOf(2));

        List<Byte> bytes = Arrays.asList(Byte.valueOf("2"), Byte.valueOf("3"));
        List<Short> shorts = Arrays.asList(Short.valueOf("2"), Short.valueOf("5"));
        List<Integer> integers = Arrays.asList(3, 4);


        // ？ extends Number；
        // 意味着可以接受合并的集合
        // List<Byte> , List<Short>
        numbers.addAll(bytes);
        numbers.addAll(shorts);
        numbers.addAll(integers);

        // 被操作（处理）的对象，需要更为抽象类型，Number
        // 待整合（输入）的对象，可以是具体类型
        // upderBanding 设计
        forEach(numbers, System.out::println);
    }

    /***
     * 泛型的类型擦写，导致和下方冲突
     */
    public static void println(Iterable<?> iterable) {
        iterable.forEach(System.out::println);
    }

//    public static void println(Iterable<Object> iterable){
//        iterable.forEach(System.out::println);
//    }

    // 告诉你有上限  // 两个 ？ 不一样
    public static void forEach(Iterable<? extends Number> list,
                               Consumer<Object> consumer) {
        list.forEach(e -> consumer.accept(e));
    }
}
