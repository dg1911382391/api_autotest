package com.sen.api.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * Created by dg on 2019-04-19.
 */
public class SuiteConfig {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before Suite运行啦！");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("after Suite运行啦！");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test运行啦");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test运行啦");
	}

}
