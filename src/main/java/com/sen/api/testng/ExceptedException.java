package com.sen.api.testng;

import org.testng.annotations.Test;

/**
 * Created by dg on 2019-04-21.
 */
public class ExceptedException {

	/**
	 * 什么时候会用到异常测试？
	 * 在我们期望结果为某一个异常的时候。
	 * 比如，我们传入了某些不合法的参数，程序抛出异常，
	 * 也就是说我的预期结果就是这个异常。
	 */

	/**
	 * 这是一个测试结果会失败的异常测试
	 */
	@Test(expectedExceptions = RuntimeException.class)
	public void runTimeExceptionFailed() {
		System.out.println("这是一个失败的异常测试。");
	}

	/**
	 * 这是一个测试结果会成功的异常测试
	 */
	@Test(expectedExceptions = RuntimeException.class)
	public void runTimeExceptionSucceed() {
		System.out.println("这是我的异常测试。");
		throw new RuntimeException();
	}

}
