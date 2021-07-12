package de.docfaust.bb.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.docfaust.bb.model.Player;
import de.docfaust.bb.model.Round;
import de.docfaust.bb.model.Score;
import de.docfaust.bb.model.ScoreBoard;

public class GameServiceImpl implements GameService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	private ScoreBoard scoreBoard;
	private List<Player> players = new ArrayList<>();
	private boolean gameInProgress = false;

	private int currentPlayerIndex;
	private Round currentRound = null;

	@Override
	public void addPlayer(Player player) throws GameProgressException {
		logger.debug("Adding Player: " + player.getName());
		if (!gameInProgress) {
			players.add(player);
		} else {
			throw new GameProgressException("Game is in progress");
		}
	}

	@Override
	public List<Player> getPlayers() {
		return players;
	}

	@Override
	public void startGame() throws GameProgressException {
		if (!gameInProgress) {
			logger.debug("Starting Game");
			this.scoreBoard = new ScoreBoard();
			this.currentRound = new Round();
			this.currentRound.setNumber(1);
			this.currentPlayerIndex = 0;
			gameInProgress = true;
		} else {
			throw new GameProgressException("Game is in progress");
		}
	}

	@Override
	public void endGame() throws GameProgressException {
		if (gameInProgress) {
			logger.debug("Ending Game");
			this.scoreBoard = null;
			this.players = new ArrayList<>();
			gameInProgress = false;
		} else {
			throw new GameProgressException("No game is in progress");
		}
	}

	@Override
	public ScoreBoard getScoreBoard() {
		return this.scoreBoard;
	}

	@Override
	public Player getCurrentPlayer() {
		Player currentPlayer = players.get(currentPlayerIndex);
		logger.debug("CurrentPlayer: " + currentPlayer.getName());
		return currentPlayer;
	}

	@Override
	public void setScoreForCurrentPlayer(int score) {
		Score scoreObj = new Score();
		Player player = getCurrentPlayer();
		scoreObj.setPlayer(player);
		scoreObj.setScore(score);

		logger.debug("Setting Score: " + scoreObj.toString());
		currentRound.getScores().add(scoreObj);

		this.currentPlayerIndex++;
		if (this.currentPlayerIndex >= players.size()) {
			endRound();
		}
		logger.debug("NextPlayer: " + getCurrentPlayer().getName());
	}

	private void endRound() {
		this.scoreBoard.getRounds().add(currentRound);
		
		int nextRoundNumber = this.currentRound.getNumber() + 1;
		currentRound = new Round();
		currentRound.setNumber(nextRoundNumber);
		
		currentPlayerIndex = 0;
	}
}
