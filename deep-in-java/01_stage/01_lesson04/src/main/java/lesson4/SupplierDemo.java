package lesson4;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {
        Supplier<Long> supplier = getLong();

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Hello, world";
            }
        };

        Callable<String> callable1 = SupplierDemo::getHelloWorld;
    }

    public static String getHelloWorld() {
        return "Hello, world";
    }

    public static Supplier<Long> getLong() {
//        return () -> {
//            return System.currentTimeMillis();
//        };
        return System::currentTimeMillis;
    }
}
