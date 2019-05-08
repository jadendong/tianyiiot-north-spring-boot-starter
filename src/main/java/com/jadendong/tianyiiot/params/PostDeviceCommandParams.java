package com.jadendong.tianyiiot.params;

import lombok.*;

import java.util.Map;

/**
 * @author jaden
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDeviceCommandParams {

    private String deviceId;

    private String serviceId;

    private String method;

    private Map<String, Object> cmdParas;

    public PostDeviceCommandParams(String deviceId) {
        this.deviceId = deviceId;
    }

    public PostDeviceCommandParams(String deviceId, Map<String, Object> cmdParas) {
        this.deviceId = deviceId;
        this.cmdParas = cmdParas;
    }
}
