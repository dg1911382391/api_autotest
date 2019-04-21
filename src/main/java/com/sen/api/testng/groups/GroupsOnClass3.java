package com.sen.api.testng.groups;

import org.testng.annotations.Test;

/**
 * 组测试：类分组
 * Created by dg on 2019-04-19.
 */
@Test(groups = "teacher")
public class GroupsOnClass3 {

	public void teacher1() {
		System.out.println("GroupsOnClass3中的teacher1运行！");
	}

	public void teacher2() {
		System.out.println("GroupsOnClass3中的teacher2运行！");
	}

}
