package lesson2;

import java.lang.reflect.Modifier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumClassDemo {

    public static void main(String[] args) {
        // Q1: ONE 是否是第几个定义的
        // Q1: 能否输出所有的成员
        println(Counting.ONE);
        println(Counting.FIVE);

        // Q3: 为什么枚举会输出成员名称
        println(CountingEnum.ONE);
        println(CountingEnum.FIVE);


        printEnumMeta(CountingEnum.ONE);
        printEnumMeta(CountingEnum.FIVE);

        // Java 枚举字节码提升实现 values();
        printEachNumbers();
        // 自定义实现 values()
        printCountingNumbers();
    }


    public static void println(Counting counting) {
        System.out.println(counting);
    }

    public static void println(CountingEnum countingEnum) {
        System.out.println(countingEnum);
    }

    public static void printEnumMeta(Enum enumeration) {
        System.out.println("enumeration type : " + enumeration.getClass());
        // Enum#name() = 成员的名称
        // Enum#ordinal() = 成员定义位置
        System.out.println("member ： " + enumeration.name());
        System.out.println("ordinal : " + enumeration.ordinal());
        // values() 方法是 Java 编译器给枚举提升的方式
    }

    public static void printEachNumbers() {
        Stream.of(CountingEnum.values())
                .forEach(System.out::println);
    }

    public static void printCountingNumbers() {
        Stream.of(Counting.values())
                .forEach(System.out::println);
    }
}


enum CountingEnum {
    ONE(1) {
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    },
    TWO(2) {
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    },
    THREE(3) {
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    },
    FOUR(4) {
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    },
    FIVE(5) {
        @Override
        public String valueAsString() {
            return String.valueOf(this.getValue());
        }
    };

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public abstract String valueAsString();

    CountingEnum(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CountingEnum{" +
                "value=" + value +
                '}';
    }
}


class CountingExtend extends Counting{

    private CountingExtend(int value) {
        super(value);
    }
}

/***
 * 枚举类：计数
 * 强类型约束（相对于常亮）
 * * * 我用常亮来定义我自己这个类，用数据状态来表述我自己
 */
class Counting {
    public static final Counting ONE = new Counting(1);
    public static final Counting TWO = new Counting(2);
    public static final Counting THREE = new Counting(3);
    public static final Counting FOUR = new Counting(4);
    public static final Counting FIVE = new Counting(5);

    private int value;

    protected Counting(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Counting{" +
                "value=" + value +
                '}';
    }

    public static Counting[] values() {
        Counting[] values = null;

        // Fields -> filter -> public static final fields -> get

        values = Stream.of(Counting.class.getDeclaredFields())
                .filter(field -> {
                    int modifiers = field.getModifiers();
                    return Modifier.isPublic(modifiers) &&
                            Modifier.isStatic(modifiers) &&
                            Modifier.isFinal(modifiers);
                }).map(field -> {
                    // Filed -> Counting
                    try {
                        return (Counting) field.get(null);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList()).toArray(new Counting[0]);

        return values;
    }
}
