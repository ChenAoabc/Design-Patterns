package com.AoChen.visitor;

/**
 * <p>
 * description xxx
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public class Rectangle5 implements Shape5{
    private double width;
    private double height;
    public Rectangle5(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.accept(this);
    }
}
