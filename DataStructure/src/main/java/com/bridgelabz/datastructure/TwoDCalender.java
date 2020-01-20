package com.bridgelabz.datastructure;

import utility.Utility;

public class TwoDCalender {
	public static void main(String args[])
	{
		int m=Integer.parseInt(args[0]);
		int y=Integer.parseInt(args[1]);
		int d0=utility.Utility.displayweek(1, m, y);
		boolean ly=Utility.leapYear(y);
		int feb;
		if (ly==true)
		{
			feb=29;
		}
		else
		{
			feb=28;
		}
		int DoM[]= {31,feb,31,30,31,30,31,31,30,31,30,31};
		int dom=DoM[m-1];
		String arr[][]=new String [9][9];
		arr[0][0]="S";
		arr[0][1]="M";
		arr[0][2]="T";
		arr[0][3]="W";
		arr[0][4]="T";
		arr[0][5]="F";
		arr[0][6]="S";
		int ctr=0;
		for(int i=00;i<9;i++)
		{
			for(int j=00;j<9;j++)
			{
				if(i==1&&j==d0)
				{
					ctr++;
				}
				if(ctr>0&&ctr<=dom) {
					arr[i][j]=Integer.toString(ctr);
					ctr++;
				}
				else if(arr[i][j]==null)
					arr[i][j]=" ";
			}
		}
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<7;j++)
			{
				int x=0;
				if(i>1&&arr[i][j]!=" ")
				{
				 x=Integer.parseInt(arr[i][j]);
				}
				if(x<10)
				{
					System.out.print(arr[i][j]+"  ");
				}
				else 
				{
					System.out.print(arr[i][j]+" ");
				}
			}
			System.out.println();
		}
	}

}
