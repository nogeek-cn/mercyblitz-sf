package fileBigDate.threadRead;


public class MainTest {

    public static void main(String[] args) {
        String filePath = getThisClassPackagePathWhenMaven() + "reliability.txt";

        BigFileReader.Builder builder = new BigFileReader.Builder(filePath, line -> {
//            String threadName = Thread.currentThread().getName();
            // 打印每行数据
//            System.err.println("[" + threadName + "] read line: " + line);
        });
        builder.withTreahdSize(10)
                .withCharset("gbk")
                .withBufferSize(1024 * 1024);
        BigFileReader bigFileReader = builder.build();
        bigFileReader.start();

    }

    private static String getThisClassPackagePathWhenMaven() {
        String jvmPath = MainTest.class.getResource("").getPath();
        return jvmPath.substring(1, jvmPath.length())
                .replace("target/classes", "src/main/java");
    }
}
