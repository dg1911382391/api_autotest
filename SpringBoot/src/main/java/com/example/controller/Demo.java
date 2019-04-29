package com.example.controller;

import com.example.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dg on 2019-04-28.
 */
@Log4j
@RestController
@Api(value = "v1", description = "这是我的第一个版本的demo")
@RequestMapping("v1")
public class Demo {

	/**
	 * 	首先获取一个执行sql的对象
	 */
	@Autowired
	private SqlSessionTemplate template;

	@RequestMapping(value = "/selectUserCount", method = RequestMethod.GET)
	@ApiOperation(value = "可以获取到用户数", httpMethod = "GET")
	public int queryUserCount() {
		return template.selectOne("getUserCount");
	}

	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public int addUser(@RequestBody User user) {
		return template.insert("addUser", user);
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public int updateUser(@RequestBody User user) {
		return template.update("updateUser", user);
	}

}
