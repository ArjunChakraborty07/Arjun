package com.bridgelabz.datastructure;

import utility.Utility;

public class Stack {
	static class Node<T> {
		T data;
		Node next;
	}

	static Node top;

	public static <T> void push(T data) {
		Node now = new Node();
		now.data = data;
		now.next = null;
		if (top == null) {
			top = now;

		} else {

			now.next = top;
			top = now;
		}
	}
	public static <T> Object pop() {

		T pop = (T) top.data;
		top = top.next;

		return pop;

	}

	public static <T> Object peek() {

		return top.data;

	}
	public static void show() {

		Node now = top;
		while (now != null) {
			System.out.println(now.data);
			now = now.next;
		}
	}
	public static <T> boolean checkBalanced(char[] arr) {
		boolean flag = false;
		for (int i=0;i<arr.length;i++) {

			if ((arr[i] == '[') || (arr[i] == '{') || (arr[i] == '(')) {
				push(arr[i]);
			}

			else if (arr[i] == ']') {
				T result = (T) pop();

				if (result.equals('[')) {
					flag = true;
				}
			}

			else if (arr[i] == '}') {
				T result = (T) pop();

				if (result.equals('{')) {
					flag = true;
				}
			}

			else if (arr[i] == ')') {
				T result = (T) pop();

				if (result.equals('(')) {
					flag = true;
				}
			}

		}
		return flag;
	}


	public static void main(String[] args) {

		Stack stack = new Stack();

		System.out.print("Enter an equation:");
		String equation = Utility.returnString();
		char[] equationArray = equation.toCharArray();

		boolean balanced = checkBalanced(equationArray);
		System.out.println(balanced);
	}
}
