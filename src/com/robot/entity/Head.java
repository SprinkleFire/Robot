package com.robot.entity;

public class Head {
private Light light;

@Override
public String toString() {
	return "Head [light=" + light + "]";
}

public Light getLight() {
	return light;
}

public void setLight(Light light) {
	this.light = light;
}
}
