package com.sen.api.testng;

import org.testng.annotations.Test;

/**
 * Created by dg on 2019-04-19.
 */
public class IgnoreTest {

	@Test
	public void ignore1() {
		System.out.println("ignore1 执行！");
	}

	@Test(enabled = false)
	public void ignore2() {
		System.out.println("ignore2 执行！");
	}

	@Test(enabled = true)
	public void ignore3() {
		System.out.println("ignore3 执行！");
	}

}
