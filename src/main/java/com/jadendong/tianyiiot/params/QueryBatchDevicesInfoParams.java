package com.jadendong.tianyiiot.params;

import lombok.*;

/**
 * @author : jaden dong
 * @date : 2019/5/9 0009
 */

@Data
public class QueryBatchDevicesInfoParams {

    private String appId;

    private String gatewayId;

    private String status;

    private String nodeType;

    private String deviceType;

    private Integer pageNo;

    private Integer pageSize;

    private String startTime;

    private String endTime;

    private String sort;

    private String select;
}
