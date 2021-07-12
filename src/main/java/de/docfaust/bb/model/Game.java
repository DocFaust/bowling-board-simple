package de.docfaust.bb.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public List<Frame> getFrames() {
		return frames;
	}

	public void setFrames(List<Frame> frames) {
		this.frames = frames;
	}

	private String playerName;
	private List<Frame> frames = new ArrayList<>(10);

	public Game(String name) {
		this.playerName = name;
	}
}
