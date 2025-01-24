package com.AoChen.visitor;

/**
 * <p>
 * description xxx
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public interface ShapeVisitor {
    void accept(Circle5 visitor);
    void accept(Rectangle5 visitor);
}
