package com.example.controller;

import com.example.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

/**
 * Created by dg on 2019-04-30.
 */
@Log4j
@RestController
@Api(value = "api", description = "用户管理系统")
public class UserController {

	@Autowired
	private SqlSessionTemplate template;

	@RequestMapping(value = "/api/login", method = RequestMethod.POST)
	@ApiOperation(value = "登录接口", httpMethod = "POST")
	public Boolean login(HttpServletResponse response, @RequestBody User user) {
		int i = template.selectOne("login", user);
		Cookie cookie = new Cookie("login", "true");
		/**
		 * 用HttpServletResponse响应Cookies
		 */
		response.addCookie(cookie);

		log.info("查询到的结果是" + i);
		if (i == 1) {
			log.info("登录的用户是:" + user.getName());
			return true;
		}
		return false;
	}

	@RequestMapping(value = "/api/insertUser", method = RequestMethod.POST)
	@ApiOperation(value = "添加用户接口", httpMethod = "POST")
	public boolean addUser(HttpServletRequest request, @RequestBody User user) {
		Boolean flag = verifyCookies(request);
		int result = 0;
		if (flag != null) {
			result = template.insert("addUser", user);
		}
		if (result > 0) {
			log.info("添加用户的数量是：" + result);
			return true;
		}
		return false;
	}

	@RequestMapping(value = "/api/selectUserInfo", method = RequestMethod.POST)
	@ApiOperation(value = "获取用户(列表)信息接口", httpMethod = "POST")
	public List<User> queryUserInfo(HttpServletRequest request, @RequestBody User user) {
		Boolean flag = verifyCookies(request);
		if (flag == true) {
			List<User> userList = template.selectList("getUserList", user);
			log.info("queryUserInfo查询到到用户数量是：" + userList.size());
			return userList;
		} else {
			return null;
		}

	}

	@RequestMapping(value = "/api/updateUserInfo", method = RequestMethod.POST)
	@ApiOperation(value = "更新/删除用户接口", httpMethod = "POST")
	public int updateUser(HttpServletRequest request, @RequestBody User user) {
		Boolean flag = verifyCookies(request);
		int i = 0;
		if (flag == true) {
			i = template.update("updateUser", user);
		}
		log.info("更新的数据条数是：" + i);
		return i;
	}

	/**
	 * 用HttpServletRequest验证Cookies
	 */
	public Boolean verifyCookies(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (Objects.isNull(cookies)) {
			log.info("你必须携带cookies信息来!!!");
			return false;
		}
		for (Cookie cookie: cookies) {
			if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
				log.info("cookies验证通过！");
				return true;
			}
		}
		log.info("cookies验证不通过！！！");
		return false;
	}


}
