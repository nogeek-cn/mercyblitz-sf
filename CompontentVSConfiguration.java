
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 控制台输出：
 *
 *      测试，Creating shared instance of singleton bean:  true 表示 singleton
 *      person_configuration==person_configuration:	true
 *      person_component==person_component:	true
 *
 *      测试，三个 father 下的 person 获取两次 都是 同一个 person 吗？:  true 表示 同一个 person
 *      father.person_configuration-bean-==:true
 *      father.person_component-bean-==:true
 *      father.person_component_Autowired-bean-==:true
 *
 *      测试，三个 father 下的 person 都是 配置类里边的 person  吗？:  true 表示 father.person = person
 *      father_configuration.person compare person == true
 *      father_component.person. compare person == false
 *      father_component_Autowired.person. compare person ==true
 */

/**
 * 这个类，用来测试 {@link Configuration} 和 {@link Component} 的区别
 *
 * 结论：
 * 1. @Configuration 注解对其中的 @Bean 注解提升的时候，你直接调用方法，就可以直接，进行 子属性 的注入
 * 2. @component
 *      1. 直接调用方法，虽然注入的子属性的值是一样的，但是确不是同一个对象，相当于有调用了一次方法，new 了一下
 *      2. 可以利用 @Autowired 注解，注入你想要注入的 @Bean
 */
public class CompontentVSConfiguration {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan(CompontentVSConfiguration.class.getPackage().getName());

        context.refresh();

        System.out.println("\n测试，Creating shared instance of singleton bean:  true 表示 singleton");
        System.out.println("person_configuration==person_configuration:\t" + (context.getBean("person_configuration")
                == context.getBean("person_configuration")));
        System.out.println("person_component==person_component:\t" + (context.getBean("person_component")
                == context.getBean("person_component")));

        System.out.println("\n测试，三个 father 下的 person 都是 同一个 person 吗？:  true 表示 同一个 person");
        System.out.println("father.person_configuration-bean-==:" + (context.getBean("father_configuration", Father.class).getPerson()
                == context.getBean("father_configuration", Father.class).getPerson()));
        System.out.println("father.person_component-bean-==:" + (context.getBean("father_component", Father.class).getPerson()
                == context.getBean("father_component", Father.class).getPerson()));
        System.out.println("father.person_component_Autowired-bean-==:" + (context.getBean("father_component_Autowired", Father.class).getPerson()
                == context.getBean("father_component_Autowired", Father.class).getPerson()));


        System.out.println("\n测试，三个 father 下的 person 都是 配置类里边的 person  吗？:  true 表示 father.person = person");
        System.out.println("father_configuration.person compare person == " + (context.getBean("father_configuration", Father.class)
                .getPerson() == context.getBean("person_configuration")));

        System.out.println("father_component.person. compare person == " + (context.getBean("father_component", Father.class).getPerson()
                == context.getBean("person_component")));

        System.out.println("father_component_Autowired.person. compare person ==" + (context.getBean("father_component_Autowired",
                Father.class).getPerson() == context.getBean("person_component")));

    }

}

@Configuration
class configurationClass {

    @Bean
    public Father father_configuration() {
        return Father.builder()
                .person(person_configuration())
                .build();
    }

    @Bean
    public Person person_configuration() {
        return Person.builder()
                .id("configuration-id")
                .name("configuration-name")
                .build();
    }
}

@Component
class componentClass {

    @Autowired
    @Qualifier("person_component")
    private Person person_component;

    @Bean
    public Person person_component() {
        return Person.builder()
                .id("component-id")
                .name("component-name")
                .build();
    }

    @Bean
    public Father father_component_Autowired() {
        return Father.builder()
                .person(person_component)
                .build();
    }

    @Bean
    public Father father_component() {
        return Father.builder()
                .person(person_component())
                .build();
    }
}

@Data
@Builder
class Person {
    private String name;
    private String id;
}

@Builder
@Data
class Father {
    private Person person;
}
