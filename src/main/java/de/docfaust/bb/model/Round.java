package de.docfaust.bb.model;

import java.util.ArrayList;
import java.util.List;

public class Round {
	private int number;

	private List<Score> scores = new ArrayList<>();

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder("Round: ");
		b.append("Number: ").append(number);
		scores.stream().forEach(score -> b.append(score.toString()).append(" "));
		b.append(" ");
		return b.toString();
	}
}
