package com.jadendong.tianyiiot.template;

import com.iotplatform.client.NorthApiClient;
import com.iotplatform.client.NorthApiException;
import com.iotplatform.client.dto.AuthOutDTO;
import com.iotplatform.client.dto.CommandDTOV4;
import com.iotplatform.client.dto.PostDeviceCommandInDTO2;
import com.iotplatform.client.dto.PostDeviceCommandOutDTO2;
import com.iotplatform.client.invokeapi.Authentication;
import com.iotplatform.client.invokeapi.SignalDelivery;
import com.jadendong.tianyiiot.params.PostDeviceCommandParams;
import com.jadendong.tianyiiot.util.AuthUtil;
import com.jadendong.tianyiiot.auto.IotProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * 3.7.1 创建设备命令
 * 设备Profile文件中定义了物联网平台可向设备下发的命令，第三方应用可调用此接口向设备下发命令，配置或修改设备的服务属性，以实现对设备的控制。
 *
 * @author : jaden dong
 * @date : 2019/5/7 0007
 */
public class PostDeviceCommandTemplate {

    private IotProperties iotProperties;

    public PostDeviceCommandTemplate() {
    }

    public PostDeviceCommandTemplate(IotProperties iotProperties) {
        this.iotProperties = iotProperties;
    }

    public PostDeviceCommandOutDTO2 post(PostDeviceCommandParams params) throws NorthApiException {
        PostDeviceCommandInDTO2 pdcInDTO = new PostDeviceCommandInDTO2();
        pdcInDTO.setDeviceId(params.getDeviceId() != null ? params.getDeviceId() : iotProperties.getDefaultDeviceId());

        CommandDTOV4 cmd = new CommandDTOV4();
        cmd.setServiceId(params.getServiceId() != null ? params.getServiceId() : iotProperties.getDefaultServiceId());
        cmd.setMethod(params.getMethod() != null ? params.getMethod() : iotProperties.getDefaultMethod());
        cmd.setParas(params.getCmdParas());

        pdcInDTO.setCommand(cmd);

        return post(pdcInDTO);
    }

    /**
     * 3.7.1 创建设备命令
     * 自动获取 token
     * 向本应用的设备下发命令
     *
     * @param postDeviceCommandInDTO2 postDeviceCommandInDTO2
     * @return PostDeviceCommandOutDTO2 PostDeviceCommandOutDTO2
     * @throws NorthApiException NorthApiException
     */
    private PostDeviceCommandOutDTO2 post(PostDeviceCommandInDTO2 postDeviceCommandInDTO2) throws NorthApiException {
        return post(postDeviceCommandInDTO2, null);
    }

    /**
     * 3.7.1 创建设备命令
     * 自动获取 token
     * 向设备下发命令
     *
     * @param postDeviceCommandInDTO2 postDeviceCommandInDTO2
     * @param appId                   appId
     * @return PostDeviceCommandOutDTO2 PostDeviceCommandOutDTO2
     * @throws NorthApiException NorthApiException
     */
    private PostDeviceCommandOutDTO2 post(PostDeviceCommandInDTO2 postDeviceCommandInDTO2, String appId) throws NorthApiException {

        // 1. initialize northApiClient

        NorthApiClient northApiClient = AuthUtil.initApiClient(iotProperties);
        SignalDelivery signalDelivery = new SignalDelivery(northApiClient);

        // 2 . get accessToken at first
        Authentication authentication = new Authentication(northApiClient);
        AuthOutDTO authOutDTO = authentication.getAuthToken();
        String accessToken = authOutDTO.getAccessToken();

        // 3.
        try {
            return signalDelivery.postDeviceCommand(postDeviceCommandInDTO2, appId, accessToken);
        } catch (NorthApiException e) {
            System.out.println(e.toString());
        }
        return null;
    }
}
