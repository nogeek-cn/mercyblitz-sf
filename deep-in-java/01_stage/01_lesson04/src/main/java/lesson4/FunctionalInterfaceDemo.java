package lesson4;


public class FunctionalInterfaceDemo {

    public static void main(String[] args) {
        Function1 function1 = () -> {

        };

        FunctionInterfaceWithoutAnnotation function2 = () -> {

        };
    }

    @FunctionalInterface
    public interface Function1 {
        // public abstract 可有可无
        void execute();

        //      不能出现两次抽象方法定义
        // void execute2();
        default String getDescription() {
            return String.valueOf(this);
        }
    }

    //    @FunctionalInterface // @FunctionalInterface 并非必选的
    public interface FunctionInterfaceWithoutAnnotation {
        void execute();
    }

//    @FunctionalInterface // @FunctionalInterface 只能描述接口
//    public class FunctaionClass{
//
//    }
}
