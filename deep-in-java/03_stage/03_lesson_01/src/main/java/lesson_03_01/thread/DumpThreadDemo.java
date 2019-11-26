package lesson_03_01.thread;

public class DumpThreadDemo {
    public static void main(String[] args) {

        // Throwable API
        new Throwable("Stack trace").printStackTrace(System.out);
        // Thread API
        Thread.dumpStack();

        // Java9 StackWalker API
        StackWalker stackWalker = StackWalker.getInstance();
        stackWalker.forEach(System.out::println);
    }
}
