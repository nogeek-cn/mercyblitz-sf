package lesson2;

public class InnerClassDemo {

    private int data;
    private C c;
    public class C {
        private int data;


    }
    public void setData() {
        c.data = this.data;
    }

    public static class B {

    }

    public /*static*/ interface A {

    }

    public static void main(String[] args) {
        A a = null;
        B b = null;
        C c = null;
    }
}
