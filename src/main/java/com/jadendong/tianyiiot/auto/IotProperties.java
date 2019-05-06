package com.jadendong.tianyiiot.auto;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author jaden
 */
@ConfigurationProperties(prefix = "north")
public class IotProperties {

    private String platformIp;
    private String platformPort;
    private String appId;
    private String secret;

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
}
