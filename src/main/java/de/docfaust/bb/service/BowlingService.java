package de.docfaust.bb.service;

import java.util.ArrayList;
import java.util.List;

import de.docfaust.bb.model.Frame;
import de.docfaust.bb.model.Frame.RollType;
import de.docfaust.bb.model.Game;

public class BowlingService {
	private List<Game> games = new ArrayList<>();

	private int gameIndex;
	private int frameIndex;
	//private short rollIndex;
	
	
	public void addPlayer(String name) {
		games.add(new Game(name));
	}
	
	public void startGame() {
		this.frameIndex = 0;
		this.gameIndex = 0;
	}
	
	public void addRoll(int score) {
		Game currentGame = games.get(gameIndex); 
		Frame currentFrame = currentGame.getFrames().get(frameIndex);
		if(currentFrame == null) {
			currentFrame = new Frame();
		}
		int rollIndex = currentFrame.getRollIndex();

		// 1st roll
		if(rollIndex == 0) {
			if(score == 10) {
				currentFrame.setType(RollType.STRIKE);
			} 
			
			currentFrame.setScore(score);
			currentFrame.setRollIndex(1);
		}
		
		// 2nd roll
		if(rollIndex == 1) {
			currentFrame.setScore(currentFrame.getScore() + score);
			if(currentFrame.getScore() == 10) {
				currentFrame.setType(RollType.SPARE);
				currentFrame.setRollIndex(2);
			} else if(currentFrame.getType()==RollType.STRIKE){
				// 3 rolls in case of Strike
				currentFrame.setRollIndex(2);
			} else {
				// no more rolls
				currentFrame.setRollIndex(-1);
			}
		}

		// 3rd roll
		if(rollIndex == 2) {
			currentFrame.setScore(currentFrame.getScore() + score);
			currentFrame.setRollIndex(-1);
		}
		
		if(currentFrame.getRollIndex() == -1) {
			// change Player
			// gameIndex++
			
			// if(round finished frameIndex++ gamindex = 0)
		}
	}
}
