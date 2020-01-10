package com.bridgelabz.basicprogramming;

import java.util.Random;
import utility.Utility;

public class TicTacToe {
	static char arr[] = { '-', '-', '-', '-', '-', '-', '-', '-', '-' };
	static int check = 0;

	public static void boardDisplay(char arr[]) {
		for (int i = 1; i <= 9; i++) {
			System.out.print(arr[i - 1] + " ");
			if (i % 3 == 0 && i != 0)
				System.out.println();
		}
	}

	public static void userPlay(char arr[]) {
		int n;
		System.out.print("Enter the index(1-9):");
		n = Utility.returnInt();
		arr[n - 1] = 'X';
		boardDisplay(arr);
	}

	public static void cpuPlay(char arr[]) {

		int n = 0;
		Random r = new Random();
		int i = 0;
		while (i == 0) {
			n = r.nextInt(9);
			if (arr[n] == '-') {
				i++;
				arr[n] = 'O';
			}
		}
		System.out.println("CPU plays");
		boardDisplay(arr);
	}

	public static int checkResult(char arr[]) {
		int r = 2;
		check++;
		if ((arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == 'X')
				|| (arr[0] == arr[3] && arr[3] == arr[6] && arr[6] == 'X')
				|| (arr[3] == arr[4] && arr[4] == arr[5] && arr[5] == 'X')
				|| (arr[1] == arr[4] && arr[4] == arr[7] && arr[7] == 'X')
				|| (arr[6] == arr[7] && arr[7] == arr[8] && arr[8] == 'X')
				|| (arr[2] == arr[5] && arr[5] == arr[8] && arr[8] == 'X')
				|| (arr[0] == arr[4] && arr[4] == arr[8] && arr[8] == 'X')
				|| (arr[2] == arr[4] && arr[4] == arr[6] && arr[6] == 'X')) {
			System.out.println("Winner is user");
			r = 1;
		} else if ((arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == 'O')
				|| (arr[0] == arr[3] && arr[3] == arr[6] && arr[6] == 'O')
				|| (arr[3] == arr[4] && arr[4] == arr[5] && arr[5] == 'O')
				|| (arr[1] == arr[4] && arr[4] == arr[7] && arr[7] == 'O')
				|| (arr[6] == arr[7] && arr[7] == arr[8] && arr[8] == 'O')
				|| (arr[2] == arr[5] && arr[5] == arr[8] && arr[8] == 'O')
				|| (arr[0] == arr[4] && arr[4] == arr[8] && arr[8] == 'O')
				|| (arr[2] == arr[4] && arr[4] == arr[6] && arr[6] == 'O')) {
			System.out.println("Winner is CPU");
			r = -1;
		} else if (check == 9) {
			System.out.println("Match Drawn");
		} else
			r = 2;
		return r;
	}

	public static void main(String args[]) {
		System.out.println("Tic-Tac-Toe");
		boardDisplay(arr);
		int gamecheck = 2;
		while (gamecheck == 2) {
			userPlay(arr);
			System.out.println("-------------------");
			gamecheck = checkResult(arr);
			if (gamecheck == 2) {
				cpuPlay(arr);
				System.out.println("-------------------");
				gamecheck = checkResult(arr);
			}

		}
	}

}
