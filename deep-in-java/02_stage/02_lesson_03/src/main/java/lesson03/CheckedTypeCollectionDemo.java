package lesson03;


import java.util.*;

public class CheckedTypeCollectionDemo {
    public static void main(String[] args) {
        // List 元素类型是 java.lang.Integer
        List<Integer> values = new ArrayList<>(Arrays.asList(1, 3));
        // values.add("1"); // 编译错误
        // 泛型是编译时检查，运行时擦鞋

        // 引用 List<Integer> 类型对象 values
        List referencedValues = values;
        referencedValues.add("AAA");

        // 运行时的数据 List<Integer> == List<Object> == List;
        // values.add("1"); // 运行时允许，因为成员是 Object
        // values.forEach(System.out::println);

        for (Object value : values) {
            System.out.println(value);
        }

        // values
        // [0] = 1, [2] = 2 ...
        // 创建时尚未检查内部的数据是否相同，操作时，做检查，Wrapper 模式的运用9
        List<Integer> checkedCollection = Collections.checkedList(values, Integer.class);

        referencedValues = checkedCollection;

        // Attempt to insert class java.lang.String element into collection with element type class java.lang.Integer
        referencedValues.add("AAA");
    }
}
