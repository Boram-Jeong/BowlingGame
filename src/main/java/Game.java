public class Game {

	private static int FRAMENUMBER = 10;

	public Frame[] frames = new Frame[FRAMENUMBER];

	private int currentIndex = 0;


	/**
	 * Game class constructor make ten frame beforehand.
	 * Last Frame inherited Frame class. (available three rolls)
	 */
	public Game() {
		int index;
		for (index = 0; index < 9; index++) {
			frames[index] = new Frame();
		}

		frames[index] = new TenthFrame();
	}

	
	/**
	 * Insert roll to frame.
	 * If frame is full, set current frame to next of previous frame. 
	 * @param pins
	 */
	public void roll(int pins) {

		frames[currentIndex].addRoll(pins);
		
		if (frames[currentIndex].isFull()) {
			if (currentIndex != 0) {
				frames[currentIndex - 1].setNextFrame(frames[currentIndex]);
			}
			currentIndex++;

		}

	}

	/**
	 * Get total score of Game.
	 * @return total score of game.
	 */
	public int getScore() {
		int score = 0;

		Frame frame;
		for (int index = 0; index < frames.length; index++) {
			frame = frames[index];
			score += frame.getScore();
			
		}

		return score;
	}

}
