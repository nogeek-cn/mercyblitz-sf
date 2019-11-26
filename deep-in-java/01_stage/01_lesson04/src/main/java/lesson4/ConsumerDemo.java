package lesson4;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {

        Consumer consumer = System.out::println;
        consumer.accept("Hello, world");
        Consumer<String> consumer2 = ConsumerDemo::echo;
        // Fluent API 链式编程
        consumer2.andThen(consumer)
                .andThen(consumer)
                .accept("hello, darian");
    }

    private static void echo(String message) {
        System.err.println("echo: " + message);
    }


}
