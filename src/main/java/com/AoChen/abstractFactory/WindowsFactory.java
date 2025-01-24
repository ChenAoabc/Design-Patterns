package com.AoChen.abstractFactory;

import sun.plugin2.os.windows.Windows;

/**
 * <p>
 * description xxx
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public class WindowsFactory implements SoftwareFactory{
    @Override
    public OperatingSystem createOperatingSystem() {
        return new WindowsOS();
    }

    @Override
    public Application createApplication() {
        return new ExcelApplication();
    }
}
