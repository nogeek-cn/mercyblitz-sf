package lesson1;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collections;


public class UnnamedModuleDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.close();


        StringUtils.isBlank("OK");

        MapUtils.isEmpty(Collections.emptyMap());
    }
}
