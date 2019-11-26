package lesson4;

public class ActionDemo {
    public static void main(String[] args) {
        // 匿名内置类
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("darian");
            }
        };

        // invodedynamic
        Runnable runnable1 = () -> {
            System.out.println("darian");
        };
    }
}
