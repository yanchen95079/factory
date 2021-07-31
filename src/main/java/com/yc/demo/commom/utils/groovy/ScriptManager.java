package com.yc.demo.commom.utils.groovy;

import java.util.Map;

/**
 * @author Yanchen
 * @ClassName ScriptManager
 * @Date 2021/7/31 14:44
 * @Description：
 */
public interface ScriptManager {
    <T> T eval(String var1, Map<String, Object> var2, Class<T> var3);

    boolean evalBoolean(String var1, Map<String, Object> var2);

    void compile(String var1);
}
