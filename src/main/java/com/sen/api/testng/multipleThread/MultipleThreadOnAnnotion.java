package com.sen.api.testng.multipleThread;

import org.testng.annotations.Test;

/**
 * Created by dg on 2019-04-22.
 */
public class MultipleThreadOnAnnotion {

	@Test(invocationCount = 10, threadPoolSize = 3)
	public void test(){
		System.out.println(1);
		System.out.println("Thread Id : %s%n" + Thread.currentThread().getId());
	}

}
