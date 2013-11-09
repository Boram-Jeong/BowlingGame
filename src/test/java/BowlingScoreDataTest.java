import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BowlingScoreDataTest {
	
	private Game game;
	int [] gameData;
	int [] score;

	@Parameters
	public static ArrayList<int[][]> data() {
		ArrayList<int[][]> bowlingGames = new ArrayList<int[][]>();
		int[][][] data = {
				{{ 10, 1, 8, 10, 10, 4, 4, 10, 5, 2, 1, 1, 1, 5, 4, 4 }, { 118 }},
				{{ 0, 1, 8, 2, 9, 0, 5, 4, 0, 9, 8, 0, 9, 0, 0, 6, 4, 2, 2, 3 }, { 81 }},
				{{ 1, 4, 10, 8, 2, 6, 3, 10, 4, 2, 0, 4, 9, 1, 1, 9, 8, 1 }, { 114 }}};

		// set Data here
		bowlingGames.add(data[0]);
		bowlingGames.add(data[1]);
		bowlingGames.add(data[2]);
		return bowlingGames;
	}
	
	public BowlingScoreDataTest(int[] gameData, int[] score){
		super();
		this.gameData = gameData;
		this.score = score;
	}
	
	@Before
	public void setUp() throws Exception {
		game = new Game();
	}
	
	@Test
	public void shouldGetScore() {
		int dataIndex = 0;
		
		for(int index = 0; index < gameData.length; index++){
			game.roll(gameData[dataIndex++]);

		}
		
		assertEquals(score[0], game.getScore());
		
	}





	
	public Frame newFrame(Roll ...rolls){
		
		Frame frame = new Frame();
		
		for(int rollIndex = 0; rollIndex < rolls.length; rollIndex++){
			frame.rolls.add(rolls[rollIndex]);
		}
		
		return frame;
	}
	
	public Roll newRoll(int pins){
		Roll roll = new Roll();
		roll.setPins(pins);
		
		return roll;
	}

}
