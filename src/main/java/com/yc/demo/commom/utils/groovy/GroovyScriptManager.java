package com.yc.demo.commom.utils.groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.codehaus.groovy.runtime.InvokerHelper;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.function.Function;

/**
 * @author Yanchen
 * @ClassName GroovyScriptManager
 * @Date 2021/7/31 14:47
 * @Description：
 */
class GroovyScriptManager extends AbstractScriptManager {
    private final Function<String, Callable> function = (script) -> {
        return () -> {
            GroovyShell shell = new GroovyShell();
            Script parsedScript = shell.parse(script);
            return parsedScript;
        };
    };

    GroovyScriptManager() {
    }
    @Override
    public <T> T eval(String script, Map<String, Object> context, Class<T> returnType) {
        Binding binding = new Binding(context);
        Object obj = this.checkIfExist(script);
        if (obj != null && !(obj instanceof FutureTask)) {
            Script parsedScript = (Script)obj;
            return returnType.cast(InvokerHelper.createScript(parsedScript.getClass(), binding).run());
        } else {
            Object result = this.compileAndRun(script, obj, (Callable)this.function.apply(script), (res) -> {
                Script parsedScript = (Script)res;
                return InvokerHelper.createScript(parsedScript.getClass(), binding).run();
            });
            return returnType.cast(result);
        }
    }
    @Override
    public void compile(String script) {
        this.compile(script, (Callable)this.function.apply(script));
    }
    @Override
    public boolean evalBoolean(String script, Map<String, Object> context) {
        return (Boolean)this.eval(script, context, Boolean.class);
    }
}
