package com.bridgelabz.json;

import java.util.Random;

public class DeckOfCards {
	static class Node {
		String data;
		Node next;

		Node(String d) {
			data = d;
			next = null;
		}
	}

	static Node players[] = new Node[4];

	static String cards[] = { "S-2", "S-3", "S-4", "S-5", "S-6", "S-7", "S-8", "S-9", "S-10", "S-J", "S-Q", "S-K",
			"S-A", "H-2", "H-3", "H-4", "H-5", "H-6", "H-7", "H-8", "H-9", "H-10", "H-J", "H-Q", "H-K", "H-A", "C-2",
			"C-3", "C-4", "C-5", "C-6", "C-7", "C-8", "C-9", "C-10", "C-J", "C-Q", "C-K", "C-A", "D-2", "D-3", "D-4",
			"D-5", "D-6", "D-7", "D-8", "D-9", "D-10", "D-J", "D-Q", "D-K", "D-A" };

	public static String[][] td() {
		int t = 0;
		String deck[][] = new String[4][13];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				deck[i][j] = cards[t];
				t++;
			}
		}
		return deck;
	}

	public static void shuffle(String deck[][]) {
		Random r = new Random();

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				int row = r.nextInt(4);
				int column = r.nextInt(13);
				String a = deck[row][column];
				String b = deck[i][j];

				deck[row][column] = b;
				deck[i][j] = a;
			}
		}
	}

	public static void distribution(String deck[][]) {
		for (int i = 0; i < 4; i++) {
			Node newcard = new Node(deck[i][0]);
			players[i] = newcard;
			for (int j = 1; j < 9; j++) {
				newcard = new Node(deck[i][j]);
				Node follow = players[i];
				{
					while (follow.next != null) {
						follow = follow.next;
					}
					follow.next = newcard;
				}
			}
		}
	}

	public static void sort(int i) {
		i = i - 1;
		Node curr = players[i];
		while (curr != null) {
			Node check = players[i].next;
			while (check != null) {
				if (curr.data.compareTo(check.data) < 0) {
					String tmp = curr.data;
					curr.data = check.data;
					check.data = tmp;
				}
				check = check.next;
			}
			curr = curr.next;
		}
		Node last = new Node(players[i].data);
		players[i] = players[i].next;
		curr = players[i];
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = last;

	}

	public static void display() {
		for (int i = 0; i < 4; i++) {
			Node curr = players[i];
			while (curr != null) {
				System.out.print(curr.data + " ");
				curr = curr.next;
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		String deck[][] = td();
		shuffle(deck);
		for (int i = 0; i < deck.length; i++) {
			for (int j = 0; j < deck[0].length; j++) {
				System.out.print(deck[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\n");
		distribution(deck);
		display();
		System.out.println();
		sort(1);
		sort(2);
		sort(3);
		sort(4);
		display();
	}
}
