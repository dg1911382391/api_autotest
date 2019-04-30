package com.example.controller;

import com.example.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Created by dg on 2019-04-28.
 */
@RestController
@Api(value = "/", description = "这是我全部的post请求")
@RequestMapping("/post")
public class MyPostController {

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

	/**
	 * 要求客户端携带cookies、参数访问此接口
	 * 这是一个需要携带cookies信息以及入参才能访问的post请求
	 */
	@RequestMapping(value = "/getUserList", method = RequestMethod.POST)
	@ApiOperation(value = "获取用户列表" , httpMethod = "POST")
	public String getUserList(HttpServletRequest request,
							@RequestBody User user) {
		User u;
		Cookie[] cookies = request.getCookies();
		if (Objects.isNull(cookies)) {
			return "你必须携带cookies信息来";
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("login")	// equals与== 值比对与地址比对
					&& cookie.getValue().equals("true")
					&& user.getUserName().equals("zhangsan")
					&& user.getPassword().equals("123456")
			) {
				u = new User();
				u.setName("lisi");
				u.setAge(24);
				u.setSex("man");
				return u.toString();
			}
		}
		return "参数不合法！";

	}

}
