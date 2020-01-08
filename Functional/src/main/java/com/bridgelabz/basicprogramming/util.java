package com.bridgelabz.basicprogramming;
public class util {
	public static void monthlyPayment(int P, int Y, double R) {
		double n=12*Y;
		double r=R/(12*100);
		double payment=(P*r)/(1-Math.pow((1+r),(-n)));
		System.out.print("\nPayment: "+payment);
	}
	public static void displayweek(int d,int m,int y)
	{
		System.out.println("Day of Week");
			double y0 = y-((14-m)/12);
			double x  = y0+(y0/4)-(y0/100)+(y0/400);
			double m0 = m + 12*((14-m)/12)-2;
			int d0 =(int) (d + x + (31*m0)/12)%7;
			System.out.println(d0);
			switch(d0)
			{
			case 1:
				System.out.println("Monday");
				break;
			case 2:
				System.out.println("Tueday");
				break;
			case 3:
				System.out.println("Wednesday");
				break;
			case 4:
				System.out.println("Thrusday");
				break;
			case 5:
				System.out.println("Friday");
				break;
			case 6:
				System.out.println("Saturday");
				break;
			case 0:
				System.out.println("Sunday");
				break;
			default:
				System.out.println("Invalid data");	
			}
	}		
	public static void temperatureConversion(int ch, double T) {
		if(ch==1)
		{
			 double F=(T*9/5)+32;
			 System.out.println("Farhenheit: "+F);
		}
		else
		{
			double C=(T-32)*5/9;
			System.out.println("Celcius: "+C);

		}
	}
	public static double sqrt(int c) {
		int t=c;
		double epsilon=Math.pow(Math.E, -15);
		while(Math.abs(t - (c/t)) > epsilon*t)
		{
			t=((c/t)+t)/2;
		}
		return t;
		
	}
	public static int[] toBinary(int n) {
		int []binary=new int[8];
		int index=0;
		while(n>0) 
		{
			binary[index]=n%2;
			n=n/2;
			index++;	
		}
		return binary;
	}
}
