package com.AoChen.bridge;

/**
 * <p>
 * description xxx
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public abstract class   Shape {
    protected Color color;

    public Shape(Color color){
        this.color = color;
    }

    public abstract void draw();
}
