package com.jadendong.tianyiiot.auto;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author jaden
 */
@ConfigurationProperties(prefix = "iot")
public class IotProperties {

    private String platformIp;
    private String platformPort;
    private String appId;
    private String secret;

    private String serviceId;
    private String method;

    public String getPlatformIp() {
        return platformIp;
    }

    public void setPlatformIp(String platformIp) {
        this.platformIp = platformIp;
    }

    public String getPlatformPort() {
        return platformPort;
    }

    public void setPlatformPort(String platformPort) {
        this.platformPort = platformPort;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
