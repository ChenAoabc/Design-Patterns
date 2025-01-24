package com.AoChen;

import com.AoChen.abstractFactory.*;
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
//        abstractFactoryExample();

    }

    private static void abstractFactoryExample() {
        SoftwareFactory windowsFactory = new WindowsFactory();
        OperatingSystem windowsOS = windowsFactory.createOperatingSystem();
        Application windowsApp = windowsFactory.createApplication();

        windowsOS.run();
        windowsApp.open();

        SoftwareFactory linuxFactory = new LinuxFactory();
        OperatingSystem linuxOS = linuxFactory.createOperatingSystem();
        Application linuxApp = linuxFactory.createApplication();

        linuxOS.run();
        linuxApp.open();
    }

    /**
     * <p>
     *  访问者模式
     * 作用：将元素类和操作分离，避免直接修改已经存在的元素类而造成的耦合。使得类的单一职责不被破坏
     * 原理：在已有元素类中添加访问控制，使用接口提供访问操作的规范，对接口的操作进行实现
     * 适用场景：需要避免直接修改基础类或元素类、基本对象和操作分离场景、需确保类的单一职责
     * </p>
     *
     * @author ao.chen02@hand-china.com 2025/1/24 11:25
     */
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
    /**
     * <p>
     *  模板方法模式
     * 作用：当设计一个类或算法时，发现整体的架构是固定的，但是某些步骤会因不同情景下会进行变化，
     *      这时可对核心骨架进行模板封装，而具体的细节可以抽象成抽象方法，由子类进行实现，从而是实现代码的复用和灵活解耦
     * 原理：模板方法模式通过定义一个抽象的父类，其中包含算法的核心结构和抽象的步骤方法，这些抽象的步骤方法由子类进行实现，
     *      而在核心结构中调用这些抽象步骤方法，从而是实现算法的整体流程一致。
     * 适用场景：
     * </p>
     *
     * @author ao.chen02@hand-china.com 2025/1/24 11:25
     */
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

    /**
     * <p>
     * 单例模式
     * 作用：确保整个应用中某个类的实例只有一个，从而有效节约资源和内存消耗，并提供全局的访问点
     * 缺点：
     * 1、可能导致全局状态难以控制
     * 2、模块之间存在紧耦合
     * 3、需要注意在多线程环境下的线程安全问题
     * 单例的方法：构造方法私有化、并提供静态方法给外部获取实例
     * 适用场景：对象内存消耗过大、频繁创建对象和释放对象、需要对对象进行集中管理
     * </p>
     *
     * @author ao.chen02@hand-china.com 2025/1/24 11:32
     */
    private static void singleTonPatternExample() {
        SingleTon instance = SingleTon.getInstance();
        SingleTon instance1 = SingleTon.getInstance();
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());
    }

    /**
     * <p>
     * 代理模式：
     * 由于创建对象或者方法调用比较麻烦（比如参数转换，参数需要再计算、对象安全性检查等）
     * 可以将对象的创建和访问交由中间者去处理，对外访问只需中间者提供简单的方式即可。
     * 这一过程就称为代理，其中的中间者，则称为代理对象。
     * 显然，外部需要使用较为复杂的对象时，只需通过代理对象提供的简单方法就可实现。
     * 从而避免许多不需要客户端处理的细节，
     * 极大的提高了代码的推广和应用，简化客户方的操作。
     * 同时也避免了操作源对象的相关安全性问题
     * </p>
     *
     * @author ao.chen02@hand-china.com 2025/1/24 11:33
     */
    private static void proxyPatternExample() {
        ProxyImage proxyImage = new ProxyImage("xia.jpg");
        proxyImage.display();
    }

    /**
     * <p>
     * 作用：解决对于复制成本较高，对象的具体类耦合的情况下复制复杂，需要提高对象的创建性能等问题的解决方法
     * 原理：通过复制现有对象来创建新对象，而不是从头开始构建，核心关键在对原型对象的克隆，使得新对象具备院校对象的初始状态
     * 限制： 1、深克隆问题：原型模式默认进行浅克隆，即复制对象本身和其引用，如果对象内部包含其他对象的引用，可能需要实现深克隆来复制整个结构
     *       2、克隆方法的实现：某些对象可能不容易进行克隆，特别是涉及到文件，网络连接等资源的情况
     * </p>
     *
     * @author ao.chen02@hand-china.com 2025/1/24 11:34
     */
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

    /**
     * <p>
     * description 享元模式
     * 作用：解决相似对象的共享问题，避免大量相似对象占用内存和系统资源
     * 方法：
     *      1、通过内部状态和外部状态来区分共享部分和私有部分
     * 其中内部状态的对象直接共享的（相同部分），而外部状态则是各个对象私有的（不同部分）
     *      2、通过享元工厂来管理和创建相似的对象，避免过多创建相似对象而造成内存占用
     * 适用场景：存在大量相似对象创建的场景、内部属性稳定
     * </p>
     * @author ao.chen02@hand-china.com 2025/1/24 11:34
     */
    private static void flyweightPatternExample() {
        String[] colors = {"red", "green", "blue", "yellow"};
        // 生成随机的20个不同坐标和颜色的的对象，其中颜色具有范围
        for (int i = 0; i <20; i++) {
            String color = colors[(int)(Math.random()*colors.length)];
            Shape6 circle = FlyweightFactory.getShape(color);
            circle.draw((int) (Math.random()*100), (int) (Math.random()*100));
        }
    }

    /**
     * <p>
     * 作用：需要创建不同的对象，但是在代码中进行具体的实例化，会造成代码耦合，难以维护，工厂方法就是对于这种耦合情况进行解耦
     * 原理：工厂方法模式提供了一个创建对象的接口，但是将具体对象的创建延迟到子类中进行实现，
     * 这样客户端不需要知道具体的创建类和具体的实现，只需要通过工厂方法就可以获得想要的对象，从而提高了代码的灵活性
     * </p>
     *
     * @author ao.chen02@hand-china.com 2025/1/24 11:36
     */
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
     * 适用场景：两个类或者接口具有相同相同性质，但其本身的具体结构却不相同
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
