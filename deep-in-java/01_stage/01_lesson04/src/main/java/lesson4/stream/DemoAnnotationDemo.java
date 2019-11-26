package lesson4.stream;


import java.lang.reflect.Proxy;

@DemoAnnotation("hello")
public class DemoAnnotationDemo {
    public static void main(String[] args) {
        // 注解其实是 interface，最后生成的时候，
        // 就会生成一个代理对象，去进行调用
        // 很多东西都是代理生成的，代理就是字节码的一种
        DemoAnnotation annotation = DemoAnnotationDemo.class
                .getAnnotation(DemoAnnotation.class);
        System.out.println(Proxy.getInvocationHandler(annotation));
        System.out.println(Proxy.getInvocationHandler(annotation)
                .getClass().getName());
        System.out.println(annotation.value());
    }
}
