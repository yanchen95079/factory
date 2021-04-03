package com.yc.demo.commom.utils;

import java.util.Random;

/**
 * 各种id生成策略
 * <p>
 * Title: IdUtil
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 *
 * @author sunchongyang
 * @version 1.0
 * @date 2017/11/7 17:13
 */
public class IdUtil
{
    private static final char[] baseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
            .toCharArray();
    private static final char[] baseNumbers = "0123456789".toCharArray();
    /**
     * 各种随机名称生成
     */
    public static String genTagName()
    {
        // 取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        // 加上三位随机数
        Random random = new Random();
        int end3 = random.nextInt(999);
        // 如果不足三位前面补0
        String str = millis + String.format("%03d", end3);

        return str;
    }

    /**
     * 各种高精度随机名称生成
     */
    public static String genHighTagName()
    {
        // 取当前时间的长整形值包含毫秒
         long nano = System.nanoTime();
        // 加上三位随机数
        Random random = new Random();
        int end3 = random.nextInt(999);
        // 如果不足三位前面补0
        String str = nano + String.format("%03d", end3);

        return str;
    }

    /**
     * 生成id
     */
    public static long generateId()
    {
        // 取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        // 加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
        // 如果不足两位前面补0
        String str = millis + String.format("%02d", end2);

        return new Long(str);
    }

    /**
     * 生成高精度id
     */
    public static long generateHighId()
    {
        // 取当前时间的长整形值包含纳秒
        long nano = System.nanoTime();
        // 加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
        // 如果不足两位前面补0
        String str = nano + String.format("%02d", end2);

        return new Long(str);
    }

    /**
     * 生成指定长度的字母或数字组合的字符串
     * @param length 生成字符串的长度
     * @return
     */
    public static String getRandomText(int length)
    {
        Random rand = new Random();
        StringBuffer text = new StringBuffer();
        for (int i = 0; i < length; i++)
        {
            text.append(baseChars[rand.nextInt(baseChars.length)]);
        }

        return text.toString();
    }

    /**
     * 生成指定长度的数字随机字符串
     * @param length 生成数字字符串的长度
     * @return
     */
    public static String getRandomNumbers(int length)
    {
        Random rand = new Random();
        StringBuffer numbers = new StringBuffer();
        for (int i = 0; i < length; i++)
        {
            numbers.append(baseNumbers[rand.nextInt(baseNumbers.length)]);
        }

        return numbers.toString();
    }

    public static void main(String[] args)
    {
        System.out.println("generate Ids Begin");
        for (int i = 0; i < 2; i++)
        {
            System.out.println(generateId());
            System.out.println(generateHighId());
        }
        System.out.println(generateId());
        System.out.println("generate Ids End");
    }
}
