package lesson03;


import java.util.*;

public class CollectionRemoveDemo {
    public static void main(String[] args) {
        List<String> values = new ArrayList<>(Arrays.asList("123", "323", "423", "523"));

        for (int i = 0; i < values.size();) {
            Object value = values.get(i);
            values.remove(value);
        }
        System.out.println(values);


        values = new ArrayList<>(Arrays.asList("123", "323", "423", "523"));
        Iterator<String> iterator = values.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        System.out.println(values);

//        values = new ArrayList<>(Arrays.asList("123", "323", "423", "523"));
//        // for- each 语法有问题
//        for (String value : values) {
//            values.remove(value);
//        }
//        System.out.println(values);
    }
}
