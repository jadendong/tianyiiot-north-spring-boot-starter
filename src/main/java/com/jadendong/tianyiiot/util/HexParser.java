package com.jadendong.tianyiiot.util;

/**
 * @author : jaden dong
 * @date : 2019/5/5 0005
 */
public class HexParser {

    public static String parseByte2HexStr(byte[] buf) {
        if (null == buf) {
            return null;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    public static byte[] parseHexStr2Byte(String hexStr) {

        try {
            hexStr = hexStr.replaceAll(" ", "");
            if (hexStr.length() < 1) {
                return null;
            }
            if (hexStr.length() % 2 != 0) {
                hexStr = "0" + hexStr;
            }
            byte[] result = new byte[hexStr.length() / 2];
            for (int i = 0; i < hexStr.length() / 2; i++) {
                int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
                int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
                result[i] = (byte) (high * 16 + low);
            }
            return result;
        } catch (Exception e) {
            return null;
        }

    }
}
