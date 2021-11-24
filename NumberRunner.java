package com.in28min.oops;

public class NumberRunner {

	public static void main(String[] args) {
		// TODO Aut=o-generated method stub

		// intergers

		// wrapper= BYTE
		System.out.printf("Byte.SIZE=%d\n Byte.BYTES=%d\n Byte.BYTES=%d\n MIN_VALUE%d\n", Byte.SIZE, Byte.BYTES,
				Byte.MAX_VALUE, Byte.MIN_VALUE);

		// octal 0=7 begin with 0
		int eight = 060;
		// hex 0x 0=F
		int sixteen = 0x10;

		BiNumber numbers = new BiNumber(2, 3);
		System.out.println(numbers.add());
		System.out.println(numbers.multiply());
		numbers.doublenum();
		System.out.println(numbers.getNumber1());
		System.out.println(numbers.getNumber2());

	}

	private static Object multiply() {
		// TODO Auto-generated method stub
		return null;
	}

}
