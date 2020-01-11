package com.bridgelabz.basicprogramming;

import java.util.Random;
import utility.Utility;

public class TicTacToe {
	static char arr[] = { '-', '-', '-', '-', '-', '-', '-', '-', '-' };
	static int check = 0;

	public static void boardDisplay(char arr[]) {// Method to display the game board
		for (int i = 1; i <= 9; i++) {
			System.out.print(arr[i - 1] + " ");
			if (i % 3 == 0 && i != 0)
				System.out.println();
		}
	}

	public static void userPlay(char arr[]) {// Method for user input
		int n;
		System.out.print("Enter the index(1-9):");
		n = Utility.returnInt();// Taking input from user
		arr[n - 1] = 'X';
		boardDisplay(arr);
	}

	public static void cpuPlay(char arr[]) {// Method for CPU input

		int n = 0;
		Random r = new Random();// Taking input from CPU using random function
		int i = 0;
		while (i == 0) {
			n = r.nextInt(9);
			if (arr[n] == '-') {// Checking for unused spaces in the board
				i++;
				arr[n] = 'O';
			}
		}
		System.out.println("CPU plays");
		boardDisplay(arr);
	}

	public static int checkResult(char arr[]) {// Method to check result of the game
		int r = 2;
		check++;
		if ((arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == 'X')
				|| (arr[0] == arr[3] && arr[3] == arr[6] && arr[6] == 'X')// Conditions
				|| (arr[3] == arr[4] && arr[4] == arr[5] && arr[5] == 'X')// for
				|| (arr[1] == arr[4] && arr[4] == arr[7] && arr[7] == 'X')// user
				|| (arr[6] == arr[7] && arr[7] == arr[8] && arr[8] == 'X')// to
				|| (arr[2] == arr[5] && arr[5] == arr[8] && arr[8] == 'X')// win
				|| (arr[0] == arr[4] && arr[4] == arr[8] && arr[8] == 'X')// the game
				|| (arr[2] == arr[4] && arr[4] == arr[6] && arr[6] == 'X')) {
			System.out.println("Winner is user");
			r = 1;
		} else if ((arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == 'O')// Conditions
				|| (arr[0] == arr[3] && arr[3] == arr[6] && arr[6] == 'O')// for
				|| (arr[3] == arr[4] && arr[4] == arr[5] && arr[5] == 'O')// cpu
				|| (arr[1] == arr[4] && arr[4] == arr[7] && arr[7] == 'O')// to
				|| (arr[6] == arr[7] && arr[7] == arr[8] && arr[8] == 'O')// win
				|| (arr[2] == arr[5] && arr[5] == arr[8] && arr[8] == 'O')// the
				|| (arr[0] == arr[4] && arr[4] == arr[8] && arr[8] == 'O')// game
				|| (arr[2] == arr[4] && arr[4] == arr[6] && arr[6] == 'O')) {
			System.out.println("Winner is CPU");
			r = -1;
		} else if (check == 9) {// Condition to declare the match as a draw
			System.out.println("Match Drawn");
		} else
			r = 2;
		return r;
	}

	public static void main(String args[]) {// Main method
		System.out.println("Tic-Tac-Toe");
		boardDisplay(arr);// Calling board display after every turn of play
		int gamecheck = 2;
		while (gamecheck == 2) {
			userPlay(arr);
			System.out.println("-------------------");
			gamecheck = checkResult(arr);// Calling game checking function after every turn of play
			if (gamecheck == 2) {// if statement preventing the extra turn of CPU to play
				cpuPlay(arr);
				System.out.println("-------------------");
				gamecheck = checkResult(arr);
			}

		}
	}

}
