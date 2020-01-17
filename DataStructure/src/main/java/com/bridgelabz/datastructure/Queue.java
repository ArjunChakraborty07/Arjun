package com.bridgelabz.datastructure;

public class Queue {
	static class Node{
		int data;
		Node next;
		Node(int d)
		{
			data=d;
			next=null;
		}
	}
	static Node front;
	static Node rear;
	public static void enqueue(int data)
	{
		Node now=new Node(data);
		if(front==null)
		{
			rear=now;
			front=now;
		}
		else
		{
			Node last=rear;
			last.next=now;
			rear=now;
		}
		
	}
	public static void dequeue()
	{
		front=front.next;		
	}
	public static void printlist()
	{
		Node print=front;
		System.out.println("Queue");
		while(print!=null)
		{
			System.out.print(print.data+" ");
			print=print.next;
		}	
		System.out.println();
	}
	
	public static void peek()
	{
		System.out.println(front.data);
	}
	public static boolean isempty()
	{
		if(front==null)
		{
			return true;
		}
		return false;
	}
	public static int size()
	{
		int count=0;
		Node ctr=front;
		while(ctr!=null)
		{
			count++;
			ctr=ctr.next;
		}
		return count;
	}
	public static int sum()
	{
		System.out.println("Total: ");
		Node curr=front;
		int total=0;
		while(curr!=null) 
		{
			total+=curr.data;
			curr=curr.next;
		}
		return total;
	}
	public static void main(String[] args) {
		enqueue(5);
		printlist();
		enqueue(4);
		printlist();
		enqueue(1);
		printlist();
		enqueue(8);
		printlist();
		enqueue(7);
		printlist();
		dequeue();
		printlist();
		peek();
		System.out.println(isempty());
		System.out.println(size());
		enqueue(-21);
		enqueue(4);
		printlist();
		System.out.println(sum());
	}
}
