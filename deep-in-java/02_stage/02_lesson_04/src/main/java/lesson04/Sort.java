package lesson04;

import java.util.Comparator;

/***
 * 排序接口<p/>
 * 原地（在地）排序 - in_place
 */
public interface Sort<T extends Comparable<T>> {
    void sort(T[] values);

    static <T> T[] of(T... values) {
        return values;
    }
}
