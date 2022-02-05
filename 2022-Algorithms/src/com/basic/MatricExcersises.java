package com.basic;

import java.util.Scanner;

public class MatricExcersises {

	static int n, m, matrix[][];

	public static void inputMatrix() {
		Scanner input = new Scanner(System.in);
		System.out.println("input number of row: ");
		n = input.nextInt();
		System.out.println("input number of col: ");
		m = input.nextInt();
		matrix = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print("  a[" + i + "," + j + "]=");
				matrix[i][j] = input.nextInt();
			}
			System.out.println();
		}
	}

	public static void outputMatrix() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		inputMatrix();
		outputMatrix();
	}
}
