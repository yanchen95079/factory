package com.yc.demo.config.convert;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author Yanchen
 * @ClassName BigDecimalToStringSerializer
 * @Date 2019/12/14 18:41
 * @Description：自定义BigDecaimalSerializer
 */
@JacksonStdImpl
public class BigDecimalToStringSerializer extends ToStringSerializer {
    private final static BigDecimalToStringSerializer INSTANCE = new BigDecimalToStringSerializer();
    private BigDecimalToStringSerializer(){
    }
    public static BigDecimalToStringSerializer getInstance(){
        return INSTANCE;
    }
    @Override
    public boolean isEmpty(SerializerProvider prov, Object value) {
        if (value == null) {
            return true;
        }
        String str = ((BigDecimal) value).stripTrailingZeros().toPlainString();
        return str.isEmpty();
    }

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider)
            throws IOException {
        gen.writeString(((BigDecimal) value).stripTrailingZeros().toPlainString());
    }

    @Override
    public void serializeWithType(Object value, JsonGenerator gen,
                                  SerializerProvider provider, TypeSerializer typeSer)
            throws IOException {
        serialize(value, gen, provider);
    }
}


