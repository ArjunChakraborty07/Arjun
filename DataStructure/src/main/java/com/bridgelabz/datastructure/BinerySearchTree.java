package com.bridgelabz.datastructure;

public class BinerySearchTree {
	static class Node{
		int data;
		Node left,right,next;
		Node(int d)
		{
			data=d;
			left=right=next=null;
		}
	}
	static Node head;

	public static void insert(int data)
	{
		Node newNode=new Node(data);
		if(head==null)
		{
			head=newNode;
		}
		else
		{
			Node curr=head;
			while(curr!=null)
			{
				if(data>curr.data)
				{
					curr.right=newNode;
				}
				if(data<curr.data)
				{
					curr.left=newNode;
				}
				curr=curr.next;
			}
		}
	}
	public static void printtree()
	{
		Node curr=head;
		while(curr!=null)
		{
			if(curr.right!=null)
			{
				System.out.print("  "+curr.right.data);
			}
			if(curr.left!=null)
			{
				System.out.println(curr.left.data+"  ");
			}
			if(curr.next!=null)
			System.out.println("\n");
			curr=curr.next;
		}
	}
	public static void main(String[] args) {
		
	}
}
