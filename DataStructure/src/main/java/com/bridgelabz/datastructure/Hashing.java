package com.bridgelabz.datastructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Hashing {
	static class Node {
		int data;
		Node next;
	}

	static Node arr[] = new Node[11];

	public static int index(int data) {
		int index = data % 11;
		return index;
	}

	public static void table(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = null;
		int index = index(data);
		if (arr[index] == null) {
			arr[index] = newNode;
		} else {
			int ctr = 0;
			Node follow = arr[index];
			if (arr[index] == null || data < follow.data) {
				newNode.next = arr[index];
				arr[index] = newNode;
			} else {
				Node prev = arr[index];
				while (follow.next != null) {
					if (data > follow.data) {
						prev = follow;
						follow = follow.next;
					}
					if (data < follow.data) {
						ctr = 1;
						prev.next = newNode;
						newNode.next = follow;
						break;
					}
				}
				if (ctr == 0)
					follow.next = newNode;
			}
		}
	}

	public static void search(int data) {
		int ctr = 0;

		for (int i = 0; i < arr.length; i++) {
			Node curr = arr[i];
			Node prev = arr[i];
			if (curr != null && curr.data == data) {
				ctr++;
				arr[i] = curr.next;
				curr = null;
			} else {
				while (curr != null && ctr == 0) {
					if (curr.data == data) {
						ctr++;
						prev.next = curr.next;
						curr = null;
					} else {
						prev = curr;
						curr = curr.next;
					}

				}
			}
		}
		if (ctr == 0) {
			table(data);
		}
	}

	public static void printtable() {
		System.out.println(" Hashing Table as follows");
		for (int i = 0; i < arr.length; i++) {
			Node curr = arr[i];
			while (curr != null) {
				if (curr.next != null)
					System.out.print(curr.data + "----");
				else
					System.out.print(curr.data);
				curr = curr.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		File file = new File("/home/admin1/Desktop/simple1.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String str = br.readLine();
		br.close();
		String st[] = str.split(" ");
		int insert[] = new int[st.length];
		for (int i = 0; i < insert.length; i++) {
			insert[i] = Integer.parseInt(st[i]);
		}
		for (int i = 0; i < insert.length; i++) {
			table(insert[i]);
		}
		printtable();
		System.out.print("Enter a number to search: ");
		int data = utility.Utility.returnInt();
		search(data);
		printtable();
		Node curr;
		File f = new File("/home/admin1/Desktop/simple3.txt");
		FileWriter fw = new FileWriter(f);
		for (int i = 0; i < arr.length; i++) {
			curr = arr[i];
			while (curr != null) {
				if (curr.next != null)
					fw.write(curr.data);
				else
					fw.write(curr.data);
				curr = curr.next;
			}
		}
		fw.close();

	}
}
