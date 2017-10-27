package com.robot;

import com.robot.entity.Battery;
import com.robot.entity.Chest;
import com.robot.entity.Head;
import com.robot.entity.Walk;
import com.robot.entity.Weight;
import com.robot.model.Scanner;

public class Launcher {
public static void main(String ...strings ){
	Head head = null;
	Weight weight=null;
	Battery battery=null;
	Chest chest=null;
	Walk walk=null;
	Scanner scanner=null;
	scanner=new Scanner();
	head=new Head();
	weight= new Weight(3);
	battery= new Battery(15);
	chest = new Chest();
	walk = new Walk(0);
	//scanner=new Scanner();
	Robot robot = new Robot(head, weight, battery, chest, walk, scanner);
	robot.walk();
	System.out.println("Battery remaing " + battery.toString());
	robot.scan();
}
}
