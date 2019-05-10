package com.jadendong.tianyiiot.template;

import com.iotplatform.client.NorthApiClient;
import com.iotplatform.client.NorthApiException;
import com.iotplatform.client.dto.*;
import com.iotplatform.client.invokeapi.Authentication;
import com.iotplatform.client.invokeapi.DataCollection;
import com.jadendong.tianyiiot.auto.IotProperties;
import com.jadendong.tianyiiot.params.QueryBatchDevicesInfoParams;
import com.jadendong.tianyiiot.util.AuthUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 已在物联网平台注册的设备，第三方应用若需要根据条件查看多个设备的详细信息（如厂商、型号、版本、状态和服务属性等信息），可调用此接口在物联网平台查询获取。
 * 支持第三方应用在物联网平台根据条件查询多个设备的详细信息，包括配置信息、状态信息、服务属性信息等。
 *
 * @author : jaden dong
 * @date : 2019/5/9 0009
 */
public class QueryBatchDevicesInfoTemplate {

    private IotProperties iotProperties;

    public QueryBatchDevicesInfoTemplate() {
    }

    public QueryBatchDevicesInfoTemplate(IotProperties iotProperties) {
        this.iotProperties = iotProperties;
    }

    /**
     * 批量查询设备信息列表
     *
     * @param queryBatchDevicesInfoInDTO queryBatchDevicesInfoInDTO
     * @return QueryBatchDevicesInfoOutDTO
     * @throws NorthApiException NorthApiException
     */
    private QueryBatchDevicesInfoOutDTO query(QueryBatchDevicesInfoInDTO queryBatchDevicesInfoInDTO) throws NorthApiException {

        NorthApiClient northApiClient = AuthUtil.initApiClient(iotProperties);
        DataCollection dataCollection = new DataCollection(northApiClient);

        Authentication authentication = new Authentication(northApiClient);
        AuthOutDTO authOutDTO = authentication.getAuthToken();
        String accessToken = authOutDTO.getAccessToken();

        return dataCollection.queryBatchDevicesInfo(queryBatchDevicesInfoInDTO, accessToken);
    }

    /**
     * 批量查询设备信息列表
     *
     * @param params params
     * @return QueryBatchDevicesInfoOutDTO QueryBatchDevicesInfoOutDTO
     * @throws NorthApiException NorthApiException
     */
    public QueryBatchDevicesInfoOutDTO query(QueryBatchDevicesInfoParams params) throws NorthApiException {
        QueryBatchDevicesInfoInDTO queryDTO = new QueryBatchDevicesInfoInDTO();
        queryDTO.setAppId(params.getAppId() != null ? params.getAppId() : iotProperties.getAppId());
        queryDTO.setGatewayId(params.getGatewayId());
        queryDTO.setNodeType(params.getNodeType());
        queryDTO.setDeviceType(params.getDeviceType());
        queryDTO.setPageNo(params.getPageNo());
        queryDTO.setPageSize(params.getPageSize());
        queryDTO.setStatus(params.getStatus());
        queryDTO.setStartTime(params.getStartTime());
        queryDTO.setEndTime(params.getEndTime());
        queryDTO.setSort(params.getSort());
        queryDTO.setSelect(params.getSelect());

        return query(queryDTO);
    }
}