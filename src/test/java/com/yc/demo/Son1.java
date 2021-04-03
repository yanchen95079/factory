package com.yc.demo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yanchen
 * @ClassName Son1
 * @Date 2020/12/10 17:09
 * @Description：
 */
@Data
public class Son1 extends Fater {
    private Integer age;
    private List<String> str;
}
