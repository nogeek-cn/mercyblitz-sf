package lesson03;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;


public class WeakReferenceMapDemo {
    public static void main(String[] args) throws InterruptedException {
        demoWeakHashMap();
    }

    private static void demoWeakHashMap() throws InterruptedException {
        // 强引用
        // value 变量是局部变量，存放在栈
        // “abc” 是唱两，在 Java 8 之前是放在 Perm 区域，Java 8 + 放在 META 区域
        // 在 demeWeakHashmap() 方法执行结束后，value 变量会被立即会手，"abc" 唱两常驻
        String value = "abc";

        ReferenceQueue<UserDO> queue = new ReferenceQueue<>();

        // 弱引用
        WeakReference<UserDO> weakReference = new WeakReference<>(new UserDO("111"), queue);
        // WeakReference 继承 Reference ,Reference 有入队的操作 ReferenceQueue
        // 获取引用对象
        for (int i = 0; i < 100; i++) {
            Thread.sleep(1000);
            // System.gc(); // 回收 null
            System.out.println(weakReference.get());
        }

        // 可以自行绑定
        // queue.poll();
    }

    @Data
    @AllArgsConstructor
    private static class UserDO {
        private String name;
    }
}
