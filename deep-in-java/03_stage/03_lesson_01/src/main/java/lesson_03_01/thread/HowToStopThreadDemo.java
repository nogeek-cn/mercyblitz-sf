package lesson_03_01.thread;

import java.util.concurrent.Executors;

public class HowToStopThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        StoppableAction action = new StoppableAction();
        Thread thread = new Thread(action);
        // 线程启动（并不一定执行）
        thread.start();

        // main 线程调整 stopped 状态到 true
        action.stop();

        thread.join();

        // 如果线程池的话，以上方案可能存在问题
        Executors.newFixedThreadPool(2);    // 有且只有 2 个线程在复用
        Executors.newCachedThreadPool();            // 几乎无限数量线程
    }

}
class StoppableAction implements Runnable{
    // 确保 stopped 原子操作
    private volatile boolean stopped;

    @Override
    public void run() {
        if (stopped){
            // 通过异常的方式，可以 kill 线程
            System.out.println("StoppableAction 中止!");
            return;
        }
        // TODO
        System.out.println("StoppableAction 运行。。。");
    }

    public void stop(){
        this.stopped = true;
    }
}
