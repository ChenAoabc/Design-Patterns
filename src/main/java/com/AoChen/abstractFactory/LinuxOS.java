package com.AoChen.abstractFactory;

/**
 * <p>
 * description 具体产品：Linux操作系统
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public class LinuxOS implements OperatingSystem{
    @Override
    public void run() {
        System.out.println("Running Linux OS");
    }
}
