package de.docfaust.bb.service;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import de.docfaust.bb.model.Player;
import de.docfaust.bb.util.PrintScoreBoard;

import static org.assertj.core.api.Assertions.*;

class GameServiceTest {

	@Test
	void testAdd4Player() {
		GameService service = new GameServiceImpl();
		try {
			Player player = new Player("Fritz");
			Player player2 = new Player("Alfred");
			Player player3 = new Player("Sepp");
			Player player4 = new Player("Homer");
			
			service.addPlayer(player);
			service.addPlayer(player2);
			service.addPlayer(player3);
			service.addPlayer(player4);
			
			assertThat(service.getPlayers())
				.hasSize(4)
				.contains(
					player,
					player2,
					player3,
					player4);
		} catch (GameProgressException e) {
			fail("should be possible");
		}
	}
	
	@Test
	void testGamePlay() {
		GameService service = new GameServiceImpl();
		try {
			Player player = new Player("Fritz");
			Player player2 = new Player("Alfred");
			Player player3 = new Player("Sepp");
			Player player4 = new Player("Homer");
			
			service.addPlayer(player);
			service.addPlayer(player2);
			service.addPlayer(player3);
			service.addPlayer(player4);

			service.startGame();
			
			assertThat(service.getCurrentPlayer()).isEqualTo(player);
			service.setScoreForCurrentPlayer(10);
			assertThat(service.getCurrentPlayer()).isEqualTo(player2);
			service.setScoreForCurrentPlayer(20);
			assertThat(service.getCurrentPlayer()).isEqualTo(player3);
			service.setScoreForCurrentPlayer(30);
			assertThat(service.getCurrentPlayer()).isEqualTo(player4);
			service.setScoreForCurrentPlayer(40);
			assertThat(service.getCurrentPlayer()).isEqualTo(player);
			
			PrintScoreBoard.printScoreBoard(service.getScoreBoard());
			
		} catch (GameProgressException e) {
			fail("should be possible");
		}
	}
	
	@Test
	void testAddPlayerAfterGameStarted() {
		GameService service = new GameServiceImpl();
		try {
			service.addPlayer(new Player("Fritz"));
			service.startGame();
			service.addPlayer(new Player("Sepp"));
			fail("There should be an exception");
		} catch (GameProgressException e) {
			// This is fine
		}
	}
}
