package com.bridgelabz.basicprogramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinerySearchTest {

	@Test
	public void test() {
		String str="Aa Bb Cc Dd Ee";
		String str1[]=str.split(" ");
		String a="Cc";
		int index=utility.Utility.binarySearch(str1, 0, str1.length, a);
		assertEquals(2,index);
		
	}

}
