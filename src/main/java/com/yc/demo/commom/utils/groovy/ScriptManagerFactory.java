package com.yc.demo.commom.utils.groovy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yanchen
 * @ClassName ScriptManagerFactory
 * @Date 2021/7/31 14:46
 * @Description：
 */
public class ScriptManagerFactory {
    private static final Map<Class<? extends ScriptManager>, ScriptManager> SCRIPT_CACHE = new HashMap();

    private ScriptManagerFactory() {
    }

    public static ScriptManager create(Script script) {
        Class<? extends ScriptManager> scriptManagerClass = script.scriptClass;
        ScriptManager scriptManager = (ScriptManager)SCRIPT_CACHE.get(scriptManagerClass);
        if (scriptManager == null) {
            Map var3 = SCRIPT_CACHE;
            synchronized(SCRIPT_CACHE) {
                if ((scriptManager = (ScriptManager)SCRIPT_CACHE.get(scriptManagerClass)) == null) {
                    try {
                        scriptManager = (ScriptManager)scriptManagerClass.newInstance();
                        SCRIPT_CACHE.put(scriptManagerClass, scriptManager);
                    } catch (Exception var6) {
                        return null;
                    }
                }
            }
        }

        return scriptManager;
    }

    public static enum Script {
        GROOVY(GroovyScriptManager.class);

        private Class<? extends ScriptManager> scriptClass;

        private Script(Class<? extends ScriptManager> scriptClass) {
            this.scriptClass = scriptClass;
        }
    }
}