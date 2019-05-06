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
        System.out.println("Ip: " + iotProperties.getPlatformIp());
        System.out.println("Port: " + iotProperties.getPlatformPort());
        System.out.println("appId: " + iotProperties.getAppId());
        System.out.println("secret: " + iotProperties.getSecret());
    }
}
