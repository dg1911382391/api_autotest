package com.sen.api.testng;

import org.testng.annotations.Test;

/**
 * 超时测试
 * Created by dg on 2019-04-23.
 */
public class TimeOutTest {

	// 未超时
	@Test(timeOut = 3000)	// 单位：毫秒
	public void testSuccess() throws InterruptedException {
		Thread.sleep(2000);
	}

	// 超时了
	@Test(timeOut = 2000)	// 单位：毫秒
		public void testFailed() throws InterruptedException {
			Thread.sleep(5000);
	}

}
