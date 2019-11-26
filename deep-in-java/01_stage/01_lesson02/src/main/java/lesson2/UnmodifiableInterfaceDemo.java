package lesson2;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class UnmodifiableInterfaceDemo {
    public static void main(String[] args) {
        Collection<Integer> values = of(1, 2, 3, 4, 5);
        values.add(6);
        System.out.println(values);

        Collection<Integer> unmodifiableS = UnmodifiableOf(1, 2, 3, 4, 5);
        // 不允许修改，

        unmodifiableS.add(6);//  这一步就会报错
    }

    public static Collection<Integer> of(Integer... values) {
        return new ArrayList<Integer>(Arrays.asList(values));
    }

    public static Collection<Integer> UnmodifiableOf(Integer... values) {
        return Collections.unmodifiableList(Arrays.asList(values));
    }
}
