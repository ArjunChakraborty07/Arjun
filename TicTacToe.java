package com.bridgelabz.basic;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	static char arr[]= {'-','-','-','-','-','-','-','-','-'};
	static int check=0;
	static Scanner Input=new Scanner(System.in);
	public static void boardDisplay(char arr[])
	{
		System.out.println(arr[0]+ " "+arr[1]+" "+arr[2]);
		System.out.println(arr[3]+ " "+arr[4]+" "+arr[5]);
		System.out.println(arr[6]+ " "+arr[7]+" "+arr[8]);
		/*for(int i=0;i<3;i++) 
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(arr[i]+" ");
			}
			System.out.print("\n");
		}*/
	}
	public static void userPlay(char arr[])
	{
		int n;
		System.out.print("Enter the index(1-9):");
		n=Input.nextInt();
		arr[n-1]='X';
		boardDisplay(arr);
	}
	public static void cpuPlay(char arr[])
	{
		int n=0;
		Random r=new Random();
		int i=0;
		while(i==0)
		{
			n=r.nextInt(9);
			if(arr[n]=='-')
				{
					i++;
					arr[n]='O';
				}
		}	
		boardDisplay(arr);
	}
	public static int checkResult(char arr[])
	{
		int r=0;
		if((arr[0]==arr[1]&& arr[1]==arr[2]&& arr[2]=='X')||(arr[0]==arr[3]&& arr[3]==arr[6]&& arr[6]=='X')||(arr[3]==arr[4]&& arr[4]==arr[5]&& arr[5]=='X')||(arr[1]==arr[4]&& arr[4]==arr[7]&& arr[7]=='X')||(arr[6]==arr[7]&& arr[7]==arr[8]&& arr[8]=='X')||(arr[2]==arr[5]&& arr[5]==arr[8]&& arr[8]=='X')||(arr[0]==arr[4]&& arr[4]==arr[8]&& arr[8]=='X')||(arr[2]==arr[4]&& arr[4]==arr[6]&& arr[6]=='X'))
		{
			System.out.println("Winner is user");
			r=1;
		}
		else if((arr[0]==arr[1]&& arr[1]==arr[2]&& arr[2]=='O')||(arr[0]==arr[3]&& arr[3]==arr[6]&& arr[6]=='O')||(arr[3]==arr[4]&& arr[4]==arr[5]&& arr[5]=='O')||(arr[1]==arr[4]&& arr[4]==arr[7]&& arr[7]=='O')||(arr[6]==arr[7]&& arr[7]==arr[8]&& arr[8]=='O')||(arr[2]==arr[5]&& arr[5]==arr[8]&& arr[8]=='O')||(arr[0]==arr[4]&& arr[4]==arr[8]&& arr[8]=='O')||(arr[2]==arr[4]&& arr[4]==arr[6]&& arr[6]=='O'))
		{
			System.out.println("Winner is CPU");
			r=-1;
		}
		else if(check==0) 
		{	
			for(int i=0;i<9;i++)
			{
				if(arr[i]=='-')
				{
				check++;
				}
			}
			if(check==0)
			{
				System.out.println("Match Draw");
				r=0;
			}
		}
		else 
			r=2;
		return r;
	}
	public static void main(String args[]) 
	{
		boardDisplay(arr);
		int gamecheck=2;
		while(gamecheck==2)
		{
			userPlay(arr);
			System.out.println("-------------------");
			gamecheck=checkResult(arr); 
			System.out.println(gamecheck);
				System.out.println("CPU plays");
				cpuPlay(arr);
				System.out.println("-------------------");	
				gamecheck=checkResult(arr);
		}
	}

}
