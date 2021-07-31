package com.yc.demo.commom.utils.groovy;

import org.xerial.snappy.Snappy;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.function.Function;

/**
 * @author Yanchen
 * @ClassName AbstractScriptManager
 * @Date 2021/7/31 14:40
 * @Description：
 */
abstract class AbstractScriptManager implements ScriptManager {
    private Map<ByteBuffer, Object> compiledExpressions = new ConcurrentHashMap();

    AbstractScriptManager() {
    }

    protected Object compileAndRun(String script, Object obj, Callable callable, Function strategy) {
        boolean created = false;
        ByteBuffer byteBuffer = this.compressScript(script);
        FutureTask task;
        Object prevTask;
        if (obj != null && obj instanceof FutureTask) {
            task = (FutureTask)obj;
            created = true;
        } else {
            task = new FutureTask(callable);
            prevTask = this.compiledExpressions.putIfAbsent(byteBuffer, task);
            if (prevTask == null) {
                task.run();
                created = true;
            } else {
                if (!(prevTask instanceof FutureTask)) {
                    return strategy.apply(prevTask);
                }

                task = (FutureTask)prevTask;
            }
        }

        try {
            Object taskResult = task.get();
            prevTask = strategy.apply(taskResult);
            if (created) {
                this.compiledExpressions.put(byteBuffer, taskResult);
            }

            return prevTask;
        } catch (InterruptedException var11) {
            throw new IllegalStateException("Interrupted while loading script item: ", var11);
        } catch (ExecutionException var12) {
            Throwable cause = var12.getCause();
            if (cause instanceof RuntimeException) {
                throw (RuntimeException)cause;
            } else {
                throw new IllegalStateException("Unable to load script item: ", cause);
            }
        }
    }

    protected void compile(String script, Callable callable) {
        ByteBuffer byteBuffer = this.compressScript(script);
        if (!this.compiledExpressions.containsKey(byteBuffer)) {
            FutureTask task = new FutureTask(callable);
            Object preTask = this.compiledExpressions.putIfAbsent(byteBuffer, task);
            if (preTask == null) {
                task.run();
            }
        }

    }

    private ByteBuffer compressScript(String script) {
        try {
            byte[] compress = Snappy.compress(script, Charset.forName("UTF-8"));
            ByteBuffer byteBuffer = ByteBuffer.wrap(compress);
            return byteBuffer;
        } catch (IOException var4) {
            throw new RuntimeException("compress script error: ", var4);
        }
    }

    protected Object checkIfExist(String script) {
        return this.compiledExpressions.get(this.compressScript(script));
    }
}
