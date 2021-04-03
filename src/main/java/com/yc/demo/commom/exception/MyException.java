package com.yc.demo.commom.exception;

/**
 * @author 闫晨
 * @Description
 * @date 2017/9/26 14:22
 * @
 */
public class MyException extends RuntimeException
{

    public MyException(int code, String msg)
    {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }
}
