package lesson3;

import lombok.Getter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


public class testRuntimeType {
    public static void main(String[] args) {
        RuntimeWildCardDemo<String> a = new Child();
        System.out.println(a.getAnnotationType());
    }
}

class Child extends RuntimeWildCardDemo<String> {

}

@Getter
class RuntimeWildCardDemo<T> {
    private final Class<T> annotationType;

    public RuntimeWildCardDemo() {
        this.annotationType = ClassUtils.resolveGenericType(getClass());
    }
}

abstract class ClassUtils {
    public static <T> Class<T> resolveGenericType(Class<?> declaredClass) {
        ParameterizedType parameterizedType = (ParameterizedType) declaredClass.getGenericSuperclass();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        return (Class<T>) actualTypeArguments[0];
    }
}