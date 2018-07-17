package com.cg;

import java.util.Scanner;

public class ArrayProgram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n;
		int sum = 0;
		int prod = 1;
		System.out.println("Enter the size of the array");
		n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter the elements in the array:\n");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < n / 2; i++) {
			sum = sum + arr[i];
		}
		if (n % 2 == 0) {
			for (int i = arr.length / 2; i < n; i++) {
				prod = prod * arr[i];
			}
		} else if (n % 2 != 0) {
			for (int i = (arr.length / 2) + 1; i < n; i++) {
				prod = prod * arr[i];
			}
		}
		System.out.println("The sum of first half of elements:\n" + sum);
		System.out.println("The product of second half of elements:\n" + prod);
		int result = sum + prod;
		System.out.println("Result of the array:\n" + result);
	}

}
