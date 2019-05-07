package com.jadendong.tianyiiot;

import com.jadendong.tianyiiot.auto.IotProperties;

/**
 * @author jaden
 */
public class Hello {

    private IotProperties iotProperties;

    public Hello(IotProperties iotProperties) {
        this.iotProperties = iotProperties;
    }

    public Hello() {
    }

    public void info() {
        System.out.println("platformIp: " + iotProperties.getPlatformIp());
        System.out.println("platformPort: " + iotProperties.getPlatformPort());
        System.out.println("appId: " + iotProperties.getAppId());
        System.out.println("secret: " + iotProperties.getSecret());
    }
}
