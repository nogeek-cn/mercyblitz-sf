package lesson03;

import java.util.PriorityQueue;

public class PrioritityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> integerQueue = new PriorityQueue<>();
        integerQueue.add(3);
        integerQueue.add(5);
        integerQueue.add(1);

        integerQueue.forEach(System.out::println);
        // 1  5  3

        System.out.println(integerQueue.poll());
        System.out.println(integerQueue.poll());
        System.out.println(integerQueue.poll());
        // 1 3 5
    }
}
