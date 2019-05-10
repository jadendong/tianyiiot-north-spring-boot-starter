package com.jadendong.tianyiiot.template;

import com.iotplatform.client.NorthApiClient;
import com.iotplatform.client.NorthApiException;
import com.iotplatform.client.dto.AuthOutDTO;
import com.iotplatform.client.dto.QuerySingleDeviceInfoOutDTO;
import com.iotplatform.client.invokeapi.Authentication;
import com.iotplatform.client.invokeapi.DataCollection;
import com.jadendong.tianyiiot.auto.IotProperties;
import com.jadendong.tianyiiot.util.AuthUtil;

/**
 * 查询单个设备信息
 *
 * @author : jaden dong
 * @date : 2019/5/10 0010
 */
public class QuerySingleDeviceInfoTemplate {

    private IotProperties iotProperties;

    public QuerySingleDeviceInfoTemplate() {
    }

    public QuerySingleDeviceInfoTemplate(IotProperties iotProperties) {
        this.iotProperties = iotProperties;
    }

    /**
     * @param deviceId 设备ID，用于唯一标识一个设备，在注册设备时由物联网平台分配获得。
     * @param select (可选) 指定查询条件，可选值：imsi。
     * @return QuerySingleDeviceInfoOutDTO QuerySingleDeviceInfoOutDTO
     * @throws NorthApiException NorthApiException
     */
    public QuerySingleDeviceInfoOutDTO query(String deviceId, String select) throws NorthApiException {
        NorthApiClient northApiClient = AuthUtil.initApiClient(iotProperties);
        DataCollection dataCollection = new DataCollection(northApiClient);

        Authentication authentication = new Authentication(northApiClient);
        AuthOutDTO authOutDTO = authentication.getAuthToken();
        String accessToken = authOutDTO.getAccessToken();

        return dataCollection.querySingleDeviceInfo(deviceId, select, iotProperties.getAppId(), accessToken);
    }
}
