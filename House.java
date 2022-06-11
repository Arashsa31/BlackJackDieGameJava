/**
 * @author Arash
 *
 */
public class House {
	
	//instance variables
	private int card, handValue;
	
	//default constructor
	public House() {
		resetHandValue();
	}
	/**
	 * @return reset the hand to 0
	 */
	public int resetHandValue() {
		return handValue = 0;
	}
	/**
	 * @param cardValue, adds to total card value
	 */
	public void setHandValue(int cardValue) {
		if (cardValue > 0) {
		handValue += cardValue;
		card = cardValue;
		}
	}
	/**
	 * @return handValue
	 */
	public int getHandValue() {
		return handValue;
	}
	/**
	 * @return card
	 */
	public int getCard() {
		return card;
	}
}
