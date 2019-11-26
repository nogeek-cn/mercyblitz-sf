package lesson2;


public class CloneableDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        CustomData customData = new CustomData();
        customData.setValue(3);
        customData.setDesc("hello, world");
        // 浅拷贝
        CustomData customDataClone = customData.clone();
        System.out.println(customDataClone.getValue());

        System.out.println(customDataClone.getDesc() == customData.getDesc());
        System.out.println(customDataClone.getDesc().equals(customData.getDesc()));
    }


}

class CustomData extends Object implements Cloneable {
    private int value;
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /***
     * 通常把 protected 访问性提升为 public
     * @return
     * @throws CloneNotSupportedException
     */
    public CustomData clone() throws CloneNotSupportedException {
        // 原生类型没有深浅关系
        CustomData copy = (CustomData) super.clone();
        // 深度拷贝
        copy.setDesc(new String(this.desc));
        return copy;
    }
}
