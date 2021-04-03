package com.yc.demo;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil
{
	private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
	public static String doGet(String url, Map<String, String> param)
	{
		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String resultString = "";
		CloseableHttpResponse response = null;

		try
		{
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			if (param != null)
			{
				for (String key : param.keySet())
				{
					builder.addParameter(key, param.get(key));
				}
			}
			URI uri = builder.build();

			// 创建http GET请求
			HttpGet httpGet = new HttpGet(uri);

			// 执行请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200)
			{
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (response != null)
				{
					response.close();
				}
				httpclient.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		return resultString;
	}

	public static String doGet(String url)
	{
		return doGet(url, null);
	}

	public static String doPost(String url, Map<String, String> param)
	{
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";

		try
		{
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建参数列表
			if (param != null)
			{
				List<NameValuePair> paramList = new ArrayList<>();
				for (String key : param.keySet())
				{
					paramList.add(new BasicNameValuePair(key, param.get(key)));
				}
				// 模拟表单
//				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, "UTF-8");
				httpPost.setEntity(entity);
			}
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				response.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		return resultString;
	}

	public static String doPost(String url)
	{
		return doPost(url, null);
	}

	public static String doPostJson(String url, String json)
	{
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";

		try
		{
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建请求内容
			StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
			httpPost.setEntity(entity);
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				response.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		return resultString;
	}
	
	public static StringBuffer httpsRequest(String requestUrl, String requestMethod, String output) throws IOException
	{
		URL url = new URL(requestUrl);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setUseCaches(false);
		connection.setRequestMethod(requestMethod);
		if (null != output)
		{
			OutputStream outputStream = connection.getOutputStream();
			outputStream.write(output.getBytes("UTF-8"));
			outputStream.close();
		}

		// 从输入流读取返回内容
		InputStream inputStream = connection.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String str;
		StringBuffer buffer = new StringBuffer();

		while ((str = bufferedReader.readLine()) != null)
		{
			buffer.append(str);
		}
		bufferedReader.close();
		inputStreamReader.close();
		inputStream.close();
		connection.disconnect();

		return buffer;
	}

	public static Object doPostJson(String url, Object json,String authorization)
	{
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = null;

		try
		{
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);

			// 创建请求内容
			StringEntity entity = new StringEntity(JsonUtil.objectToJson(json), ContentType.APPLICATION_JSON);
			entity.setContentType("application/json");
			httpPost.setEntity(entity);
			httpPost.setHeader("Cookie","lianjia_uuid=cbe458c2-6316-4608-811f-226bbbe76940; crosSdkDT2019DeviceId=qaq3xn-i2fmyy-f7bflcqts9trel1-p7ld0zg06; SESSIONID=e63324c9-f5ce-433f-a469-0d8c40486cf9; security_ticket=k4obGxmbAys8YOTNOYPirQEsb5XmtqgufBB72HoXkFoAPHZIkN6ExrlD8b6VqkeD1YmZcDDixc4i6bXJw9l0sCf1giuweGQwJO5c9cxl17ifGADJMcXtIvq6ibNlQEwEL3vRpRWZyLUC9ainJ8UXfSllN1DtPHoELe7r5moVNDY=; login_ucid=1000000026710744; security_ticket_test=NQMtMatTHzTzsPWbvdNmf3SkASc3XQ65l/rvu5avYy6/BSlBn84l5Y2QwEQioubReno3xnimJIgFypjyZs5ohesoJAcJmIo5Z9LCGczv1iEBKZNai+bmRcme1YMyAQm5WEn8bpkhkaevh82/6szMHbJDXBsAAVTYxBkYsLKADHk=; lianjia_ssid=2db1d779-a188-4f47-b91a-9fed262ed21f");

			response = httpClient.execute(httpPost);
			// 执行http请求
			if (response.getStatusLine().getStatusCode() == 200)
			{
				resultString = EntityUtils.toString(response.getEntity(), "utf-8");
			}else {
				logger.error("执行失败："+String.valueOf(response.getStatusLine().getStatusCode()));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (response != null)
				{
					response.close();
				}
				httpClient.close();
			}
			catch (IOException e)
			{
				logger.error("执行url失败："+e.getMessage());
			}
		}

		return JsonUtil.jsonToObject(resultString);
	}


	public static Object doPutJson(String url, Object json,String authorization)
	{
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = null;

		try
		{
			// 创建Http Post请求
			HttpPut httpPut = new HttpPut(url);
			// 创建请求内容
			StringEntity entity = new StringEntity(JsonUtil.objectToJson(json), ContentType.APPLICATION_JSON);
			entity.setContentType("application/json");
			httpPut.setEntity(entity);
			httpPut.setHeader("Authorization",authorization);
			// 执行http请求
			response = httpClient.execute(httpPut);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200)
			{
				resultString = EntityUtils.toString(response.getEntity(), "utf-8");
			}else {
				logger.error("执行失败："+String.valueOf(response.getStatusLine().getStatusCode()));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (response != null)
				{
					response.close();
				}
				httpClient.close();
			}
			catch (IOException e)
			{
				logger.error("执行url失败："+e.getMessage());
			}
		}

		return JsonUtil.jsonToObject(resultString);
	}
	public static Object doGetJson(String url, Map<String, String> param)
	{
		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String resultString = "";
		CloseableHttpResponse response = null;

		try
		{
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			if (param != null)
			{
				for (String key : param.keySet())
				{
					builder.addParameter(key, param.get(key));
				}
			}
			URI uri = builder.build();

			// 创建http GET请求
			HttpGet httpGet = new HttpGet(uri);

			// 执行请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200)
			{
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
			}else {
				logger.error("执行失败："+String.valueOf(response.getStatusLine().getStatusCode()));
			}
		}
		catch (Exception e)
		{
			logger.error("执行url失败："+e.getMessage());
		}
		finally
		{
			try
			{
				if (response != null)
				{
					response.close();
				}
				httpclient.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		return JsonUtil.jsonToObject(resultString);
	}

}
