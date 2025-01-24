package com.AoChen.strategy;

/**
 * <p>
 * description xxx
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public class Subtraction implements MathOperation {

    @Override
    public int operation(int a, int b) {
        return a-b;
    }
}
