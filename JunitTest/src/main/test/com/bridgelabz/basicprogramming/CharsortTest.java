package com.bridgelabz.basicprogramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class CharsortTest {

	@Test
	public void test() {
		char [] arr= {'c','d','S','k','T','a'};
		arr=utility.Utility.charsort(arr);
		char exp[]= {'S','T','a','c','d','k'}; 
		assertArrayEquals(exp,arr);
	}

}
