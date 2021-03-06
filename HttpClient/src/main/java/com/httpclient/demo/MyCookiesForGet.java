package com.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by dg on 2019-04-25.
 */
public class MyCookiesForGet {

	private String url;
	private ResourceBundle bundle;
	/**
	 * 用来存储cookies信息的变量
	 */
	CookieStore clientCookieStore;

	@BeforeTest
	public void beforeTest() {
		bundle = ResourceBundle.getBundle("application", Locale.CANADA);
		url = bundle.getString("test.url");

	}

	/**
	 * 获取cookies信息
	 * @throws IOException
	 */
	@Test
	public void testGetCookies() throws IOException {
		String result;
		/**
		 * 从配置文件中拼接测试的URL
		 */
		String uri = bundle.getString("getCookies.uri");
		String testUrl = this.url + uri;

		/**
		 * 测试逻辑代码
		 */
		HttpGet get = new HttpGet(testUrl);
		DefaultHttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(get);

		result = EntityUtils.toString(response.getEntity(), "utf-8");
		System.out.println(result);

		/**
		 * 获取Cookies信息
		 */
		this.clientCookieStore = client.getCookieStore();
		List<Cookie> cookieList = clientCookieStore.getCookies();
		for (Cookie cookie : cookieList) {
			String cookieName = cookie.getName();
			String cookieValue = cookie.getValue();
			System.out.println("cookieName=" + cookieName + "；cookieValue=" + cookieValue);
		}

	}

	/**
	 * 携带Cookies信息访问get请求
	 */
	@Test(dependsOnMethods = {"testGetCookies"})
	public void testGetWithCookies() throws IOException {
		String result;
		/**
		 * 从配置文件中拼接测试的URL
		 */
		String uri = bundle.getString("test.get.with.cookies");
		String testUrl = this.url + uri;

		/**
		 * 测试逻辑代码
		 */
		HttpGet get = new HttpGet(testUrl);
		DefaultHttpClient client = new DefaultHttpClient();

		/**
		 * 设置Cookies信息
		 */
		client.setCookieStore(this.clientCookieStore);

		HttpResponse response = client.execute(get);
		/**
		 * 获取响应状态码
		 */
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("statusCode=" + statusCode);
		if (statusCode == 200) {
			result = EntityUtils.toString(response.getEntity(), "utf-8");
			System.out.println(result);
		}

	}





}
