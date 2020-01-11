package com.bridgelabz.basicprogramming;

import static org.junit.Assert.*;

import org.junit.Test;



public class AnagramTest {

	@Test
	
	
	public void isAnagramTest() {
		
		String s1="earth";
		String s2="heart";
		String s3="raghu";
		boolean actual1=utility.Utility.AnagramStrings(s1, s2);
		boolean actual2=utility.Utility.AnagramStrings(s1, s3);
		
		assertEquals(true, actual1);
		assertEquals(false, actual2);
		
		
	}

}
