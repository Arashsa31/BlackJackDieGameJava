/**
 * @author Arash
 *
 */
public class Game {
	
	//default constructor
	public Game() {		
	}	
	/**
	 * @return card number
	 */
	public static int getHit() {
		int card = 0;
		card = (int) (Math.random() * 13) + 2;
		if (card == 12 || card == 13 || card == 14) {
			card = 10;
			return card;	
		}		
		else return card;	
	}
	/**
	 * @param handValue
	 * @return true if >21
	 */
	public static boolean isBust(int handValue) {
		if (handValue > 21)
			return true;
		else return false;
	}
	/**
	 * @param houseHandValue
	 * @param playerHandValue
	 * @return true if houseHandValue > playerHandValue
	 */
	public static boolean haveHigherNumber(int houseHandValue, int playerHandValue) {
		if(houseHandValue > playerHandValue)
			return true;
		else return false;
	}
	/**
	 * @param houseHandValue
	 * @param playerHandValue
	 * @return true if houseHandValue < playerHandValue
	 */
	public static boolean haveLowerNumber(int houseHandValue, int playerHandValue) {
		if(houseHandValue < playerHandValue)
			return true;
		else return false;
	}
	/**
	 * @param houseHandValue
	 * @param playerHandValue
	 * @return true if equal
	 */
	public static boolean getPush(int houseHandValue, int playerHandValue) {	
		if(houseHandValue == playerHandValue)
			return true;
		else return false;
	}

}
