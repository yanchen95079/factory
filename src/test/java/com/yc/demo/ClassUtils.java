package com.yc.demo;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Yanchen
 * @ClassName ClassUtils
 * @Date 2021/2/1 12:22
 * @Description：
 */
public class ClassUtils {
    /**
     * 根据属性，获取get方法
     *
     * @param ob   对象
     * @param name 属性名
     * @return
     * @throws Exception
     */
    public static Object getGetMethod(Object ob, String name) throws Exception {

        BeanInfo beanInfo = Introspector.getBeanInfo(ob.getClass());
        for (PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {
            Method readMethod = descriptor.getReadMethod();
            if(descriptor.getName().equals(name)){
                try {
                    Object o = readMethod.invoke(ob);
                    return o;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    return null;
                }
            }
        }
        return null;
    }

    /**
     * 根据属性，set方法
     *
     * @param ob   对象
     * @param name 属性名
     * @return
     * @throws Exception
     */
    public static Object setMethod(Object ob, String name,Object value) throws Exception {

        BeanInfo beanInfo = Introspector.getBeanInfo(ob.getClass());
        for (PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {
            Method writeMethod = descriptor.getReadMethod();
            if(descriptor.getName().equals(name)){
                try {
                    writeMethod.setAccessible(true);
                    Object o=writeMethod.invoke(ob,value);
                    return o;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    return null;
                }
            }
        }
        return null;
    }

}
