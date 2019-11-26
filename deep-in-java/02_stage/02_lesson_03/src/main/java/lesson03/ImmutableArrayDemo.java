package lesson03;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

public class ImmutableArrayDemo {
    public static void main(String[] args) {
        // values object address : 100
        Integer[] values = of(1, 3, 4, 5);
        // 数组的特性，长度不变（特殊不变），内容可被替换

        // 数组的 copy 与对象的 Clone 是类似，浅克隆（复制）
        Integer[] valuesCopy = Arrays.copyOf(values, values.length);
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i] == valuesCopy[i]);
        }

        // 修改复制后的内容，并没有改变原来的对象
        valuesCopy[0] = 99;
        System.out.println(Arrays.toString(values));

        Integer[] newValues = new Integer[3];// 开辟了三个元素大小的数组空间， molloc


        User[] users = of(1L, 3L, 4L);
        User[] usersCopy = Arrays.copyOf(users, values.length);
        // 假设 usersCopy 作为返回值对象的话，那么此时会不会有安全问题。
        // 修改 usersCopy 的第一个 User 对象
        usersCopy[0].setId(100L);
        // 输出老的 users ,检查 users 的第一个对象会不会被修改
        System.out.println(Arrays.toString(users));

    }

    private static User[] of(Long... ids){
        User[] users = new User[ids.length];
        for (int i = 0; i < ids.length; i++) {
            users[i] = new User(ids[i]);
        }
        return users;
    }

    @AllArgsConstructor
    @Data
    private static class User {
        private  Long id;
    }

    private static Integer[] of(Integer... values) { // Integer... == Integer[]
        // 上边释放掉，下边也会释放
        return values;
    }
}
