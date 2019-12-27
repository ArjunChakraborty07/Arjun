package com.bridgelabz.basic;

public class PowerofTwo {
	public static void main(String[]args) {
		int n=Integer.parseInt(args[0]);
		for(int i=1;i<=n;i++)
		{System.out.print("\n");
			for(int j=1;j<=10;j++)
				{int table=(int)Math.pow(i,2)*j;
			     System.out.print(table+" ");
		}
	  }
	}
}
