package lesson2;

import java.util.*;

public class MapAndSetDemo {
    public static void main(String[] args) {
        // 通常 Set 就是 Map key 的实现，Set 底层运用了 Map 的实现
        // HashSet 底层运用了 hashMap
        // 散列码（Hash）索引

        // 二叉树平衡。

        Map<String, Object> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        // tab[1] hashCode = 9  key = 'a'
        // tab[2] hashCode = 10 key = 'a'
        // tab[3] hashCode = 9  key = 'a'


        // TreeSet 底层运用了 TreeMap
        map = new TreeMap<>();
        set = new TreeSet<>();


    }
}
