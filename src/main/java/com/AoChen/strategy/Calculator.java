package com.AoChen.strategy;

/**
 * <p>
 * description xxx
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public class Calculator {
    /**
     * 操作类型
     */
    private MathOperation operation;
    public void setOperation(MathOperation operation){
        this.operation = operation;
    }

    // 执行操作
    public int performOperation(int a, int b) throws IllegalAccessException {
        if (operation != null){
            return operation.operation(a,b);
        }
        throw new IllegalAccessException("No operation set");
    }
}
