package lesson3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Consumer;


public class GenericParamterTypeDemo {

    public static void main(String[] args) {
        Container<String> stringContainer = new Container<>("String");
        // 报错: Integer 不是 CharSequence 子类
        // Container<Integer> stringContainer2 = new Container("String");

        // 编译器：为什么不报错
        // StringBuffer 是 CharSequence 子类
        // String (参数)也是 CharSequence 子类
        // 运行时：Object
        Container<StringBuffer> c = new Container("Hello, World");
        // 通过构造器传递参数是 String 类型，运行时都是 Object，没有问题
        System.out.println(c.getElement());
        // 不过当 c 对象申明的类型为 Container<StringBuffer>
        // E 类型为 StringBuffer ，因此 Set(E), E 必须是 StringBuffer
        c.set(new StringBuffer("2019"));
        System.out.println(c.getElement());

        // 类型擦写可以帮我们拦一道，但是运行时会进行擦写
        // Java 泛型对象操作时，看申明泛型参数类型


        // 类型擦写都能放进去
        add(new ArrayList<>(), "Hello, World");
        /***
         * Auto-boxing 1 = new Integer(256)
         * Integer.valueOf(256);
         */
        add(new ArrayList<>(), 256);
        // 这个也可以
        add(new HashSet<>(), 2);
        add(new HashSet<>(), 4);

        forEach(Arrays.asList(1, 3, 4), System.out::println);

    }

    // extends 声明他的上限 （最高类型） ， E 的上线类型时 CharSquence
    public static class Container<E extends CharSequence> {
        private E element;

        public Container(E e) {
            this.element = e;
        }

        // Operations
        public boolean set(E e) {
            this.element = e;
            return true;
        }

        public E getElement() {
            return this.element;
        }
    }

    // 多界限泛型参数类型
    public static class C {

    }

    public static interface I {

    }

    public static interface I2 {

    }

    /***
     * 多界限泛型参数类型 extends 的第一个类型允许具体类（也可以是接口）
     * 第二或更多参数类型必须是接口
     */
    public static class Template<T extends C & I & I2 & Serializable> {

    }

    public static class TemplateClass /*extends C*/
            implements Serializable, I, I2 {

    }


    // 把一个类型的元素，添加到集合中
    public static <C extends Collection<E>,
            E extends Serializable> void add(C target, E element) {
        target.add(element);
    }

    // 把一个类型的元素，添加到集合中
    public static <C extends Iterable<E>,
            E extends Serializable> void forEach(C target, Consumer<E> consumer) {
        target.forEach(e -> consumer.accept(e));
    }

}

