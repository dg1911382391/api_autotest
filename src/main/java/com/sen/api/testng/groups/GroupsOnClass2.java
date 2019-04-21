package com.sen.api.testng.groups;

import org.testng.annotations.Test;

/**
 * 组测试：类分组
 * Created by dg on 2019-04-19.
 */
@Test(groups = "student")
public class GroupsOnClass2 {

	public void student1() {
		System.out.println("GroupsOnClass2中的student1运行！");
	}

	public void student2() {
		System.out.println("GroupsOnClass2中的student2运行！");
	}

}
