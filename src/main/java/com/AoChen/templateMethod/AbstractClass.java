package com.AoChen.templateMethod;

/**
 * <p>
 * description xxx
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public abstract class AbstractClass {
    // 算法的核心骨架-固定算法的执行步骤
    public void templateMethod(){
        step1();
        step2();
        step3();
    }

    // 抽象的具体步骤实现
    abstract void step1();
    abstract void step2();
    abstract void step3();
}
