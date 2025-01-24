package com.AoChen.factoryMethod;

/**
 * <p>
 * description xxx
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public class CircleFactory extends ShapeFactory{
    @Override
    public Shape3 createShape3() {
        return new Circle3();
    }
}
