package com.yc.demo.commom.utils.groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Yanchen
 * @ClassName GroovyUtil
 * @Date 2021/7/31 14:48
 * @Description：
 */
public class GroovyUtil {
    private static ScriptManager scriptManager = ScriptManagerFactory.create(ScriptManagerFactory.Script.GROOVY);

    public static boolean evalBoolean(String script, Map<String, Object> context) {
        try {
            return scriptManager.evalBoolean(script, context);
        }catch (Exception e){
            return false;
        }
    }

    public static <T> T eval(String script, Map<String, Object> context, Class<T> clazz) {
        try {
          return scriptManager.eval(script, context, clazz);
        }catch (Exception e){
            return null;
        }
    }


    public static Object evalMine(Object obj,String script){
        Binding binding = new Binding();
        binding.setVariable("result",obj);
        GroovyShell shell = new GroovyShell(binding);
        try {
            return shell.evaluate(script);
        }catch (Exception e){
            return null;
        }
    }
}