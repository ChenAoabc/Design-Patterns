package com.AoChen.abstractFactory;

/**
 * <p>
 * description 具体产品：Windows操作系统
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public class WindowsOS implements OperatingSystem{
    @Override
    public void run() {
        System.out.println("Running Windows OS");
    }
}
