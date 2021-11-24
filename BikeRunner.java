package com.in28min.oops;

public class BikeRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bike b1 = new Bike(0);
		Bike b2 = new Bike();
		b1.start();
		b2.start();
		b1.setSpeed(10);
		b2.setSpeed(20);
		System.out.println(b1.getSpeed());

	}

}
