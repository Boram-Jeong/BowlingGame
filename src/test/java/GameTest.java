import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class GameTest {
	
	Game game;

	@Before
	public void setUp() throws Exception {
		game = new Game();
	}


	@Test
	public void allGutterGame() {
	
		for(int frameIndex = 0; frameIndex < 20; frameIndex++){
			game.roll(0);
			
			
		}
		
		assertEquals(0, game.getScore());
		

	}
	
	@Test
	public void perfectGame() {

		for(int frameIndex = 0; frameIndex < 20; frameIndex++){
			game.roll(1);
			
			
		}
		
		assertEquals(20, game.getScore());

	}
	
	@Test
	public void oneSpareGame() {
		game.roll(5);
		game.roll(5);
		game.roll(3);
		
		for(int frameIndex = 0; frameIndex < 17; frameIndex++){
			game.roll(0);
			
			
		}

		assertEquals(16, game.getScore());

	}
	
	@Test
	public void oneStrikeGame() {
		game.roll(10);
		game.roll(3);
		game.roll(4);
		
		for(int frameIndex = 0; frameIndex < 16; frameIndex++){
			game.roll(0);
			
			
		}

		assertEquals(24, game.getScore());

	}
	
	@Test
	public void testPerfectGame() {
		for(int frameIndex = 0; frameIndex < 12; frameIndex++){
			game.roll(10);

		}
		
		assertEquals(300, game.getScore());
	}

	

}
