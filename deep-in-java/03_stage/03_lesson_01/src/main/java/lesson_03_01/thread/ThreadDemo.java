package lesson_03_01.thread;


public class ThreadDemo {
    public static void main(String[] args) throws Exception {
        // Thread 实现了 Runable
        // 如果没有传递 Runable 对象实现，空执行
        Thread thread = new Thread(ThreadDemo::sayHello);

        thread.start();// 启动线程
        thread.join();  // 等待线程结束
        System.out.println("Hello Next.....");
        System.out.println(thread.getState());  // TERMINATED
    }

    public static void sayHello() {
        println("Hello, world! ");
    }

    private static void println(Object o) {
        System.out.println("线程 id:【" + Thread.currentThread().getId() + "】:" + o);
    }
}
