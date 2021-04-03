package com.yc.demo;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.DateCodec;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.support.spring.annotation.FastJsonFilter;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * @author Yanchen
 * @ClassName ModelValueSerializer
 * @Date 2020/11/13 18:36
 * @Description：
 */

public class DateValueDeserializer extends DateCodec {
    @Override
    public <T> T cast(DefaultJSONParser parser, Type clazz, Object fieldName, Object val) {
        if("java.util.Date".equals(clazz.getTypeName()) && "0".equals(String.valueOf(val))){
            val=null;
        }

        return super.cast(parser,clazz,fieldName,val);
    }

}
