package com.bridgelabz.basicprogramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerInsertionTest {

	@Test
	public void test() {
		int arr[]= {5,4,7,9,1,8};
		arr=utility.Utility.insertion(arr);
		int exp[]= {1,4,5,7,8,9};
		assertArrayEquals(exp,arr);
	}

}
