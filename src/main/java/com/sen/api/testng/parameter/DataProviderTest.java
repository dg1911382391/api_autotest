package com.sen.api.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created by dg on 2019-04-22.
 */
public class DataProviderTest {

	@Test(dataProvider = "data")
	public void testDataProvider(String name, int age) {
		System.out.println("姓名=" + name + "; 年龄=" + age);
	}

	@DataProvider(name = "data")
	public Object[][] providerData(String name, int age) {
		Object[][] objects = new Object[][]{
				{"zhangsan", 10},
				{"lisi", 20},
				{"wangwu", 30}
		};

		return objects;
	}



	@Test(dataProvider = "methodData")
	public void test1(String name, int age) {
		System.out.println("test111方法 姓名="+name + " 年龄="+age);
	}

	@Test(dataProvider = "methodData")
	public void test2(String name, int age) {
		System.out.println("test222方法 姓名="+name + " 年龄="+age);
	}

	@DataProvider(name = "methodData")
	public Object[][] methodDataTest(Method method) {
		Object[][] result = null;
		if (method.getName().equals("test1")){
			result = new Object[][]{
				{"zhangsan",23},
				{"lisi",54}
			};
		} else if (method.getName().equals("test2")) {
			result = new Object[][]{
					{"wangwu",2},
					{"zhaoliu",7}
			};
		}

		return result;
	}

}
