package com.bridgelabz.basic;
import java.util.Random;
public class Flipcoin {
public static void main(String[] args) {
	System.out.println("Flip Coin");
	Random rand=new Random();
	int a=rand.nextInt(2);
	if(a==0)
		System.out.println("head");
	else
		System.out.println("tail");
}
}
