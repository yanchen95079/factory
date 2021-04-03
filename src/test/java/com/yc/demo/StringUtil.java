package com.yc.demo;

import com.alibaba.fastjson.JSON;

/**
 * Created by zhaoQD on 2018/1/10.
 */
public class StringUtil {

    public static String removeNull(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static String strFilter(String str) {
        str = str.replaceAll("<(img|IMG)(.*?)(/>|></img>|>)", "[图片]");
        return delHTMLTag(str);
    }

    public static String delHTMLTag(String htmlStr){
        return  htmlStr.replaceAll("</?[^>]+>", "");
    }

    /**
     * 判断字符串是否是标准的json串
     * @param str
     * @return
     */
    public static boolean isValidJson(String str) {
        if(str==null) {
            return false;
        }
        try {
            JSON.parseObject(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断字符串是否是标准的json数组
     * @param str
     * @return
     */
    public static boolean isValidJsonArray(String str) {
        if(str==null) {
            return false;
        }
        try {
            JSON.parseArray(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
