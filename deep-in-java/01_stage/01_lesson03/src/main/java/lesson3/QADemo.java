package lesson3;

import org.springframework.core.ResolvableType;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class QADemo<T extends Serializable> {
    private List<Map<String, List<Object>>> values = Collections.emptyList();

    public static void main(String[] args) throws Exception {
        question1();
    }

    private static void question1() throws Exception {
        // 获取成员泛型参数类型
        Field field = QADemo.class.getDeclaredField("values");
        ResolvableType resolvableType = ResolvableType.forField(field);
        System.out.println(resolvableType.getGeneric(0));

        // 获取类泛型参数类型
        TypeVariable[] typeParameters = QADemo.class.getTypeParameters();
        for (TypeVariable typeParameter : typeParameters) {
            System.out.println(typeParameter);
        }
    }
}


