/*
 * @(#)TenthFrame.java $version 2013. 7. 8.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

public class TenthFrame extends Frame{
	
	/**
	 * @author boram.jeong
	 * This is tenth frame class inherited from Frame class.
	 * Class to calculate score of tenth frame. 
	 * Override addRoll(), strikeAdditionalScore(), spareAdditionalScore() method.
	 */


	public TenthFrame() {
		super();

	}
	
	public void addRoll(int pins) {
		rolls.add(newRoll(pins));
		
		if(rolls.size() == 2){
			if(isSpare() || isStrike())
				this.MAX_ROLL++;
		}
	}
	
	public int getFrameThirdScore(){
		if(rolls.get(2) == null)
			return 0;
		
		return rolls.get(2).getPins();
	}
	

	
	protected int strikeAdditionalScore() {
		int additionalScore = 0;

		additionalScore = getFrameSecondScore() + getFrameThirdScore();

		if (getFrameSecondScore() == 10) {
			additionalScore += getFrameThirdScore();
			
		}

		return additionalScore;
	}
	
	protected int spareAdditionalScore() {
		
		return getFrameThirdScore();
	}

}
