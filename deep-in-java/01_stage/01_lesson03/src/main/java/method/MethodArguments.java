package method;

import java.util.Collection;

public class MethodArguments implements Comparable<MethodArguments> {

    public static void main(String[] args) {
        // arguments 通常形容方法参数
        // parameters 通常指的是外部媒介传递过来的，请求参数

    }
//
//    @Override
//    public boolean equals(Object that) {
//        return super.equals(that);
//    }


    @Override
    public boolean equals(Object another) {
        return super.equals(another);
    }


    @Override
    public int compareTo(MethodArguments another) {
        return 0;
    }

    //  单项传输 ->  对等方式
    public void copy(Object source, Object target) {

    }

    //  单项传输 -> 参数类型非对等
    public void add(Collection<Object> collection, Object element) {

    }

    /***
     *
     * @param collection collection
     * @param elements zero or more elements (0..n)
     */
    // 多项传输 -> 参数类型非对等
    public void add(Collection<Object> collection, Object... elements) {

    }


    /***
     * 必须传递一个参数过来
     * @param collection collection
     * @param one one element
     * @param others more elements(0..n)
     */
    // 多项传输 -> 参数类型非对等
    public void add(Collection<Object> collection, Object one,
                    Object... others) {

    }

    // 多项传输 -> 参数类型对等
    public void addAll(Collection<Object> destiniion, Collection<Object> source) {
        destiniion.addAll(source);
    }
}
