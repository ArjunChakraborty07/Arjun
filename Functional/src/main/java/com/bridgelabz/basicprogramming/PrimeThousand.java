package com.bridgelabz.basicprogramming;

import java.util.ArrayList;

import utility.Utility;









Program is not complete -------------------------------
public class PrimeThousand {
	public static void main(String args[])
	{
		System.out.println("Enter the range(limit is 1000):");
		int n=Utility.returnInt();
		int x=0;
		int y=0;
		ArrayList<Integer> arraylist=new ArrayList<Integer>();
		ArrayList<Integer> arraylist2=new ArrayList<Integer>();
		ArrayList<Integer> arraylist3=new ArrayList<Integer>();
		ArrayList<Integer> arraylist4=new ArrayList<Integer>();
		ArrayList<Integer> arraylist5=new ArrayList<Integer>();
		arraylist=Utility.primeRange(n);
		System.out.println("Prime Numbers");
		System.out.println(arraylist);
		for(int i=0;i<arraylist.size()-1;i++)
		{		
			x=arraylist.get(i);
			//int tmp=x;
			while(x>0)
			{
				int r1=0;
				r1=x%10;
				arraylist4.add(r1);
				x=x/10;
			}
			for(int j=i+1;j<arraylist.size();j++)
			{			
				
				y=arraylist.get(j);
				//System.out.print(y);
				//int tmp2=y;
				while(y>0)
				{
					int r2=0;
					r2=y%10;
					arraylist5.add(r2);	
					//System.out.print(arraylist5);
					y=y/10;
				}				
				int k=arraylist4.size()-1;
				int l=arraylist5.size()-1;
				int ctr=0;
				if(arraylist4.size()==arraylist5.size())
				{
					while(k>0)
					{
						
						while(l>0)
						{
							l--;
							if(arraylist4.get(k)==arraylist5.get(l))
								
							//System.out.print(ctr+" ");
						}
						k--;
					}
					if(ctr==k)
					{
						arraylist3.add(y);
						//System.out.print(arraylist3);
					}						
				}
			}
			arraylist4.clear();
			arraylist5.clear();
		}
		System.out.println("Anagram Numbers");
		System.out.print(arraylist3);
		for(int i=0;i<arraylist.size();i++)
		{
			int s=0;
			x=arraylist.get(i);
			int tmp=x;
			while(tmp>0)
			{
				int r=0;
				r=tmp%10;
				tmp=tmp/10;
				s=s*10+r;
			}
			//s=s/10;
			if(x==s)
			{
				arraylist2.add(s);
			}
		}
		System.out.println("Palindrome Numbers are");
		System.out.print(arraylist2);
	}
}
