package com.AoChen.singleTon;

/**
 * <p>
 * description xxx
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public class SingleTon {
    private static SingleTon instance;
    private int value;
    private String name;

    // 构造方法私有化
    private SingleTon(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 提供静态方法供外部访问
    public static SingleTon getInstance() {
        if (instance == null) {
            instance = new SingleTon(0, "");
        }
        return instance;
    }
}
