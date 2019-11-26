package method;

import javax.swing.*;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

public class MethodNameDemo {
    public static void main(String[] args) throws InterruptedException {

       // 动词 + 形容词
        // 副词形容动词或形容词
        Stream.of(1,2,4,3).forEachOrdered(System.out::println);

        //
        Lock lock = new ReentrantLock();
        lock.lockInterruptibly(); // 动词 + 副词
    }

    // 动词 + 名词
    public List<String> getValues(){
        return Collections.emptyList();
    }

    // 动词 + 名词 + 副词
    public List<String> getValuesSynchronously(){
        return Collections.emptyList();
    }

    public class ViewRender { // 名词
        public void render() {    // 单一动词

        }

        // 渲染（同步）
        public void renderSynchronized() {   // 动词 + 副词

        }

        // 并发渲染
        public void renderConcurrently() { // 动词 + 副词

        }
    }
}
