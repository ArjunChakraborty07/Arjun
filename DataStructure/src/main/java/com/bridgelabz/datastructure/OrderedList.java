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
		int pos=index(data,list);
		Node follow=list.head;
		Node previous=null;
		if(pos==0)
		{			
			list.head=follow.next;
			follow=null;
		}
		else
		{
			int ctr=0;		
			
			while(ctr!=pos)
			{
				previous=follow;
				follow=follow.next;
				ctr++;
			}
			previous.next=follow.next;	
			follow=null;
		}
	}
	public static int index(int data, OrderedList list)
	{	int ctr=0;
		Node currNode=list.head;
		while(currNode!=null)
		{
			if(currNode.data==data)
			{
				return ctr;
			}
			ctr++;
			currNode=currNode.next;
		}	
		return -1;		
	}
	public static boolean search(int data, OrderedList list)
	{
		boolean b=false;
		Node curr=list.head;
		while(curr!=null)
		{
			
			if(curr.data==data)
			{
				b=true;
				return b;		
			}
			else
			{
				curr=curr.next;
			}			
		}
		return b;
	}
	public static boolean isempty(OrderedList list)
	{
		if(list.head==null)
		{
			return true;
		}
		return false;
		
	}
	public static int size(OrderedList list)
	{
		int size=0;
		Node curr=list.head;
		while(curr!=null)
		{
			curr=curr.next;
			size++;
		}
		return size;
	}
	public static void pop(OrderedList list)
	{
		Node behind=null;
		Node curr=list.head;
		while(curr.next!=null)
		{
			behind=curr;
			curr=curr.next;
		}
		behind.next=null;
		curr=null;
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
		remove(5,list);
		boolean b=search(9,list);
		System.out.println(b);
		printlist(list);
		System.out.println(isempty(list));
		System.out.println(size(list));
		pop(list);
		printlist(list);
		System.out.println(isempty(list));
	}
}
