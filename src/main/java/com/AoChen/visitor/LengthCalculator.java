package com.AoChen.visitor;

/**
 * <p>
 * description xxx
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public class LengthCalculator implements ShapeVisitor{
    private double length;
    @Override
    public void accept(Circle5 visitor) {
        length+=2*visitor.getRadius()*Math.PI;
    }

    @Override
    public void accept(Rectangle5 visitor) {
        length+=2*(visitor.getHeight()+visitor.getWidth());
    }
    public double getLength() {
        return length;
    }
}