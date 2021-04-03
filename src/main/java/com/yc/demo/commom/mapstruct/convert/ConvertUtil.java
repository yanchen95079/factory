package com.yc.demo.commom.mapstruct.convert;

import org.springframework.stereotype.Component;

/**
 * @author Yanchen
 * @ClassName ConvertUtil
 * @Date 2019/8/12 16:23
 * @Description：
 */
@Component
public class ConvertUtil {
    public int booleanToString(boolean value){
        if(value){
            return 1;
        }
        return 0;
    }

    public boolean strToBoolean(int str){
        if (str==1) {
            return true;
        }
        return false;
    }

}
