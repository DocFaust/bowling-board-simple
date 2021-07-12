package de.docfaust.bb.util;

import java.util.List;

import org.slf4j.LoggerFactory;

import de.docfaust.bb.model.Round;
import de.docfaust.bb.model.ScoreBoard;

public class PrintScoreBoard {
	public static void printScoreBoard(ScoreBoard board) {
		List<Round> rounds = board.getRounds();
		
		rounds.stream().forEach((round) -> LoggerFactory.getLogger(PrintScoreBoard.class).info(null));
	}
}
