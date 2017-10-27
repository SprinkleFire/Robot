package com.robot.entity;

public class Battery {
	private double charge;

	@Override
	public String toString() {
		return "Battery [charge=" + charge + "]";
	}

	public Battery(double charge) {
		super();
		if ((charge < 1) ||(charge > 100)) {
			System.out.println();
			throw new RuntimeException("Provide battery power between 1~100");
		}
		this.charge = charge;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		if (charge < 1 && charge > 100) {
			System.out.println();
			new Throwable("Provide power between 1~100");
		}
		this.charge = charge;
	}

}
