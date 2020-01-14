package com.bridgelabz.datastructure;

public class OrderedList {
	static class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data=d;
			next=null;
		}
	}
	Node head;
	private static void empty(OrderedList list)
	{
		list.head=null;	
	}
	public static void add(int data, OrderedList list )
	{
		Node newNode=new Node(data);
		Node follow=list.head;
		if(list.head==null||data<follow.data )
		{
			newNode.next=list.head;
			list.head=newNode;
		}		
		else
		{						
			while(follow.next!=null )
			{			
					if(data>follow.data)			
					{
						follow=follow.next;
					}
			}	
			follow.next=newNode;			
		}			
	}
	public static void remove(int data, OrderedList list)
	{
		Node currNode=list.head;
		Node follow=null;
		while(currNode.data!=data)
		{
			if(currNode.data<data)
			{
				follow=currNode;			
				currNode=currNode.next;
			}
		}
		currNode.next=follow.next;
		follow=null;
	}
	public static void printlist(OrderedList list)
	{		
		Node currNode=list.head;
		System.out.print("Linkedlist: ");
		if(currNode==null)
		{
			System.out.println("No element to show");
		}
		else
		{
			while(currNode!=null)
			{
				System.out.print(currNode.data+" ");
				currNode=currNode.next;
			}	
			System.out.println();
		}
	}

	public static void main(String args[])
	{
		OrderedList list=new OrderedList();
		add(5,list);
		printlist(list);
		add(4,list);
		printlist(list);
		add(6,list);
		printlist(list);
		add(2,list);
		add(8,list);
		add(7,list);
		printlist(list);
		remove(2,list);
	}
}
