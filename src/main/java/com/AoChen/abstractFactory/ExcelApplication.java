package com.AoChen.abstractFactory;

/**
 * <p>
 * description xxx
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public class ExcelApplication implements Application {
    @Override
    public void open() {
        System.out.println("Open Excel Application");
    }
}
