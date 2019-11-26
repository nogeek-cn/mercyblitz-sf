package lesson4;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<String, Long> stringToLong = Long::valueOf;
        System.out.println(stringToLong.apply("333"));

        Function<Long, String> longToString = String::valueOf;
        System.out.println(longToString.apply(345L));

        // "333" -> 333L -> "333"
        Long value = stringToLong.compose(String::valueOf).apply(1L);
        System.out.println(value);


    }
}
