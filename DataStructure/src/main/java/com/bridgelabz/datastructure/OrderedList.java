package com.bridgelabz.datastructure;
import java.io.*;
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
	static Node head;
	private static void empty()
	{
		head=null;	
	}
	public static void add(int data )
	{
		int ctr=0;
		Node newNode=new Node(data);
		Node follow=head;
		if(head==null||data<follow.data)
		{
			newNode.next=head;
			head=newNode;
		}		
		else
		{						
			Node prev=head;
			while(follow.next!=null )
			{			
					if(data>follow.data)			
					{
						prev=follow;
						follow=follow.next;
					}
					if(data<follow.data)
					{
						ctr=1;
						prev.next=newNode;
						newNode.next=follow;
						break;
					}
			}	
			if(ctr==0)
			follow.next=newNode;			
		}			
	}
	public static void remove(int data)
	{
		int pos=index(data);
		Node follow=head;
		Node previous=null;
		if(pos==0)
		{			
			head=follow.next;
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
	public static int index(int data)
	{	int ctr=0;
		Node currNode=head;
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
	public static boolean search(int data)
	{
		boolean b=false;
		Node curr=head;
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
		int size=0;
		Node curr=head;
		while(curr!=null)
		{
			curr=curr.next;
			size++;
		}
		return size;
	}
	public static void pop()
	{
		Node behind=null;
		Node curr=head;
		while(curr.next!=null)
		{
			behind=curr;
			curr=curr.next;
		}
		behind.next=null;
		curr=null;
	}
	public static void popPos(int pos)
	{
		Node curr=head;
		Node follow=null;
		
		if(pos==1)
		{
			head=curr.next;
			curr=null;
		}
		else
		{
			int ctr=0;
			while(ctr!=pos-1)
			{
				ctr++;
				follow=curr;
				curr=curr.next;	
			}
			follow.next=curr.next;
			curr=null;
		}
	}
	public static void printlist()
	{		
		Node currNode=head;
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

	public static void main(String args[]) throws IOException
	{
		empty();
		add(5);
		printlist();
		add(4);
		printlist();
		popPos(1);
		remove(5);
		printlist();
		add(23);
		printlist();
		boolean b=search(9);
		System.out.println(b);
		printlist();
		
		System.out.println(isempty());
		System.out.println(size());
		//System.out.println(head.data);
		//pop();
		
		printlist();
		
		
		
		add(12);
		
		add(1);
		add(15);
		printlist();
		add(14);
		System.out.println("Print something");
		printlist();
		
		add(2);
		
		add(8);
		add(32);
		add(71);
		
		add(11);
		add(19);
	
		printlist();
		System.out.println(isempty());
		
		Node currNode=head;
		File f=new File("/home/admin1/Desktop/simple1.txt");
		FileWriter fw=new FileWriter(f);
		while(currNode!=null)
		{
			fw.write(currNode.data+" ");
			currNode=currNode.next;
		}	
		fw.close();	
	}
}