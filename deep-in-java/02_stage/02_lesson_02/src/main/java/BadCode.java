public class BadCode {

    public void countDemo(){
        int num = 0;
        for (int i = 0; i < 100; i++) {
            num = num ++;

        }
        System.out.println(num);
    }

    public static void main(String[] args) {
        new BadCode().countDemo();
    }
}
