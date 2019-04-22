package com.sen.api.testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 参数化测试 -- xml文件参数化
 * Created by dg on 2019-04-22.
 */
public class ParameterTest {

	@Test
	@Parameters({"name","age"})
	public void paramTest1(String name, int age) {
		System.out.println("姓名=" + name + "; 年龄=" + age);
	}


}
