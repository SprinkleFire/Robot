package com.robot.controller;

import com.robot.entity.Battery;
import com.robot.entity.Chest;
import com.robot.entity.Head;
import com.robot.entity.Walk;
import com.robot.entity.Weight;
import com.robot.model.Scanner;

public interface AttributeInterface {
	Head getHead();

	Battery getBattery();

	Weight getWeight();

	Chest getChest();

	Walk getWalk();
	
	Scanner getScanner();
}
