package com.robot;

import com.robot.controller.AttributeInterface;
import com.robot.controller.HealthChecker;
import com.robot.entity.Battery;
import com.robot.entity.Chest;
import com.robot.entity.Head;
import com.robot.entity.Walk;
import com.robot.entity.Weight;
import com.robot.model.Scanner;

public class Robot implements AttributeInterface {
	private Head head;
	private Weight weight;
	private Battery battery;
	private HealthChecker healthChecker;
	private Walk walk;
	private Chest chest;
	private Scanner scanner;

	public Robot(Head head, Weight weight, Battery battery, Chest chest, Walk walk, Scanner scanner) {
		super();
		this.head = head;
		this.weight = weight;
		this.battery = battery;
		this.walk = walk;
		this.chest = chest;
		this.scanner = scanner;
		healthChecker = new HealthChecker(this);
	}

	@Override
	public Head getHead() {
		return this.head;
	}

	@Override
	public Battery getBattery() {
		return this.battery;
	}

	@Override
	public Weight getWeight() {
		return this.weight;
	}

	@Override
	public Chest getChest() {
		return this.chest;
	}

	@Override
	public Walk getWalk() {
		return this.walk;
	}

	@Override
	public Scanner getScanner() {
		return this.scanner;
	}
	public void walk(){
		healthChecker.run();
	}
	public void scan(){
		healthChecker.scan();
	}
}
