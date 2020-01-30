package com.bridgelabz.controller;

import com.bridgelabz.service.Service;
import com.bridgelabz.utility.Utility;


public class Main {
public static void main(String[] args) throws Throwable {	
		
	Service obj=new Service();
		int ctr=0;
		while(ctr==0)
		{
			System.out.println("________________________________________");
			System.out.println("|1.Buy Shares                          |");
			System.out.println("|2.Add Company                         |");
			System.out.println("|3.Sell shares                         |");
			System.out.println("|4.Display Market/Customer             |");
			System.out.println("|5.View total share value in the market|");
			System.out.println("|6.View posession of specific customer |");
			System.out.println("----------------------------------------");
			int ch=Utility.returnInt();
			Utility.returnString();
			switch(ch)
			{
				case 1:
					obj.buy();
					break;
				case 2:
					obj.addCompany();
					break;
				case 3:
					obj.sell();
					break;
				case 4:
					obj.display();
					break;
				case 5:
					System.out.println(obj.totalValueOf());
					System.out.println("__________________________________________");
					break;
				case 6:
					System.out.println(obj.valueOf());
					System.out.println("__________________________________________");
					break;
				default:
					ctr++;					
			}
		}
	}
}
