package com.sen.api.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by dg on 2019-04-19.
 */
public class BasicAnnotation {

	/**
	 * 最基本的注解，用来把方法标记为测试的一部分
	 */
	@Test
	public void testCase1() {
		System.out.println("Test这是测试用例1");
	}

	@Test
	public void testCase2() {
		System.out.println("Test这是测试用例2");
	}

	@BeforeTest
	public void beforeMethod() {
		System.out.println("BeforeTest这是在测试方法之前运行的。");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod这是在测试方法之后运行的。");
	}


}
