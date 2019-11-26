package lesson4.stream;

import java.util.function.Consumer;

public class ConsumerDemoDemo {
    public static void print(Consumer<? super CharSequence> cs,
                             String message){
        cs.accept(message);
    }
}
