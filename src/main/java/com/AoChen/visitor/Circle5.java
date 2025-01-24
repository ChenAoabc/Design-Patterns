package com.AoChen.visitor;

/**
 * <p>
 * description xxx
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public class Circle5 implements Shape5{
    private double radius;
    public Circle5(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * 指定访问者
     *
     * @param visitor 访问者
     */
    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.accept(this);
    }
}
