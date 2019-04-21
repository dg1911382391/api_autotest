package com.sen.api.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * 组测试：方法分组
 * Created by dg on 2019-04-19.
 */
public class GroupsOnMethod {

	@Test(groups = "server")
	public void test1() {
		System.out.println("这是服务端组的测试方法111");
	}

	@Test(groups = "server")
	public void test2() {
		System.out.println("这是服务端组的测试方法222");
	}

	@Test(groups = "client")
	public void test3() {
		System.out.println("这是客户端组的测试方法333");
	}

	@Test(groups = "client")
	public void test4() {
		System.out.println("这是客户端组的测试方法444");
	}

	@BeforeGroups("server")
	public void beforeGroupsOnServer() {
		System.out.println("这是服务端组运行之前运行的方法^^^");
	}

	@AfterGroups("server")
	public void afterGroupsOnServer() {
		System.out.println("这是服务端组运行之后运行的方法!!!");
	}

}
