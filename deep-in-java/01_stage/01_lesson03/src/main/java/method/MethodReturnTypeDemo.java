package method;

import java.util.*;

public class MethodReturnTypeDemo {


    // 需求返回一个有序的，去重的字符串
    public TreeSet<String> getValues() { // 错误的写法
        return new TreeSet<>();
    }

    // 动词 + 形容 + 名词
    // 后续更加强类型
    public SortedSet<String> getSortedValues() { // 正确范例
        return Collections.emptySortedSet();
    }

    /***
     *
     * @return 这个方法的确是只读，但是有一个
     * E set(int index, E element);
     * 方法，直接修改它的值
     */
    public static List<Integer> getErrorNumbers() {
        return Arrays.asList(1, 3, 4, 5, 5, 6);
    }

    // 原则三：确保集合返回接口只读
    public static List<Integer> getNumbers() {
        return Collections.unmodifiableList(Arrays.asList(3, 4, 5, 3, 5));
    }

    // 数组只能保证长度不变，不能保证只读
    private static Integer[] getNumberArray() {
        return new Integer[]{33, 34, 55, 56};
    }

    // 原则四：如果需要需要只读集合返回的话，那么确保返回快照
    private static List<Integer> getNumbersSnapshot() {
        return new ArrayList<>(Arrays.asList(3, 4, 5, 6, 2));
    }

    public static void main(String[] args) {
        List<Integer> numbers = getErrorNumbers();
        System.out.println(numbers);
        // Arrays.asList 并非只读，尽管在 add 方法操作是，抛出异常
        numbers.set(1, 0);
        System.out.println(numbers);


        List<Integer> numbers1 = getNumbers();
//        numbers1.set(3, 4);
        System.out.println(numbers1);

        Integer[] numberArray = getNumberArray();
        System.err.println(Arrays.asList(numberArray));

        numberArray[2] = 0;
        System.err.println(Arrays.asList(numberArray));
    }


}
