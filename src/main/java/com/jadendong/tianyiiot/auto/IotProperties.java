package com.jadendong.tianyiiot.auto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author jaden
 */
@ConfigurationProperties(prefix = "iot")
@Getter
@Setter
public class IotProperties {

    /**
     * 接入IP (必选)
     */
    private String platformIp;
    /**
     * 接入端口 (必选)
     */
    private String platformPort;
    /**
     * 应用ID (必选)
     */
    private String appId;
    /**
     * 应用密钥 (必选)
     */
    private String secret;

    /**
     * 默认的 deviceId (可选)
     */
    private String defaultDeviceId;

    /**
     * 默认的 serviceId (可选)
     */
    private String defaultServiceId;

    /**
     * 默认的 Method (可选)
     */
    private String defaultMethod;
}
