package lesson_03_01.thread;

public class ThreadInterruptDemo  {
    public static void main(String[] args) throws Exception {
        // Thread 实现了 Runable
        // 如果没有传递 Runable 对象实现，空执行
        Thread thread = new Thread(ThreadInterruptDemo::sayHello);

        // # interrupt 方法在 start 调用之前是没有效果的
        thread.start();// 启动线程

        thread.interrupt(); // main 线程 interrupt 子线程
        // #interrupt 并不能中止线程，但是可以传递 interrupt 状态

        System.out.println("Hello Next.....");
        System.out.println(thread.getState());  // TERMINATED
    }

    public static void sayHello() {
        if (Thread.currentThread().isInterrupted()){
            println("被终止：");
            return;
        }
        println("Hello, world! ");
    }

    private static void println(Object o) {
        System.out.println("线程 id:【" + Thread.currentThread().getId() + "】:" + o);
    }
}
