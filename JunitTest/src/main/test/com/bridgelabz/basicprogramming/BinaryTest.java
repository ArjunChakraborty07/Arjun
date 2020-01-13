package com.bridgelabz.basicprogramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTest {

	@Test
	public void test() {
		int a=100;
		int arr[]=utility.Utility.toBinary(a);
		int ar[]={0,1,1,0,0,1,0,0};
		assertArrayEquals(ar,arr);
	}

}
