package com.robot.controller;

import com.robot.Robot;
import com.robot.entity.Battery;
import com.robot.entity.Chest;
import com.robot.entity.Head;
import com.robot.entity.Light;
import com.robot.entity.Walk;
import com.robot.entity.Weight;
import com.robot.model.Scanner;

public class HealthChecker {

	private Robot robot;
	private Weight weight;
	private Battery battery;
	private Head head;
	private Chest chest;
	private Walk walk;
	private Scanner scanner;

	public HealthChecker(Robot robot) {
		this.robot = robot;
		weight = robot.getWeight();
		battery = robot.getBattery();
		head = robot.getHead();
		chest = robot.getChest();
		walk = robot.getWalk();
		scanner = robot.getScanner();
	}

	public boolean isOverWeight() {
		if (null != weight && weight.getWeight() > 10) {
			chest.setStatus("Overweight");
			System.out.println(chest.toString());
			return true;
		} else
			return false;
	}

	public boolean isLowBattery() {
		if (null != battery && battery.getCharge() < 15) {
			head.setLight(Light.RED);
			System.out.println("Robot battery is low");
			System.out.println(head.toString());
			return true;
		} else {
			head.setLight(Light.GREEN);
			System.out.println("Robot has sufficient battery");
			System.out.println(head.toString());
			return false;
		}
	}

	public boolean canWalk() {
		// Robot works on battery and can walk for 5 km per charge.
		if (null != walk && (battery.getCharge() < (walk.getKm() / 5))) {
			System.out.println("Robot can't walk");
			return true;
		} else {
			System.out.println("Robot can walk");
			return false;
		}
	}

	public void run() {
		isLowBattery();
		double reuiredBattery = (walk.getKm() / 5);
		if (!isOverWeight()) {
			// 20 % extra battery will consume
			reuiredBattery = (reuiredBattery + 0.02 * weight.getWeight() * battery.getCharge());
			//System.out.println("Battery Consumed for weight lifting " + reuiredBattery);
		} else {
			System.out.println("Robot can't walk, Overweighted");
			return;
		}
		if (reuiredBattery < battery.getCharge()) {
			System.out.println("Robot covered Distance " + walk.getKm());
			System.out.println("Robot lifted weight " + weight.getWeight());
			battery.setCharge(battery.getCharge() - reuiredBattery);
		}
		isLowBattery();
	}

	public void scan() {
		// scanning operation from api result will send to Chest LED.
		if (null != scanner && !scanner.isSuccess()) {
			chest.setStatus("Scanned Sccess");
		} else {
			chest.setStatus("Scan Failure");
		}
		System.out.println(chest.toString());
	}

}
