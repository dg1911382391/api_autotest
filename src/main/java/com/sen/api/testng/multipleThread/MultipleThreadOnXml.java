package com.sen.api.testng.multipleThread;

import org.testng.annotations.Test;

/**
 * Created by dg on 2019-04-22.
 */
public class MultipleThreadOnXml {

	@Test
	public void test1() {
		System.out.println("Thread Id : " + Thread.currentThread().getId());
	}

	@Test
	public void test2() {
		System.out.println("Thread Id : " + Thread.currentThread().getId());
	}

	@Test
	public void test3() {
		System.out.println("Thread Id : " + Thread.currentThread().getId());
	}

}
