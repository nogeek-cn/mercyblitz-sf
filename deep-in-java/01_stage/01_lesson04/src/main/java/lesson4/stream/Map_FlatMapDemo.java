package lesson4.stream;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.stream.Collectors;

public class Map_FlatMapDemo {

    public static Map<String, List<PersonModule>> stringListStringMap = new HashMap<>();

    public static List<PersonModule> getModuleList(String key){
        return Optional.ofNullable(stringListStringMap.get(key))
                .orElse(Collections.emptyList());
    }

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("1", "2");
//        stringList = Optional.ofNullable(stringList)
//                .orElse(Collections.emptyList());

        List<String> nameList = Optional.ofNullable(stringList)
                .orElse(Collections.emptyList())
                .stream()
                .map(key -> Optional.ofNullable(stringListStringMap.get(key))
                        .orElse(Collections.emptyList()))
                .flatMap(List::stream)
                .map(PersonModule::getName)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(nameList);
        System.err.println("---------------");

        String jsonString = JSON.toJSONString(stringListStringMap);
        Map<String, List<PersonModule>> jsonToMap = JSONObject.parseObject(jsonString)
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> JSONObject.parseArray(String.valueOf(entry.getValue()), PersonModule.class)));

        System.out.println(jsonToMap);
        System.err.println("---------------");


    }

    static {
        List<PersonModule> stringList1 = Arrays.asList(
                new PersonModule().setName("aaa"),
                new PersonModule().setName("bbb"),
                new PersonModule().setName("ccc"));
        List<PersonModule> stringList2 = Arrays.asList(
                new PersonModule().setName("aaa"),
                new PersonModule().setName("ccc"),
                new PersonModule().setName("ddd"),
                new PersonModule().setName("eee"));

        List<PersonModule> stringList3 = Arrays.asList(
                new PersonModule().setName("ddd"),
                new PersonModule().setName("eee"));


        List<List<PersonModule>> lists = Arrays.asList(stringList1, stringList2);

        stringListStringMap.put("1", stringList1);
        stringListStringMap.put("2", stringList2);
        stringListStringMap.put("3", stringList3);

    }
}

class PersonModule {
    private String name;

    public String getName() {
        return name;
    }

    public PersonModule setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "PersonModule{" +
                "name='" + name + '\'' +
                '}';
    }
}