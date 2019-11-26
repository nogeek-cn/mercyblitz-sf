package lesson04;


import java.util.Arrays;
import java.util.stream.Stream;

/***
 * 冒泡排序
 * @param <T>
 */
public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] values) {
        // Comparable.compareTo
        // < return -1
        // = return 0;
        // > return 1
        int size = values.length;

        // Given array: [3,1,2,5,4]
        // for 1
        // for 2

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                // 第 j 号元素与 j + 1 对比
                if (values[j].compareTo(values[j + 1]) == 1) { // 低位 > 高位
                    // 交换元素
                    T t = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = t;
                    // [0] = 3 , [1] = 2
                    // [1] = [1](2) + [0](3) = 5
                    // [0] = [1](5) - [0](3) = 2
                    // [1] = [1](5) - [0](2) = 3
                }
            }
            System.out.printf("第%d轮：%s\n", i + 1, Arrays.toString(values));
        }
    }

    /***
     * second exchange method
     * [0] = 3, [1] = 2
     * [1] = [1](2) + [0](3) = 5
     * [0] = [1](5) - [0](3) = 2
     * [0] = [1](5) - [0](2) = 3
     */

    public static void main(String[] args) {
        Integer[] values = Sort.of(1, 3, 4, 6, 3, 5, 65, 3, 6, 2);
        Sort<Integer> sort = new BubbleSort<>();
        sort.sort(values);
        Stream.of(values).forEach(System.out::println);
    }
}
