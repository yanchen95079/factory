package com.yc.demo.commom.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 安全工具类
 *
 * @author sunchongyang
 * @version 1.0
 * @date 2018/7/7 17:13
 */
public class CryptoUtil
{
    private static final char[] legalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
            .toCharArray();

    public static String base64Encode(byte[] data)
    {
        int start = 0;
        int len = data.length;
        StringBuilder buf = new StringBuilder(data.length * 3 / 2);

        int end = len - 3;
        int i = start;
        int n = 0;

        while (i <= end)
        {
            int d = ((((int) data[i]) & 0x0ff) << 16) | ((((int) data[i + 1]) & 0x0ff) << 8)
                    | (((int) data[i + 2]) & 0x0ff);

            buf.append(legalChars[(d >> 18) & 63]);
            buf.append(legalChars[(d >> 12) & 63]);
            buf.append(legalChars[(d >> 6) & 63]);
            buf.append(legalChars[d & 63]);

            i += 3;

            if (n++ >= 14)
            {
                n = 0;
                buf.append(" ");
            }
        }

        if (i == start + len - 2)
        {
            int d = ((((int) data[i]) & 0x0ff) << 16) | ((((int) data[i + 1]) & 255) << 8);

            buf.append(legalChars[(d >> 18) & 63]);
            buf.append(legalChars[(d >> 12) & 63]);
            buf.append(legalChars[(d >> 6) & 63]);
            buf.append("=");
        }
        else if (i == start + len - 1)
        {
            int d = (((int) data[i]) & 0x0ff) << 16;

            buf.append(legalChars[(d >> 18) & 63]);
            buf.append(legalChars[(d >> 12) & 63]);
            buf.append("==");
        }

        return buf.toString();
    }

    /**
     * Decodes the given Base64 encoded String to a new byte array. The byte
     * array holding the decoded data is returned.
     */
    public static byte[] base64Decode(String s)
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int i = 0;
        int len = s.length();

        while (true)
        {
            while (i < len && s.charAt(i) <= ' ')
            {
                i++;
            }
            if (i == len)
            {
                break;
            }

            int tri = (char2Base64code(s.charAt(i)) << 18) + (char2Base64code(s.charAt(i + 1)) << 12) + (char2Base64code(s.charAt(i + 2)) << 6)
                    + (char2Base64code(s.charAt(i + 3)));

            bos.write((tri >> 16) & 255);
            if (s.charAt(i + 2) == '=')
            {
                break;
            }
            bos.write((tri >> 8) & 255);
            if (s.charAt(i + 3) == '=')
            {
                break;
            }
            bos.write(tri & 255);
            i += 4;
        }

        byte[] decodedBytes = bos.toByteArray();
        try
        {
            bos.close();
            bos = null;
        }
        catch (IOException ex)
        {
            System.err.println("Error while decoding BASE64: " + ex.toString());
        }

        return decodedBytes;
    }

    /**
     * Calculates the MD5 digest and returns the value as a 16 element
     *
     * @param data Data to digest
     * @return MD5 digest
     */
    public static byte[] md5(String data)
    {
        return md5(data.getBytes());
    }

    /**
     * Calculates the MD5 digest and returns the value as a 16 element
     *
     * @param data Data to digest
     * @param salt 盐值
     * @return MD5 digest
     */
    public static byte[] md5(String data, String salt)
    {
        String plainText = data + "{" + salt + "}";
        return md5(plainText.getBytes());
    }

    /**
     * Calculates the MD5 digest and returns the value as a 16 element
     * <code>byte[]</code>.
     *
     * @param data Data to digest
     * @return MD5 digest
     */
    public static byte[] md5(byte[] data)
    {
        try
        {
            return MessageDigest.getInstance("MD5").digest(data);
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Calculates the MD5 digest and returns the value as a 32 character hex
     * string.
     *
     * @param data Data to digest
     * @return MD5 digest as a hex string
     */
    public static String md5Hex(byte[] data)
    {
        return HexUtil.toHexString(md5(data));
    }

    /**
     * Calculates the MD5 digest and returns the value as a 32 character hex
     * string.
     *
     * @param data Data to digest
     * @return MD5 digest as a hex string
     */
    public static String md5Hex(String data)
    {
        return HexUtil.toHexString(md5(data));
    }

    public static String md5Hex(String data, String charset)
    {
        String md5HexStr = "";

        if (null == charset || "".equals(charset))
        {
            md5HexStr = HexUtil.toHexString(md5(data.getBytes()));
        }
        try
        {
            md5HexStr = HexUtil.toHexString(md5(data.getBytes(charset)));
        }
        catch (UnsupportedEncodingException e)
        {
            md5HexStr = "";
        }

        return md5HexStr;
    }

    /**
     * 返回stringMD5加密内容
     */
    public static String md5SaltHex(String data, String salt)
    {
        return HexUtil.toHexString(md5(data, salt));
    }

    private static int char2Base64code(char c)
    {
        if (c >= 'A' && c <= 'Z')
        {
            return ((int) c) - 65;
        }
        else if (c >= 'a' && c <= 'z')
        {
            return ((int) c) - 97 + 26;
        }
        else if (c >= '0' && c <= '9')
        {
            return ((int) c) - 48 + 26 + 26;
        }
        else
        {
            switch (c)
            {
                case '+':
                    return 62;
                case '/':
                    return 63;
                case '=':
                    return 0;
                default:
                    throw new RuntimeException("unexpected code: " + c);
            }
        }
    }
}
