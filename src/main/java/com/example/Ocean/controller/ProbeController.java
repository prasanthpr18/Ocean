package com.example.Ocean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Ocean.model.Probe;
import com.example.Ocean.service.ProbeService;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/probes")
public class ProbeController {
	private Probe probe;
	private final ProbeService probeService;

	// Define obstacles
	private Set<String> obstacles = new HashSet<>();

	@Autowired
	public ProbeController(ProbeService probeService) {
		this.probeService = probeService;
		// Initialize obstacles (example)
		obstacles.add("1,1");
		obstacles.add("2,2");
	}

	@PostMapping
	public void initializeProbe(@RequestBody Probe initialProbe) {
		this.probe = initialProbe;
	}

	@PostMapping("/move/forward")
	public void moveForward() {
		if (probe != null) {
			probeService.moveForward(probe);
		}
	}

	@PostMapping("/move/backward")
	public void moveBackward() {
		if (probe != null) {
			probeService.moveBackward(probe);
		}
	}

	@PostMapping("/turn/left")
	public void turnLeft() {
		if (probe != null) {
			probeService.turnLeft(probe);
		}
	}

	@PostMapping("/turn/right")
	public void turnRight() {
		if (probe != null) {
			probeService.turnRight(probe);
		}
	}

	@GetMapping("/status")
	public Probe getStatus() {
		return probe;
	}

	@GetMapping("/visited")
	public Set<String> getVisitedCoordinates() {
		return probe != null ? new HashSet<>(probe.getVisitedCoordinates()) : new HashSet<>();
	}
}
