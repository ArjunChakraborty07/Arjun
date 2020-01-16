package com.bridgelabz.datastructure;

public class Deque {
	static class Node{
		char data;
		Node prev;
		Node next;
		Node(char d)
		{
			prev=null;
			data=d;
			next=null;
		}
	}
	static Node front;
	static Node rear;
	public static void addfront(char data)
	{
		Node curr=new Node(data);
		if(front==null)
		{
			rear=curr;
			front=curr;
		}
		else
		{
			Node follow=front;
			curr.next=follow;
			follow.prev=curr;
			front=curr;
		}
	}
	public static void addrear(char data)
	{
		Node curr= new Node(data);
		if(rear==null)
		{
			front=curr;
			rear=curr;
		}
		else
		{
			Node past=rear;
			curr.prev=past;
			past.next=curr;
			rear=curr;
		}
	}
	public static void removefront()
	{
		if(front==rear)
		{
			front=null;
			rear=null;
		}
		else
		{
			front=front.next;		
			front.prev=null;
		}
		
	}
	public static void removerear()
	{
		if(front==rear)
		{
			front=null;
			rear=null;
		}
		else
		{
			rear=rear.prev;
			rear.next=null;
		}
	}
	public static void display()
	{
		Node print=front;
		System.out.println("Queue");
		if(print==null)
		{
			System.out.println(" Nothing to display");
		}
		while(print!=null)
		{
			System.out.print(print.data+" ");
			print=print.next;
		}	
		System.out.println();
	}
	public static boolean isempty()
	{
		if(front==null)
			return true;
		return false;
	}
	public static int size() 
	{
		int count=0;
		Node curr=front;
		while(curr!=null)
		{
			count++;
			curr=curr.next;
		}
		return count;
	}
	public static void deque(){
		front=null;
		rear=null;
	}
	public static void main(String[] args) {
		System.out.print("Enter a string for palindrome check:");
		String str=utility.Utility.returnString();
		char ch[]=str.toCharArray();
		for(int i=0;i<ch.length;i++)
		{
			addfront(ch[i]);
		}
		System.out.println(" Deque added using front");
		display();
		deque();
		for(int i=0;i<ch.length;i++)
		{
			addrear(ch[i]);
		}
		System.out.println(" Deque added using rear");
		display();
		System.out.print("\n Are the string looks same(Y/N)?: ");
		char c=utility.Utility.returnChar();
		if(c=='y'||c=='Y')
		{
			System.out.print(" Yes, you thought that right, the string is palindrome ");
		}
		else
		{
			System.out.print(" Oops, the string is not palindrome");
		}
	}
}
