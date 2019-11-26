package lesson2;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeepCloneDemo {
    public static void main(String[] args) throws Exception {
        ArrayList<String> values = new ArrayList<>();
        values.addAll(new ArrayList<String>(Arrays.asList("sf", "sf", "sf", "sf", "sdfs")));
        System.out.println("shallowClone:==========");
        // 浅拷贝
        List<String> shallowClone = (List<String>) values.clone();
        displayDiff(values, shallowClone);

        List<String> deepClone = deepClone(values);
        System.out.println("DeepClone:=========");
        displayDiff(values, deepClone);

        System.out.println("deepCloneSerialization===========");
        List<String> deepCloneSerializable = deepCloneSerializable(values);
        displayDiff(values, deepCloneSerializable);
    }

    private static void displayDiff(List<String> values, List<String> deepClone) {

        for (int i = 0; i < values.size(); i++) {
            System.out.println("Object equals : " + (values.get(i).equals(deepClone.get(i))));
            System.out.println("Object == : " + (values.get(i) == deepClone.get(i)));
        }
    }

    /***
     * 克隆完以后，对象 equals 相等，但是 ！=
     * @param source
     * @return
     */
    private static List<String> deepClone(List<String> source) {
        List<String> clone = new ArrayList<>();
        for (String s : source) {
            clone.add(new String(s));
        }
        return clone;
    }

    private static List<String> deepCloneSerializable(List<String> source) throws Exception {
        ArrayList<String> copy = new ArrayList<>(source);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        // Copy 对象序列化
        objectOutputStream.writeObject(copy);

        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        List<String> clone = (List<String>)objectInputStream.readObject();

        return clone;
    }
}
