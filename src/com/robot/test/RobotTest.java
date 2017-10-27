package com.robot.test;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.robot.Robot;
import com.robot.entity.Battery;
import com.robot.entity.Chest;
import com.robot.entity.Head;
import com.robot.entity.Light;
import com.robot.entity.Walk;
import com.robot.entity.Weight;
import com.robot.model.Scanner;

public class RobotTest {

	Head head = null;
	Weight weight = null;
	Battery battery = null;
	Chest chest = null;
	Walk walk = null;
	Scanner scanner = null;

	@Before
	public void setUp() throws Exception {
		scanner = new Scanner();
		head = new Head();
		chest = new Chest();
		battery = new Battery(100);
		weight = new Weight(0);
		walk = new Walk(0d);
	}

	@After
	public void tearDown() throws Exception {
		scanner = null;
	}

	@Test
	public final void test3_5KM() {
		walk = new Walk(3.5);
		Robot robot = new Robot(head, weight, battery, chest, walk, scanner);
		robot.walk();
		System.out.println("Battery remaing " + battery.toString());
	}

	@Test
	public final void test2KM_3kg() {
		walk = new Walk(2);
		weight = new Weight(3);
		Robot robot = new Robot(head, weight, battery, chest, walk, scanner);
		robot.walk();
		System.out.println("Battery remaing " + battery.toString());
	}

	@Test
	public final void test12kg() {
		weight = new Weight(12);
		Robot robot = new Robot(head, weight, battery, chest, walk, scanner);
		robot.walk();
		System.out.println("Battery remaing " + battery.toString());
	}

	@Test
	public final void test15perBattery() {
		battery = new Battery(14);
		Robot robot = new Robot(head, weight, battery, chest, walk, scanner);
		robot.walk();
		assertEquals(Light.RED, robot.getHead().getLight());
	}

	@Test
	public final void test5kmPerCharge() {
		battery = new Battery(17);
		walk = new Walk(5);
		Robot robot = new Robot(head, weight, battery, chest, walk, scanner);
		robot.walk();
		assertEquals(16, (int) robot.getBattery().getCharge());
	}

	@Test
	public final void testOverWeighted() {
		weight = new Weight(13);
		Robot robot = new Robot(head, weight, battery, chest, walk, scanner);
		robot.walk();
		assertEquals("Overweight", robot.getChest().getStatus());
	}

	@Test
	public final void testScannFail() {
		scanner.setSuccess(false);
		Robot robot = new Robot(head, weight, battery, chest, walk, scanner);
		robot.scan();
		assertEquals("Scan Failure", robot.getChest().getStatus());
	}

}
