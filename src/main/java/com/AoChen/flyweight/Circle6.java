package com.AoChen.flyweight;

/**
 * <p>
 * description xxx
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public class Circle6 implements Shape6 {
    private String color;
    public Circle6(String color) {
        this.color = color;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing a "+color+" circle at ("+x+","+y+")");
    }
}