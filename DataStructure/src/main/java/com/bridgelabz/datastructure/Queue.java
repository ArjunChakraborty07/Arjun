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
	static Node head;
	public static void enqueue(int data)
	{
		Node now=new Node(data);
		if(head==null)
		{
			head=now;
		}
		else
		{
			Node last=head;
			while(last.next!=null)
			{
				last=last.next;
			}
			last.next=now;
		}
		
	}
	public static void dequeue()
	{
		head=head.next;		
	}
	public static void printlist()
	{
		Node print=head;
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
		System.out.println(head.data);
	}
	public static boolean isempty()
	{
		if(head==null)
		{
			return true;
		}
		return false;
	}
	public static int size()
	{
		int count=0;
		Node ctr=head;
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
		Node curr=head;
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
		enqueue(4);
		enqueue(1);
		enqueue(8);
		enqueue(7);
		printlist();
		dequeue();
		printlist();
		peek();
		System.out.println(isempty());
		System.out.println(size());
		enqueue(-21);
		printlist();
		System.out.println(sum());
	}
}
