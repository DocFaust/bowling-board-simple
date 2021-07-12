package de.docfaust.bb.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private String playerName;
	private List<Frame> frames = new ArrayList<>(10);

	public Game(String name) {
		this.playerName = name;
	}
}
