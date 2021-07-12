package de.docfaust.bb.service;

import java.util.List;

import de.docfaust.bb.model.Player;
import de.docfaust.bb.model.ScoreBoard;

public interface GameService {
	public void addPlayer(Player player) throws GameProgressException;
	public List<Player> getPlayers();
	
	public void startGame() throws GameProgressException;
	public void endGame() throws GameProgressException;
	
	public ScoreBoard getScoreBoard();
	
	public Player getCurrentPlayer();
	public void setScoreForCurrentPlayer(int score);
	
}
