package com.yc.demo.commom;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @author Yanchen
 * @ClassName HSResult
 * @Date 2020/7/8 10:27
 * @Description：
 */
public class HSResult {
    // 定义jackson对象1111
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static HSResult build(Integer status, String msg, Object data)
    {
        return new HSResult(status, msg, data);
    }

    public static HSResult ok(Object data)
    {
        return new HSResult(data);
    }

    public static HSResult ok()
    {
        return new HSResult(null);
    }

    public HSResult()
    {
    }

    public static HSResult build(Integer status, String msg)
    {
        return new HSResult(status, msg, null);
    }

    public HSResult(Integer status, String msg, Object data)
    {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public HSResult(Object data)
    {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    /**
     * 将json结果集转化为HsResult对象
     *
     * @param jsonData json数据
     * @param clazz HsResult中的object类型
     * @return
     */
    public static HSResult formatToPojo(String jsonData, Class<?> clazz)
    {
        try
        {
            if (clazz == null)
            {
                return MAPPER.readValue(jsonData, HSResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null)
            {
                if (data.isObject())
                {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                }
                else if (data.isTextual())
                {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    /**
     * 没有object对象的转化
     *
     * @param json
     * @return
     */
    public static HSResult format(String json)
    {
        try
        {
            return MAPPER.readValue(json, HSResult.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     *
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static HSResult formatToList(String jsonData, Class<?> clazz)
    {
        try
        {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0)
            {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        }
        catch (Exception e)
        {
            return null;
        }
    }

}
