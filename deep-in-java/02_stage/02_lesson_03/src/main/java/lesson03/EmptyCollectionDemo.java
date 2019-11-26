package lesson03;

import java.util.*;

public class EmptyCollectionDemo {
    public static void main(String[] args) {
        Map<String, Boolean> map = new HashMap<>();
        // map.put("aaa",true);
        // 当 map 不为 empty()  java.lang.IllegalArgumentException: Map is non-empty
        Set<String> setFromMap = Collections.newSetFromMap(map);
        Set<String> keySet = map.keySet();

        setFromMap.add("aaa");
        // keySet.add("bbbbssss");
        // keySet 不可变 java.lang.UnsupportedOperationException
        map.put("bbb",false);
        System.out.println(map);
        System.out.println(setFromMap);
        System.out.println(keySet);
    }

    private static List<String> getIdsList(String name) {
        if (name == null || name.length() < 1) {
            return Collections.emptyList();
        }
        // 只读 empty List
        // 实现 Java 序列化，RPC 场景需要用，
        // Hession 的某些版本也需要参数实现 Serializable 接口，表示可以序列化
        return Collections.emptyList();
    }
}
