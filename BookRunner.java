package com.in28min.oops;

public class BookRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1 = new Book();
		Book b2 = new Book();
		Book b3 = new Book();

		b1.start();
		b2.start();
		b3.start();
		b1.setNoOfCopies(10);

	}

}
