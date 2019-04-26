package com.example.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by dg on 2019-04-26.
 */
@RestController
public class MyGetMethod {

	@RequestMapping(value = "/getCookies", method = RequestMethod.GET)
	public String getCookies(HttpServletResponse response) {
		// HttpServletRequest	装请求信息的类
		// HttpServletResponse	装响应信息的类
		Cookie cookie = new Cookie("cookieName", "cookieValue");
		response.addCookie(cookie);

		return "恭喜你获得cookies信息成功！";
	}
}
