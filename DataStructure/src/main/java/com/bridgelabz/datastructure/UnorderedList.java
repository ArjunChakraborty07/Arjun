package com.bridgelabz.datastructure;

public class UnorderedList {
	
	static class Node <T>{
		T data;
		Node next=null;
		Node(T d)
		{
			data=d;
			next=null;
		}
	}
	Node head;
	private static void empty(UnorderedList list)
	{
		list.head=null;	
	}
	public static <T> UnorderedList insert(T data, UnorderedList list)
	{
		Node newNode=new Node(data);
		if(list.head==null)
		{
			list.head=newNode;
		}
		else
		{
			Node last=list.head;
			while(last.next!=null)
			{
				last=last.next;
			}
			last.next=newNode;
		}
		return list;
	}
	public static void printlist(UnorderedList list)
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
	public static <T extends Comparable> boolean search(T data, UnorderedList list)
	{
		Node currNode=list.head;
			while(currNode!=null)
			{
				if(currNode.data.equals(data))
				{
					return true;
				}
				currNode=currNode.next;
			}	
			return false;		
	}
	public static int size(UnorderedList list)
	{
		int ctr=0;
		Node currNode=list.head;
		while(currNode!=null)
		{
			ctr++;
			currNode=currNode.next;
		}	
		return ctr;		
	}
	public static void main(String[] args) {	
	UnorderedList list=new UnorderedList();
	
	empty(list);
	
	printlist(list);
	
	insert('a',list);
	insert(2,list);
	
	
	printlist(list);
	
	insert("Arjun",list);
	
	printlist(list);
	
	boolean b=search(2, list);
	System.out.println(b);
	
	int s=size(list);
	System.out.println(s);
	}
	
}
