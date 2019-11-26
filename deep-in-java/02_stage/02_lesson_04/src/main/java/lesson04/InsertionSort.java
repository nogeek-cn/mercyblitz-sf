package lesson04;


public class InsertionSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] values) {
        int size = values.length;
        for (int i = 0; i < size; i++) {
            // 高位数 t
            // [3, 1, 2, 5, 4]
            // [j = 0] = 3, [i = 1] = 1 , t = [i = 1] = 1
            // [i = 1] = [j = 0] , [j = 0] = t = 1
            T t = values[i]; // 产生临时变量
            int j = i;
            while (j > 0 && t.compareTo(values[j - 1]) < 0) {
                //往后移动让出插入空间
                values[j] = values[j - 1];
                j--;
            }
            //插入values[i]到对应位置
            values[j] = t;
        }
    }
}
