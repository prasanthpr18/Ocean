package com.example.Ocean.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.Ocean.model.Probe;

@Service
public class ProbeService {
	private static final String[] DIRECTIONS = { "N", "E", "S", "W" };
	private static final int[][] MOVES = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // N, E, S, W

	private Set<String> obstacles;

	public ProbeService(Set<String> obstacles) {
		this.obstacles = obstacles;
	}

	public void moveForward(Probe probe) {
		int directionIndex = getDirectionIndex(probe.getDirection());
		int newX = probe.getX() + MOVES[directionIndex][0];
		int newY = probe.getY() + MOVES[directionIndex][1];
		if (isValidMove(newX, newY)) {
			probe.setX(newX);
			probe.setY(newY);
			probe.getVisitedCoordinates().add(newX + "," + newY);
		}
	}

	public void moveBackward(Probe probe) {
		int directionIndex = getDirectionIndex(probe.getDirection());
		int newX = probe.getX() - MOVES[directionIndex][0];
		int newY = probe.getY() - MOVES[directionIndex][1];
		if (isValidMove(newX, newY)) {
			probe.setX(newX);
			probe.setY(newY);
			probe.getVisitedCoordinates().add(newX + "," + newY);
		}
	}

	public void turnLeft(Probe probe) {
		int directionIndex = getDirectionIndex(probe.getDirection());
		probe.setDirection(DIRECTIONS[(directionIndex + 3) % 4]); // Turn left
	}

	public void turnRight(Probe probe) {
		int directionIndex = getDirectionIndex(probe.getDirection());
		probe.setDirection(DIRECTIONS[(directionIndex + 1) % 4]); // Turn right
	}

	private int getDirectionIndex(String direction) {
		for (int i = 0; i < DIRECTIONS.length; i++) {
			if (DIRECTIONS[i].equals(direction)) {
				return i;
			}
		}
		return -1; // Invalid direction
	}

	private boolean isValidMove(int x, int y) {
		return !obstacles.contains(x + "," + y); // Check for obstacles
	}
}
