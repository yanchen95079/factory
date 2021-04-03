package com.yc.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * Json 转换工具
 * <p>
 * Title: IdUtil
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 *
 * @author sunchongyang
 * @date 2017/11/7 17:13
 * @version 1.0
 */
public class JsonUtil
{
	// 定义jackson对象
	private static final ObjectMapper MAPPER = new ObjectMapper();

	/**
	 * 将对象转换成json字符串。
	 *
	 * @param data
	 * @return
	 */
	public static String objectToJson(Object data)
	{
		try
		{
			String string = MAPPER.writeValueAsString(data);
			return string;
		}
		catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 将json转换成object。
	 *
	 * @param json
	 * @return
	 */
	public static Object jsonToObject(String json)
	{
		try
		{
			Object obj=MAPPER.readValue(json, Object.class);
			return obj;
		}
		catch (Exception e)
		{

		}
		return null;
	}
	/**
	 * 将json结果集转化为对象
	 * 
	 * @param jsonData  json数据
	 * @param beanType 对象中的object类型
	 * @return
	 */
	public static <T> T jsonToPojo(String jsonData, Class<T> beanType)
	{
		try
		{
			T t = MAPPER.readValue(jsonData, beanType);
			return t;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将json数据转换成pojo对象list
	 *
	 * @param jsonData
	 * @param beanType
	 * @return
	 */
	public static <T> List<T> jsonToList(String jsonData, Class<T> beanType)
	{
		JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
		try
		{
			List<T> list = MAPPER.readValue(jsonData, javaType);
			return list;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

}
