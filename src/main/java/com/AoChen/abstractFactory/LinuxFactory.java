package com.AoChen.abstractFactory;

/**
 * <p>
 * description xxx
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public class LinuxFactory implements SoftwareFactory{
    @Override
    public OperatingSystem createOperatingSystem() {
        return new LinuxOS();
    }

    @Override
    public Application createApplication() {
        return new WordApplication();
    }
}
