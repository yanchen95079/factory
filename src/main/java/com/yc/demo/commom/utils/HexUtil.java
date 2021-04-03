package com.yc.demo.commom.utils;

/**
 * 16进制数据转换工具
 *
 * @author sunchongyang
 * @version 1.0
 * @date 2018/7/7 17:13
 */
public class HexUtil
{
    private static final String HEX_CHARS = "0123456789abcdef";

    /**
     * Converts a byte array to hex string.
     *
     * @param data -
     *            the input byte array
     * @return hex string representation of b.
     */
    public static String toHexString(byte[] data)
    {
        StringBuilder sb = new StringBuilder();
        for (byte b: data)
        {
            sb.append(HexUtil.HEX_CHARS.charAt(b >>> 4 & 0x0F));
            sb.append(HexUtil.HEX_CHARS.charAt(b & 0x0F));
        }
        return sb.toString();
    }

    /**
     * Converts a hex string into a byte array.
     *
     * @param s -
     *            string to be converted
     * @return byte array converted from s
     */
    public static byte[] toByteArray(String s)
    {
        byte[] buf = new byte[s.length() / 2];
        int j = 0;
        for (int i=0; i<buf.length; i++)
        {
            buf[i] = (byte) ((Character.digit(s.charAt(j++), 16) << 4)
                    | Character.digit(s.charAt(j++), 16));
        }
        return buf;
    }

}
