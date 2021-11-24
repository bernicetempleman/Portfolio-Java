
package com.in28min.oops;

public class Bike {


	private int speed;

	Bike() {
		this(4);// calls other constructor
	}

	Bike(int speed) {
		this.speed = speed;
	}

	void start() {
		System.out.println("started");
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		System.out.println(speed);
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		System.out.println(speed);
		System.out.println(this.speed);
		this.speed = speed;
	}

}
