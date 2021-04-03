package com.yc.demo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Yanchen
 * @ClassName DataCeshi
 * @Date 2020/11/13 18:01
 * @Description：
 */
@Setter
@Getter
public class DataCeshi {
    @JSONField(deserializeUsing  = DateValueDeserializer.class)
    private Date date;
}
