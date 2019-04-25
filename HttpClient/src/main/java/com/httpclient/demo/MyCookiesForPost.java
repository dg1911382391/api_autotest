package com.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.jsoup.helper.StringUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by dg on 2019-04-25.
 */
public class MyCookiesForPost {

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
	 * 携带Cookies信息访问post请求
	 */
	@Test(dependsOnMethods = {"testGetCookies"})
	public void testPostWithCookies() throws IOException {
		/**
		 * 声明一个对象进行响应结果的存储
		 */
		String result;

		/**
		 * 从配置文件中拼接测试的URL
		 */
		String uri = bundle.getString("test.post.with.cookies");
		String testUrl = this.url + uri;

		/**
		 * 声明一个DefaultHttpClient对象，用来进行方法的执行。
		 */
		DefaultHttpClient client = new DefaultHttpClient();

		/**
		 * 声明一个post方法
		 */
		HttpPost post = new HttpPost(testUrl);

		/**
		 * 添加参数
		 */
		JSONObject param = new JSONObject();
		param.put("name", "zhangsan");
		param.put("age", "18");

		/**
		 * 设置Headers请求头信息
		 */
		post.setHeader("content-type", "application/json");

		/**
		 * 将参数添加到方法中
		 */
		StringEntity entity = new StringEntity(param.toString(), "utf-8");
		post.setEntity(entity);

		/**
		 * 设置Cookies信息
		 */
		client.setCookieStore(this.clientCookieStore);

		/**
		 * 执行post方法
		 */
		HttpResponse response = client.execute(post);

		/**
		 * 获取响应结果
		 */
		result = EntityUtils.toString(response.getEntity(), "utf-8");
		System.out.println(result);

		/**
		 * 处理结果，就是判断响应结果是否符合预期
		 * 1、将返回的响应结果字符串String转化为json对象（最好别用alibaba.fastjson）
		 * 2、获取并判断响应结果的值
		 */
		JSONObject resultJSON = new JSONObject(result);

		String success = (String) resultJSON.get("zhangsan");
		String status = (String) resultJSON.get("status");

		Assert.assertEquals("succeed", success);
		Assert.assertEquals("1", status);

	}



}
