package com.example.Ocean.model;

import java.util.ArrayList;
import java.util.List;

public class Probe {
	private int x;
	private int y;
	private String direction;
	private List<String> visitedCoordinates;

	public Probe(int x, int y, String direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.visitedCoordinates = new ArrayList<>();
		this.visitedCoordinates.add(x + "," + y); // Add initial position
	}

	// Getters and Setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public List<String> getVisitedCoordinates() {
		return visitedCoordinates;
	}
}
