package com.robot.entity;

public class Chest {
private String status;


public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "Chest [status=" + status + "]";
}
}
