package sf.java.lesson_0001;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class LambdaDemo {

    // Action 模式
    private static void showAction(){
        new Runnable() {
            @Override
            public void run() {
            }
        };
        Runnable runnable2 = ()->{};
        Runnable runnable3 = LambdaDemo::showConsumer;
    }

    // Supplier 模式
    private static void showSupplier() {
        String string = "hello, World";
        Supplier<String> string2 = () -> "hello, World";
    }


    // Consumer 模式
    private static void showConsumer() {

    }

    // Function 模式
    private static void showFunction() {
        Function<String, Integer> f = LambdaDemo::compareTo;
    }

    private static Integer compareTo(String value) {
        return value.compareTo("hello, world");
    }


    public static void main(String[] args) {
        Action a = () -> {

        };

        // 匿名内部类
        PropertyChangeListener listener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                println(evt);
            }
        };
        // Lambda 基本写法
        PropertyChangeListener listener2 = evt -> {
            println(evt);
        };

        // PropertyChangeListener#PropertyChange(Pr
        // opertyChangeEvent)
        // 属于有入参，没有返回，与 println(Object)一样
        PropertyChangeListener listener3 = LambdaDemo::println;
    }

    private static void println(Object o) {
        System.out.println(o);
    }

    @FunctionalInterface
    public interface Action {
        void execute();

        default void doExecute() {
            execute();
        }

        int hashCode();
    }

    public static void stream(String[] args) {
        Stream.of(1, 3, 4, 5, 6)
                .map(String::valueOf)
                .forEach(System.out::println);
    }
}
