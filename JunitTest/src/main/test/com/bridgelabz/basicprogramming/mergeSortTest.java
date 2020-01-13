package com.bridgelabz.basicprogramming;

import static org.junit.Assert.*;

import org.junit.Test;

import utility.Utility;

public class mergeSortTest {

	@Test
	public void test() {
		String arr[]={"Dc","Bb","Zz","Aa"};
		String arr1[]=Utility.mergeSort(arr,0,arr.length-1);
		String exp[]= {"Aa","Bb","Dc","Zz"};
		assertArrayEquals( exp, arr1);
	}

}
