package com.AoChen.abstractFactory;

/**
 * <p>
 * description xxx
 * </p>
 *
 * @author ao.chen02@hand-china.com
 */
public interface SoftwareFactory {
    OperatingSystem createOperatingSystem();
    Application createApplication();
}
