package lesson03;

import lombok.Data;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;

public class IdentityHashMapDemo {
    public static void main(String[] args) {
        demoHashMap();
        demoIndentityHashMap();

        Object a = new Object();
        demoIdentityhashCodeAndHashCode(a, a);

        Object b = new Object();
        demoIdentityhashCodeAndHashCode(a, b);

        demoIdentityhashCodeAndHashCode("AA", "AA");

        demoIdentityhashCodeAndHashCode(new String("AA"), new String("AA"));

    }

    private static void demoIdentityhashCodeAndHashCode(Object o1, Object o2) {
        System.out.println("System.identityHashCode(" + o1 + "): " + System.identityHashCode(o1));
        System.out.println("Objects.hashCode(" + o1 + "): " + Objects.hashCode(o1));

        System.out.println("System.identityHashCode(" + o1 + ") == System.identityHashCode(" + o2 + ")  :  " +
                (System.identityHashCode(o1) == System.identityHashCode(o2)));
        System.out.println("Objects.hashCode(" + o1 + ") == Objects.hashCode(" + o2 + ")  :  " +
                (Objects.hashCode(o1) == Objects.hashCode(o2)));

    }

    private static void demoIndentityHashMap() {
        demoMap(new IdentityHashMap<>());
    }

    private static void demoHashMap() {
        demoMap(new HashMap<>());
    }

    private static void demoMap(Map<String, Integer> map) {
        map.put("A", 1);
        map.put(new String("A"), 1);

        // 普通的 HashMap 是 key 的 hashCode 和 equals 来实现
        System.out.println(map.getClass());
        System.out.println("A" == (new String("A")));
        System.out.println("A".equals(new String("A")));
        System.out.println("A".hashCode() == (new String("A")).hashCode());
        System.out.println(map.size());
    }

    @Data
    public static class ModuleDo {
        private String name;
        private Integer age;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ModuleDo moduleDo = (ModuleDo) o;
            return Objects.equals(name, moduleDo.name) &&
                    Objects.equals(age, moduleDo.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }
}
