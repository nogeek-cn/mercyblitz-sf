package lesson4;

import java.util.function.Supplier;

public class SupplierDesignDemo {
    public static void main(String[] args) {
        echo("Hello, world");// 固定参数

        echo(SupplierDesignDemo::getMessage); // 变化实现

        getMessage();// 几十返回数据

        Supplier<String> stringSupplier = supplyMessage();// 待执行数据
        stringSupplier.get(); // 实际执行，相当于一段函数

    }

    private static Supplier<String> supplyMessage() {
        return SupplierDesignDemo::getMessage;
    }

    private static String getMessage() {
        sleep(1000);
        return "Hello, world";
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 这个是拉的模式
    public static void echo(String message) {
        System.out.println(message);
    }

    // 类似于推得方式
    public static void echo(Supplier<String> message) {
        System.out.println(message.get());
    }
}
