package com.AoChen.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * description xxx
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public class FlyweightFactory {
    private static final Map<String, Shape6> shapes = new HashMap<String, Shape6>();
    public static Shape6 getShape(String color) {
        Shape6 circle = shapes.get(color);
        if (Objects.isNull(circle)) {
            circle = new Circle6(color);
            shapes.put(color, circle);
        }
        return circle;
    }
}
