package com.bridgelabz.datastructure;

import java.io.*;
import java.util.Scanner;
public class UnorderedList {
	
	static class Node <T>{
		T data;
		Node<T> next=null;
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
	public static <T> UnorderedList insert(T data, UnorderedList list )
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
	public static <T extends Comparable<? super T>> boolean search(T data, UnorderedList list )
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
	public static<T> int index(T data, UnorderedList list)
	{	int ctr=0;
		Node currNode=list.head;
		while(currNode!=null)
		{
			if(currNode.data.equals(data))
			{
				return ctr;
			}
			ctr++;
			currNode=currNode.next;
		}	
		return -1;		
	}
	public static <T> UnorderedList insertpos(T data,int pos, UnorderedList list )
	{
		int ctr=0;
		Node follow=list.head;
		Node newNode=new Node(data);
		
			if(pos==0)
			{	
				newNode.next=list.head;
				list.head=newNode;
			}
			else
			{
				while(ctr!=pos-1)
				{
					follow=follow.next;
					ctr++;
				}
				newNode.next=follow.next;
				follow.next=newNode;
			}
		
		return list;
	}
	public static void pop( UnorderedList list)
	{
		Node follow=list.head;
		Node previous=null;
		while(follow.next!=null)
		{
			previous=follow;
			follow=follow.next;
		}
		previous.next=null;	
		follow=null;
	}
	public static void popPos(int pos, UnorderedList list)
	{
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
	public static <T extends Comparable<? super T>> void check(T data, UnorderedList list)
	{
		boolean b;
		
		b=search(data,list);
		if(b==true)
		{
			int n=index(data,list);
			popPos(n,list);
		}
		else
		{
			insert(data,list);
		}
	}
	public static <T extends Comparable< ? super T>> void main(String[] args) throws IOException  {	
	
		
		UnorderedList list=new UnorderedList();
		T var;
		File file=new File("/home/admin1/Desktop/simple.txt");
		BufferedReader br=new BufferedReader(new FileReader(file));
		String str= br.readLine();
		String arr[]=str.split(" ");
		
		for(int i=0;i<arr.length;i++)
		{
			insert(arr[i], list);
		}
		System.out.print(" Enter an element: ");
		var=(T) utility.Utility.returnString();
		Node currNode=list.head;
		printlist(list);
		
		System.out.println(size(list));
		popPos(4,list);
		printlist(list);
		File f=new File("/home/admin1/Desktop/simple2.txt");
		FileWriter fw=new FileWriter(f);
		while(currNode!=null)
		{
			fw.write((String)currNode.data+" ");
			currNode=currNode.next;
		}	
		fw.close();
	}
	
}
