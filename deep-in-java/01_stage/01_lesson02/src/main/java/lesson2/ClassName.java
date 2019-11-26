package lesson2;

import java.lang.reflect.Field;

public class ClassName {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // 常量化是原生类型支持，复制方式
        int a = 1; // 常量
        // 常量来自于非堆里边的内存
        String value = "Hello"; // 常量（语法特性）= 对象类型常量化

        // 面向对象规则：一切对象需要 new
        // 合法的写法（会被视作异类）
        String value2 = new String("Hello");

        System.out.println("value = " + value);
        System.out.println("value2 = " + value2);
        // 从 Java 1.5 开始，对象属性可以通过反射修改
        char[] chars = "world".toCharArray();
        // 获取 String 类中的 value 字段
        Field valueFiled = String.class.getDeclaredField("value");
        // 设置 private 字段可以被修改
        valueFiled.setAccessible(true);
        valueFiled.set(value2, chars);
        System.out.println("value2= " + value2);
    }

    public static class ExtendableString {
        private final char value[];
        private int hash;

        public ExtendableString(String value) {
            this.value = value.toCharArray();
        }

        public int hashCode() {
            int h = hash;
            if (h == 0 && value.length > 0) {
                char val[] = value;

                for (int i = 0; i < value.length; i++) {
                    h = 31 * h + val[i];
                }
                hash = h;
            }
            return h;
        }
    }

    public boolean equals(Object anObject) {
        return true;
    }

}
