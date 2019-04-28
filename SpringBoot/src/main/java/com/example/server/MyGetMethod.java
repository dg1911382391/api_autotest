package com.example.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by dg on 2019-04-26.
 */
@RestController
@Api(value = "/", description = "这是我全部的get方法")
public class MyGetMethod {

	/**
	 * 给客户端返回cookies
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getCookies", method = RequestMethod.GET)
	@ApiOperation(value = "通过这个方法可以获取到cookies", httpMethod = "GET")
	public String getCookies(HttpServletResponse response) {
		// HttpServletRequest	装请求信息的类
		// HttpServletResponse	装响应信息的类
		Cookie cookie = new Cookie("cookieName", "cookieValue");
		response.addCookie(cookie);

		return "恭喜你获得cookies信息成功！";
	}

	/**
	 * 要求客户端携带cookies访问此接口
	 * 这是一个需要携带cookies信息才能访问的get请求
	 */
	@RequestMapping(value = "getWithCookies", method = RequestMethod.GET)
	@ApiOperation(value = "要求客户端携带cookies", httpMethod = "GET")
	public String getWithCookies(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (Objects.isNull(cookies)) {
			return "你必须携带cookies信息来";
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("cookieName") && cookie.getValue().equals("cookieValue")) {
				return "恭喜你访问成功";
			}
		}
		return "需要携带cookies信息才能访问的get请求";
	}

	/**
	 * 开发一个需要携带参数才能访问的get请求
	 * 实现方式1：@RequestParam
	 * URL:key=value&key=value
	 * 如，http://localhost:8888/get/with/param?start=20&end=20
	 * 模拟获取商品列表
	 */
	@RequestMapping(value = "/get/with/param", method = RequestMethod.GET)
	@ApiOperation(value = "需要携带参数才能访问的get请求方法1", httpMethod = "GET")
	public Map<String, Integer> getList(@RequestParam Integer start, @RequestParam Integer end) {
		Map<String, Integer> shopListMap = new HashMap<>();
		shopListMap.put("鞋", 500);
		shopListMap.put("干脆面", 1);
		shopListMap.put("衬衫", 300);
		return shopListMap;
	}

	/**
	 * 开发一个需要携带参数才能访问的get请求
	 * 实现方式2：@PathVariable
	 * URL:ip/port/get/with/param/10/20
	 * 如，http://localhost:8888/get/with/param/10/20
	 * 模拟获取商品列表
	 */
	@RequestMapping(value = "/get/with/param/{start}/{end}")
	@ApiOperation(value = "需要携带参数才能访问的get请求方法2", httpMethod = "GET")
	public Map<String, Integer> getList2(@PathVariable Integer start, @PathVariable Integer end) {
		Map<String, Integer> shopListMap = new HashMap<>();
		shopListMap.put("鞋", 500);
		shopListMap.put("干脆面", 1);
		shopListMap.put("衬衫", 940);
		return shopListMap;
	}


}
