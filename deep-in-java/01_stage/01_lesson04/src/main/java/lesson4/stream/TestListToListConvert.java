package lesson4.stream;


import java.util.*;
import java.util.stream.Collectors;

/***
 * peek 一般用于日志输出
 */
public class TestListToListConvert {

    static List<Module1> module1List;
    static List<Module2> module2List;


    static {
//        module1List = new ArrayList<>(Arrays.asList(new Module1().setId("1").setName("Module1-1"),
//                new Module1().setId("2").setName("Module1-2"),
//                new Module1().setId("3").setName("Module1-3")));

        module2List = new ArrayList<>(Arrays.asList(new Module2().setId("1").setName("Module2-1"),
                new Module2().setId("2").setName("Module2-2-1"),
                new Module2().setId("2").setName("Module2-2-2"),
                new Module2().setId("4").setName("Module2-4")));


        module1List = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            String id = String.valueOf(i);
            String name = "Module1-" + id;
            module1List.add(new Module1().setId(id).setName(name));
        }


        for (int i = 5; i < 100000; i = i + 2){
            String id = String.valueOf(i);
            String name = "Module2-" + id;
            module1List.add(new Module1().setId(id).setName(name));

        }

    }

    public static void main(String[] args) {
        int count = 1000;
        long l1 = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            function1();
        }

        long l2 = System.currentTimeMillis();

//        function2();

        System.gc();
        long l3 = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            function2();
        }

        long l4 = System.currentTimeMillis();

//        function3();


        System.gc();
        long l5 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            function3();
        }
        long l6 = System.currentTimeMillis();

        System.gc();
        long l7 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            function4();
        }
        long l8 = System.currentTimeMillis();


        System.out.println();
        System.out.println("function1 - peek cost:[" + (l2 - l1) + "]ms");
        System.out.println("function2 - map cost:[" + (l4 - l3) + "]ms");
        System.out.println("function3 - map - Optional cost:[" + (l6 - l5) + "]ms");
        System.out.println("function3 - map - Optional - parallelStream cost:[" + (l8 - l7) + "]ms");


    }


    private static void consumerFunction() {

    }

    private static void function2() {
        Map<String, String> idNameMap = module2List.stream()
                .collect(Collectors.toMap(Module2::getId,
                        Module2::getName,
                        (oldValue, newValue) -> newValue));

        List<Module1> module1ListReturn = module1List.stream()
                .map(module1 -> mapName(module1, idNameMap))
//                .peek(System.out::println)
                .collect(Collectors.toList());


//        System.out.println("function2   map");
//        System.out.println(module1ListReturn);
    }


    public static void function3() {
        Map<String, String> idNameMap = module2List.stream()
                .collect(Collectors.toMap(Module2::getId,
                        Module2::getName,
                        (oldValue, newValue) -> newValue));


        List<Module1> module1ListReturn = module1List.stream()
                .map(module1 -> module1.setName(
                        Optional.ofNullable(idNameMap.get(module1.getId()))
                                .orElse(module1.getName())))
                .collect(Collectors.toList());


//        System.out.println("function3   map - Optional");
//        System.out.println(module1ListReturn);

    }

    public static void function4() {
        Map<String, String> idNameMap = module2List.stream()
                .collect(Collectors.toMap(Module2::getId,
                        Module2::getName,
                        (oldValue, newValue) -> newValue));


        List<Module1> module1ListReturn = module1List.parallelStream()
                .map(module1 -> module1.setName(
                        Optional.ofNullable(idNameMap.get(module1.getId()))
                                .orElse(module1.getName())))
                .collect(Collectors.toList());


//        System.out.println("function3   map - Optional - parallelStream");
//        System.out.println(module1ListReturn);

    }


    private static Module1 mapName(Module1 module1, Map<String, String> idNameMap) {
        String name = idNameMap.get(module1.getId());
        if (name != null)
            module1.setName(name);
        return module1;
    }

    public static void function1() {
        Map<String, String> idNameMap = module2List.stream()
                .collect(Collectors.toMap(Module2::getId,
                        Module2::getName,
                        (oldValue, newValue) -> newValue));

        List<Module1> module1ListReturn = module1List.stream()
                .peek(module1 -> peekName(module1, idNameMap))
//                .peek(System.out::println)
                .collect(Collectors.toList());

//        System.out.println("function1   peek");
//        System.out.println(module1ListReturn);
    }


    public static void peekName(Module1 module1, Map<String, String> idNameMap) {
        String name = idNameMap.get(module1.getId());
        if (name != null)
            module1.setName(name);
    }

}


class Module1 {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public Module1 setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Module1 setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Module1{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

class Module2 {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public Module2 setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Module2 setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Module2{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
