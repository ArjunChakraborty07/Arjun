package utility;

import java.util.Scanner;

public class Utility {
		private static final Scanner sc=new Scanner(System.in);
		
		public static int returnInt()
		{
			return sc.nextInt();
		}
		public static double returnDouble()
		{
			return sc.nextDouble();
		}
		public static char returnChar()
		{
			return sc.next().charAt(0);
		}
		public static boolean returnBoolean()
		{
			return sc.nextBoolean();
		}
		public static String returnString()
		{
			return sc.nextLine();
		}
		public static void monthlyPayment(int P, int Y, double R)
		{
			double n=12*Y;
			double end=R/(12*100);
			double payment=(P*end)/(1-Math.pow((1+end),(-n)));
			System.out.print("\nPayment: "+payment);
		}
		public static void displayweek(int d,int m,int y)
		{				
				int y0 = y - (14 - m) / 12;
				int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
				int m0 = m + 12 * ((14 - m) / 12) - 2;
				int d0 = (d + x + (31 * m0) / 12) % 7;
			
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
					System.out.println("Invalid data Check Code");	
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
		public static int binarySearch(String arr[], int beg, int end, String str)
		{		
			while(beg<=end)
			   {
			     int mid=(beg+end)/2;
			     if (arr[mid].compareToIgnoreCase(str) < 0)			     
			     {
			         beg=mid+1;
			     }
			     else if (arr[mid].compareToIgnoreCase(str) > 0)
			     {
			         end=mid-1;
			     }
			     else
			     {
			         return mid;
			     }
			   }
			System.out.println("Word not found!!");
			return -1;
		}
		public static <T extends Comparable<? super T>>T[] Mysortgeneric(T s[]) {
			T tmp;
			for (int i = 0; i < s.length; i++) {
				for (int j = 0; j < s.length; j++) {
					if (s[i].compareTo(s[j]) < 1) {
						tmp = s[i];
						s[i] = s[j];
						s[j] = tmp;
					}
				}
			}
			return s;
		}
		
		public static String[] insertionSort(String arr[]) 
	    { 
	        int n=arr.length; 
	        for (int i=1;i<n;i++)
	        { 
	        	String temp=arr[i];
	        	int j=i-1;
	            while(j>=0 && (arr[j].compareToIgnoreCase(temp)>0))
	            {
	            		arr[j+1]=arr[j];
	            		j=j-1;
	            } 
	            arr[j+1]=temp;
	        }
	        return arr;
	    }
	        public static int[] insertion(int arr[])
	        {
	            int n = arr.length; 
	            for (int i = 1; i < n; ++i) { 
	                int key = arr[i]; 
	                int j = i - 1; 
	                while (j >= 0 && arr[j] > key) { 
	                    arr[j + 1] = arr[j]; 
	                    j = j - 1; 
	                } 
	                arr[j + 1] = key; 
	            } 
	            return arr;
	        } 
	       public static String[] bubbleSort(String arr[]) 
	        { 
	            int n = arr.length; 
	            for (int i = 0; i < n-1; i++) 
	            {
	                for (int j = 0; j < n-i-1; j++) 
	                {
	                    if (arr[j].compareToIgnoreCase(arr[j+1])>0) 
	                    {
	                        String temp = arr[j]; 
	                        arr[j] = arr[j+1]; 
	                        arr[j+1] = temp; 
	                    } 
	                }
	            }
	            return arr;
	        } 
	       static void merge(String arr[],int beg, int mid, int end)
	       {
	    	   int n1 = mid - beg + 1; 
	           int n2 = end - mid; 
	           String L[] = new String [n1]; 
	           String R[] = new String [n2]; 
	           for (int i=0; i<n1; ++i) 
	           {
	               L[i] = arr[beg + i]; 
	           }
	           for (int j=0; j<n2; ++j) 
	           {
	           	   R[j] = arr[mid + 1+ j]; 
	           }
	           int i = 0, j = 0;
	           int k = beg; 
	           while (i < n1 && j < n2) 
	           { 
	               if (L[i].compareTo(R[j])<=0) 
	               { 
	                   arr[k] = L[i]; 
	                   i++; 
	               } 
	               else
	               { 
	                   arr[k] = R[j]; 
	                   j++; 
	               } 
	               k++; 
	           } 
	           while (i < n1) 
	           { 
	               arr[k] = L[i]; 
	               i++; 
	               k++; 
	           } 
	           while (j < n2) 
	           { 
	               arr[k] = R[j]; 
	               j++; 
	               k++; 
	           } 
	       } 
	      public static void mergeSort(String arr[], int beg, int end) 
	       { 
	           if (beg < end) 
	           {
	               int mid = (beg+end)/2; 
	               mergeSort(arr, beg, mid); 
	               merge(arr, beg, mid, end); 
	           } 
	       } 
	      public static boolean AnagramStrings(String string1, String string2)
	      {
	    	char ar1[]=string1.toCharArray();
	  		char ar2[]=string2.toCharArray();
	  		String a=String.valueOf(charsort(ar1));
	  		String b=String.valueOf(charsort(ar2));
	  		
	  		if(a.compareToIgnoreCase(b)==0)
	  		{
	  			return true;
	  		}
	  		return false;
	      }
	      public static char[] charsort(char arr[])
	      {
	    	  int n = arr.length; 
	            for (int i = 0; i < n-1; i++) 
	            {
	                for (int j = i+1; j < n; j++) 
	                {
	                    if (Character.compare(arr[i], arr[j])>0) 
	                    {
	                        char temp = arr[j]; 
	                        arr[j] = arr[i]; 
	                        arr[i] = temp; 
	                    } 
	                }
	            }
	            return arr;
	      }
	      public static< T extends Comparable<? super T>>void selectionSortgeneric(T[] arr)
	      {
	    	  for(int i=0;i<arr.length-1;i++)
	    	  {	  int min=i;
	    	  	for(int j=i+1;j<arr.length;j++)
	    	  	{
	    		  if(arr[j].compareTo(arr[min])<0)
	    		  {
	    			  min=j;
	    		  }
	    	  	}
	    	  T temp=arr[i];
	    	  arr[i]=arr[min];
	    	  arr[min]=temp;
	    	  }
	      }
	      public static<T extends Comparable<? super T>> int binarySearchgeneric(T arr[], int beg, int end, T str)
			{		
				while(beg<=end)
				   {
				     int mid=(beg+end)/2;
				     if (arr[mid].compareTo(str) < 0)			     
				     {
				         beg=mid+1;
				     }
				     else if (arr[mid].compareTo(str) > 0)
				     {
				         end=mid-1;
				     }
				     else
				     {
				         return mid;
				     }
				   }
				System.out.println("Item not found!!");
				return -1;
			}
		public static <T extends Comparable<? super T>> T[] insertionSortgeneric(T[] arr) 
		{ 
		    int n=arr.length; 
		    for (int i=1;i<n;i++)
		    { 
		    	T temp=arr[i];
		    	int j=i-1;
		        while(j>=0 && (arr[j].compareTo(temp)>0))
		        {
		        		arr[j+1]=arr[j];
		        		j=j-1;
		        } 
		        arr[j+1]=temp;
		    }
		    return arr;
		}
		static int ctr=0;
		public static void message(int arr[],int beg, int end)
		{				
			ctr++;
			int mid=(beg+end)/2;
			System.out.println(" CPU guesses your number is "+arr[mid]);
			System.out.println(" If the guess is high press 1");
			System.out.println(" If the guess is low press 2");
			System.out.println(" If the guess is correct press 3");
			System.out.print(" Enter your choice:");
			int ch=Utility.returnInt();
			switch(ch)
			{
			case 1:
				System.out.println(" Number is too high, guess again");
				end=mid;
				message(arr,beg,end);
				break;
			case 2:	
				System.out.println(" Number is too low, guess again");
				beg=mid;
				message(arr,beg,end);
				break;
			case 3:
				System.out.print(" You guessed it right, good job CPU");
				System.out.print(" ,You took "+ ctr+" chances");
				break;
			}
		}
}		



