package de.docfaust.bb.model;



public class Frame {
	
	public enum RollType {
		STRIKE, SPARE, NUMBER, FOUL, MISS;
	}
	
	private RollType type;
	private int score = 0;
	private int rollIndex = 0;
	
	public RollType getType() {
		return type;
	}
	public void setType(RollType type) {
		this.type = type;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getRollIndex() {
		return rollIndex;
	}
	public void setRollIndex(int rollIndex) {
		this.rollIndex = rollIndex;
	}
}
