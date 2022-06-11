/**
 * @author Arash
 *
 */
public class Player {
	
	//variables
	private int money, wager, card, handValue;
	
	//constructor
	public Player() {	
		money = 0;
		wager = 0;
		resetHandValue();
	}	
	/**
	 * overloaded constructor
	 * @param money
	 */
	public Player(int money) {		
		this.money = money;
		this.wager = 0;
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
		handValue += cardValue;
		card = cardValue;
	}
	/**
	 * sets money
	 * @param moneyIN
	 */
	public void setMoney(int moneyIN) {
		money += moneyIN;
	}
	/**
	 * sets wager
	 * @param moneyOUT
	 */
	public void setWager(int moneyOUT) {
		if (moneyOUT > 0)
		wager = moneyOUT;
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
	/**
	 * @return money
	 */
	public int getMoney() {
		return money;
	}
	/**
	 * @return wager
	 */
	public int getWager() {
		return wager;
	}
}
