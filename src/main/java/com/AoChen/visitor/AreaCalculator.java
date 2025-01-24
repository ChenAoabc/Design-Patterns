package com.AoChen.visitor;

/**
 * <p>
 * description xxx
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public class AreaCalculator implements ShapeVisitor{
    private double area;
    public AreaCalculator(double area) {
        this.area = area;
    }
    @Override
    public void accept(Circle5 circle5) {
        area += circle5.getRadius()*circle5.getRadius()*Math.PI;
    }

    @Override
    public void accept(Rectangle5 rectangle5) {
        area+=rectangle5.getHeight()*rectangle5.getWidth();
    }
    public double getArea() {
        return area;
    }
}
