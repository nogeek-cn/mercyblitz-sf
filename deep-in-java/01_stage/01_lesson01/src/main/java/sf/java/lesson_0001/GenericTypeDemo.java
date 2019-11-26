package sf.java.lesson_0001;

import java.util.Collections;
import java.util.List;

public class GenericTypeDemo {
    /***
     *
     * @param <S> 来源类型
     * @param <T> 转换类型
     */
    public interface Converter<S, T> {
        T covert(S source);
    }

    public static void main(String[] args) {

        List<Integer> integers;
        List<String> strings;

        List<String> data = Collections.emptyList();
        List<Integer> data2 = Collections.emptyList();

//        data= data2;

        List data3 = Collections.emptyList();
        data2 = data3;

        Converter<Integer, String> stringConverter
                = new Converter<Integer, String>() {
            @Override
            public String covert(Integer source) {
                return source.toString();
            }
        };
        new Converter<String, Integer>() {
            @Override
            public Integer covert(String source) {
                return Integer.valueOf(source);
            }
        };
    }


    /***
     * 方法签名 #doCovert(List)
     * @param value
     */
    public static void doCovert(List<String> value){
    }
//    public static void doCovert(List value){
//    }
}
