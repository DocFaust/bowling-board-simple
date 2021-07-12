package de.docfaust.bb.model;

public class Score {
	private Player player;
	private int score;
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder("Score: ");
		b.append("Name: ").append(player.getName()).append("; ");
		b.append("score: ").append(score);
		return b.toString();
	}
}
