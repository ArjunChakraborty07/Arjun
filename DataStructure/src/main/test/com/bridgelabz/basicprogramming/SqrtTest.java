package com.bridgelabz.basicprogramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class SqrtTest {

	

	@Test
	public void test() {

		int a = 16;
		double d = utility.Utility.sqrt(a);

		assertEquals(4.0,d,100);
	}

}
