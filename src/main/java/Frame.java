import java.util.ArrayList;

public class Frame {

	
	/**
	 * @author boram.jeong
	 * Class to calculate score of frame. 
	 */
	
	
	protected static int MAXPIN = 10;
	protected int MAX_ROLL = 2;
	private Frame nextFrame;
	private boolean fulled = false;



	public ArrayList<Roll> rolls = new ArrayList<Roll>();

	/**
	 * @return first score of current frame.
	 */
	public int getFrameFirstScore() {
		if(rolls.get(0) == null)
			return 0;
		
		return rolls.get(0).getPins();
	}

	/**
	 * 
	 * @return second score of current frame.
	 */
	public int getFrameSecondScore() {
		if(rolls.get(1) == null)
			return 0;

		return rolls.get(1).getPins();
	}
	
	/**
	 * calculate score included bonus score of current frame.
	 * @return sum of frame score
	 */
	public int getScore() {
		int frameScore = 0;

		if (isStrike()) {
			
			frameScore += MAXPIN + strikeAdditionalScore();
		} else if (isSpare()) {
			frameScore += MAXPIN + spareAdditionalScore();
		} else {
			frameScore += getFrameScore();
		}

		return frameScore;
	}
	

	/**
	 * to repeat as size of rolls list, and get frame score without bonus score.
	 * @return frame score of current frame
	 */
	private int getFrameScore() {
		int frameScore = 0;
		for (int index = 0; index < rolls.size(); index++){
			frameScore += rolls.get(index).getPins();
		}
		return frameScore;
	}



	public int getSize() {
		return rolls.size();
	}

	public void addRoll(int pins) {
		if(pins == 10){
			fulled = true;
		}
		rolls.add(newRoll(pins));
	}

	public Roll newRoll(int pins) {
		Roll roll = new Roll();
		roll.setPins(pins);

		return roll;
	}

	public boolean isFull() {
		return (rolls.size() >= MAX_ROLL) || fulled ;
	}

	public boolean isStrike() {
		return getFrameFirstScore() == 10;
	}

	public boolean isSpare() {
		return getFrameScore() == 10;
	}
	
	public void setNextFrame(Frame nextFrame) {
		this.nextFrame = nextFrame;
	}
	
	public Frame getNextFrame() {
		return nextFrame;
	}

	/**
	 * calculate a bonus score when strike state.
	 * @return bonus score of strike state.
	 */
	protected int strikeAdditionalScore() {
		int nextFrameScore = 0;
		
		nextFrameScore = getNextFrame().getFrameScore();

		if (getNextFrame().isStrike()) {
			if(getNextFrame().getNextFrame() == null){
				nextFrameScore = getNextFrame().getFrameFirstScore();
			}else{
				nextFrameScore += getNextFrame().getNextFrame().getFrameFirstScore();
			}
			
		}

		return nextFrameScore;
	}

	/**
	 * calculate a bonus score when spare state.
	 * @return bonus score of spare state.
	 */
	protected int spareAdditionalScore() {
		if(getNextFrame() == null){
			System.out.println(getFrameFirstScore() + ", " +getFrameSecondScore());
			return 0;
		}
		
		return getNextFrame().getFrameFirstScore();
	}
}
