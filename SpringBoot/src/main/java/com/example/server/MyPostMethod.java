package com.example.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dg on 2019-04-28.
 */
@RestController
@Api(value = "/", description = "这是我全部的post请求")
@RequestMapping("/post")
public class MyPostMethod {

	/**
	 * 这个变量是用来装我们cookie信息的
	 */
	private static Cookie cookie;

	/**
	 * 用户登录成功获取到cookies，然后再访问其他接口，eg，商品列表
	 * 给客户端返回cookies
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ApiOperation(value = "登录接口，成功后获取cookies信息", httpMethod = "POST")
	public String login(HttpServletResponse response,
						@RequestParam(value = "userName", required = true) String userName,
						@RequestParam(value = "password", required = true) String password) {
		// HttpServletRequest	装请求信息的类
		// HttpServletResponse	装响应信息的类
		if (userName.equals("zhangsan") && password.equals("123456")) {
			Cookie cookie = new Cookie("login", "true");
			response.addCookie(cookie);
			return "恭喜你登录成功了！";
		}
		return "用户名或密码错误！";
	}



}
