package com.yc.demo.commom;



import com.yc.demo.commom.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by DELL on 2017/9/13.
 */
@ControllerAdvice
public class GlobalExceptionHandler
{
    private Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 拦截捕捉自定义异常 MyException.class
     *
     * @param ex
     * @return
     */

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public HSResult myErrorHandler(MyException ex) throws Exception
    {

        logger.warn("自定义异常："+ex.getMsg());
        return HSResult.build(ex.getCode(), ex.getMsg());

    }
}
