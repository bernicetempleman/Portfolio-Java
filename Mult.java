package com.in28.FirstJavaProject;

public class Mult {

	void print(int table) {
		print(table, 1, 10);
	}

	void print() {
		print(5);
	}

	void print(int table, int from, int to) {
		for (int i=from; i<=to;i++) {
			System.out.printf("%d * %d = %d", table , i ,  table *i);
			System.out.println();
		}
	}
}
