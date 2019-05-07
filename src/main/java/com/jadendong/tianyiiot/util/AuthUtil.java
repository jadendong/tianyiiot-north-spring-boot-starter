package com.jadendong.tianyiiot.util;

import com.iotplatform.client.NorthApiClient;
import com.iotplatform.client.NorthApiException;
import com.iotplatform.client.dto.ClientInfo;
import com.jadendong.tianyiiot.auto.IotProperties;

import java.util.Objects;

/**
 * @author : jaden dong
 * @date : 2019/5/7 0007
 */
public class AuthUtil {

    private static NorthApiClient northApiClient = null;

    public static NorthApiClient initApiClient(IotProperties iotProperties) {
        if (northApiClient != null) {
            return northApiClient;
        }
        northApiClient = new NorthApiClient();

        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setPlatformIp(iotProperties.getPlatformIp());
        clientInfo.setPlatformPort(iotProperties.getPlatformPort());
        clientInfo.setAppId(iotProperties.getAppId());
        clientInfo.setSecret(iotProperties.getSecret());
//        clientInfo.setSecret(getAesSecret(iotProperties.getSecret()));

        try {
            northApiClient.setClientInfo(clientInfo);
            northApiClient.initSSLConfig();
        } catch (NorthApiException e) {
            System.out.println(e.toString());
        }

        return northApiClient;
    }

    public static String getAesSecret(String secretValue) {
        //this is a test AES password
        String aesPwd = "123987";

//      String originalProperty = "gPnTWO52yrobtjyobykkf12P8f4a";
//      byte[] temp = AesUtil.encrypt(originalProperty, aesPwd);
//      String hexStrResult = HexParser.parseByte2HexStr(temp);
//      System.out.println("encrypted secret hex sting is ："  + hexStrResult);

        byte[] secret = HexParser.parseHexStr2Byte(secretValue);
        return new String(Objects.requireNonNull(AesUtil.decrypt(secret, aesPwd)));
    }
}
