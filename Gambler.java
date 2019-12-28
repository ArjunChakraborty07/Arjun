package com.bridgelabz.basic;

import java.util.Random;
import java.util.Scanner;

public class Gambler {
	public static void main(String args[]) {
		System.out.println("Gambling\n\n");
		Random gamble=new Random();
		Scanner Input=new Scanner(System.in);
		System.out.print("Enter Stake:");
		int stake=Input.nextInt();
		System.out.print("Enter Goal:");
		int goal=Input.nextInt();
		System.out.print("Enter Trials:");
		int trials=Input.nextInt();
		int win=0,loss=0,play=0,t=0,tt;
		//while(play<trials)
		{
		while(play<trials&&(stake>0 && stake<goal))
		{
			play++;
			t++;
			tt=trials-t;
			int g=gamble.nextInt(2);
			if(g==1)
			{
				stake++;
				win++;
				System.out.println("Player wins("+win+"), stake raised to "+stake+" trials left "+tt+" play "+play);
			}
			else {
				stake--;
				loss++;
				System.out.println("Player loses("+loss+"), stake reduced to "+stake+" trials left "+tt+" play "+play);
			}
		}
		}
		double percentwin=((double)win/play)*100;
		System.out.println("Win Percent is "+percentwin);
		Input.close();
	}

}
