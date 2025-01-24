package com.AoChen;

import com.AoChen.adapter.LegacyRectangle;
import com.AoChen.adapter.RectangleAdapter;
import com.AoChen.adapter.Shape2;
import com.AoChen.bridge.*;
import com.AoChen.factoryMethod.CircleFactory;
import com.AoChen.factoryMethod.Shape3;
import com.AoChen.factoryMethod.ShapeFactory;
import com.AoChen.flyweight.FlyweightFactory;
import com.AoChen.flyweight.Shape6;
import com.AoChen.prototype.Shape4;
import com.AoChen.proxy.ProxyImage;
import com.AoChen.singleTon.SingleTon;
import com.AoChen.strategy.Addition;
import com.AoChen.strategy.Calculator;
import com.AoChen.strategy.Multiplication;
import com.AoChen.strategy.Subtraction;
import com.AoChen.templateMethod.AbstractClass;
import com.AoChen.templateMethod.ConcreteClass;
import com.AoChen.visitor.AreaCalculator;
import com.AoChen.visitor.Circle5;
import com.AoChen.visitor.LengthCalculator;
import com.AoChen.visitor.Rectangle5;

/**
 * <p>
 * description
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public class Main {

    public static void main(String[] args) {
//        adapterPatternExample();
//        bridgePatternExample();
//        factoryMethodExample();
//        flyweightPatternExample();
//        prototypePatternExample();
//        proxyPatternExample();
//        singleTonPatternExample();
//        strategyPatternExample();
//        templateMethodPatternExample();
//        visitorPatternExample();

    }

    private static void visitorPatternExample() {
        Circle5 circle5 = new Circle5(5);
        Rectangle5 rectangle5 = new Rectangle5(4, 5);

        // 计算面积
        AreaCalculator calculator = new AreaCalculator(0);
        calculator.accept(circle5);
        calculator.accept(rectangle5);
        System.out.println("all Area:"+calculator.getArea());

        // 计算周长
        LengthCalculator lengthCalculator = new LengthCalculator();
        lengthCalculator.accept(circle5);
        lengthCalculator.accept(rectangle5);

        System.out.println("all length:"+lengthCalculator.getLength());
    }

    private static void templateMethodPatternExample() {
        // 创建模板对象
        AbstractClass template = new ConcreteClass();
        // 调用模板方法--执行算法
        template.templateMethod();
    }

    private static void strategyPatternExample() {
        Calculator calculator = new Calculator();
        try {
            // 加法策略
            calculator.setOperation(new Addition());
            int result1 = calculator.performOperation(5, 3);
            System.out.println(result1);

            // 减法策略
            calculator.setOperation(new Subtraction());
            int result2 = calculator.performOperation(5, 3);
            System.out.println(result2);

            // 乘法策略
            calculator.setOperation(new Multiplication());
            int result3 = calculator.performOperation(5, 3);
            System.out.println(result3);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static void singleTonPatternExample() {
        SingleTon instance = SingleTon.getInstance();
        SingleTon instance1 = SingleTon.getInstance();
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());
    }

    private static void proxyPatternExample() {
        ProxyImage proxyImage = new ProxyImage("xia.jpg");
        proxyImage.display();
    }

    private static void prototypePatternExample() {
        // 创建原型对象
        Shape4 circle = new Shape4("Circle");

        // 克隆原型对象来创建新对象
        Shape4 cloned = circle.clone();
        cloned.setType("Cloned Circle");

        // 输出原型对象和克隆对象的类型
        System.out.println("Original Shape Type:"+circle.getType());
        System.out.println("Cloned Shape Type:"+cloned.getType());
    }

    private static void flyweightPatternExample() {
        String[] colors = {"red", "green", "blue", "yellow"};
        // 生成随机的20个不同坐标和颜色的的对象，其中颜色具有范围
        for (int i = 0; i <20; i++) {
            String color = colors[(int)(Math.random()*colors.length)];
            Shape6 circle = FlyweightFactory.getShape(color);
            circle.draw((int) (Math.random()*100), (int) (Math.random()*100));
        }
    }

    private static void factoryMethodExample() {
        // 创建工厂类，并指定具体的实现工厂
        ShapeFactory circleFactory = new CircleFactory();
        // 通过工厂类获得具体的图像
        Shape3 shape3 = circleFactory.createShape3();
        // 执行方法
        shape3.draw();
    }

    /**
     * <p>
     * Color 接口代表颜色的实现部分，
     * Red 和 Blue 分别是实现了颜色接口的具体颜色类。
     * Shape 是形状的抽象部分，具有一个颜色引用，
     * 而 Circle 和 Square 是继承自 Shape 的具体形状类。
     * 这种设计允许我们在不改变形状或颜色的情况下，
     * 独立地对它们进行扩展和变化。
     * </p>
     *
     * @author ao.chen02@hand-china.com 2025/1/24 10:21
     */
    private static void bridgePatternExample() {
        Color red = new Red();
        Color blue = new Blue();
        Shape circle = new Circle(red);
        Shape square = new Square(blue);
        circle.draw();
        square.draw();
    }

    /**
     * <p>
     * 适配器模式
     * 作用：将两个不兼容的接口（类，或对象），进行兼容，使两者可以进行工作
     * 原理：其使用一个<x>适配器（中间者）</x>，将一个接口（类）适配到另外一个接口（类），使得两个对象能协同工作，
     * 其中适配器类中包含一个对不兼容接口的引用，在适配器类中对其条件进行转换，使其和标准类进行兼容
     * </p>
     *
     * @author ao.chen02@hand-china.com 2025/1/24 10:06
     */
    private static void adapterPatternExample() {
        // 创建矩形对象
        LegacyRectangle legacyRectangle = new LegacyRectangle();
        // 创建适配器对象，并对矩形对象进行适配
        Shape2 shape2 = new RectangleAdapter(legacyRectangle);
        // 使用功能
        shape2.draw(10,20,50,30);
    }
}
