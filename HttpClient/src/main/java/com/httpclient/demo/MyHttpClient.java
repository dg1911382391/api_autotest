package com.httpclient.demo;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by dg on 2019-04-25.
 */
public class MyHttpClient {

	@Test
	public void test1() throws IOException {

		/**
		 * 用来存放我们的结果
		 */
		String result;
		HttpGet get = new HttpGet("http://www.baidu.com");

		/**
		 * 这是用来执行get方法的
		 */
		DefaultHttpClient client = new DefaultHttpClient();
		CloseableHttpResponse response = client.execute(get);
		result = EntityUtils.toString(response.getEntity(), "utf-8");
		System.out.println(result);
	}


}
