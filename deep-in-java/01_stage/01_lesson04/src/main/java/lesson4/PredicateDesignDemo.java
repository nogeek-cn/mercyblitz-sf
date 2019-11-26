package lesson4;

import java.util.*;
import java.util.function.Predicate;


public class PredicateDesignDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Collection<Integer> even = filter(numbers, num -> num % 2 == 0);
        Collection<Integer> odd = filter(numbers, num -> num % 2 != 0);

        System.out.println(even);
        System.out.println(odd);
    }

    private static <E> Collection<E> filter(Collection<E> source,
                                            Predicate<E> predicate) {
        // 集合类的操作，请不要直接利用参数
        List<E> copy = new ArrayList<E>(source);
        Iterator<E> iterator = copy.iterator();
        while (iterator.hasNext()) {
            E next = iterator.next();
            if (!predicate.test(next)) {
                iterator.remove();
            }
        }
        return Collections.unmodifiableList(copy);
    }
}
