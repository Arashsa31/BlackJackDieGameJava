import java.util.Scanner;

/**
 * @author Arash
 *
 */
public class BlackJackGameDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//variables
		boolean biggerFlag = true, flag = true;
		int startingMoney = 0, startingWager = 0;
		String quit;
		
		//creates scanner objects
		Scanner keyboard = new Scanner(System.in);
		
		//creates,  house object
		House house = new House();		
		
		//creates player object
		System.out.println("Starting money amount is $100.");
		startingMoney = 100;
		Player player = new Player(startingMoney);
		
		//play the game	
		while(biggerFlag) {
			System.out.println("*****LET'S PLAY BLACKJACK!*****");
			//resets cards in hand to 0
			house.resetHandValue();
			player.resetHandValue();

			//player wager
			do {
				System.out.print("Enter the amount of money you want to wager: $");
				startingWager = keyboard.nextInt();
				player.setWager(startingWager);
				if (player.getWager() > player.getMoney())
					System.out.println("You cannot wager more than what you have.");
			} while(player.getWager() > player.getMoney());
			
			//house gets a card
			house.setHandValue(Game.getHit());
			System.out.println("The house card is: " + house.getCard());		
			
			//player gets 2 cards	
			player.setHandValue(Game.getHit());
			System.out.print("The player cards are  " + player.getCard());
			player.setHandValue(Game.getHit());
			System.out.print(", " + player.getCard());
			System.out.println(". The player total is " + player.getHandValue());
			
			while(flag) {
				//check to see if house or player is busted before game starts (rolled 2 ace)
				if (Game.isBust(house.getHandValue()) || Game.isBust(player.getHandValue()))
					break;
				else
					System.out.print("Do you want to hit or stand?");
					String hitOstand = keyboard.next().toLowerCase();
			//player gets another card
				if (hitOstand.equals("hit")) {	
					player.setHandValue(Game.getHit());
					System.out.println("Player card received " + player.getCard());
					System.out.println("Player total card value so far is: " + player.getHandValue());
					if(Game.isBust(player.getHandValue())) 
						flag = false;									
				}			
			//player keeps current hand and gives turn to house
				else if (hitOstand.equals("stand")) {				
					while (house.getHandValue() < 17) {
						house.setHandValue(Game.getHit());
						System.out.println("House card received " + house.getCard());
					}
					System.out.println("House total card value so is: " + house.getHandValue());
					if(Game.isBust(house.getHandValue())) 
						flag = false;		
					else if (house.getHandValue() >= 17)
						flag = false;	
				}
				else System.out.println("Please enter the word hit OR stand.");
			}
			//comparing who won
			if (Game.getPush(house.getHandValue(), player.getHandValue())) {
				System.out.println("No One wins. The player does not win nor lose his wager.");
			}
			//check bust
			else if(Game.isBust(player.getHandValue())) {
				System.out.println("Player Lost! The player loses $" + player.getWager());
				player.setMoney(player.getWager()*-1);	
			}
			else if(Game.isBust(house.getHandValue())) {
				System.out.println("House Lost! The player wins $" + player.getWager());
				player.setMoney(player.getWager());
			}
			//compare values
			else if(Game.haveHigherNumber(house.getHandValue(), player.getHandValue())) {
				System.out.println("Player Lost! The player loses $" + player.getWager());
				player.setMoney(player.getWager()*-1);	
			}
			else if(Game.haveLowerNumber(house.getHandValue(), player.getHandValue())) {
				System.out.println("House Lost! The player wins $" + player.getWager());
				player.setMoney(player.getWager());
			}
			
			System.out.println("Total money player has: $" + player.getMoney());
			
			//ask user to quit the game
			do {
				System.out.println("Do you want to quit the game?(type yes or no) ");
				quit = keyboard.next().toLowerCase();
			}while(!(quit.equals("yes") || quit.equals("no")));
			if (quit.equals("yes")) {
				System.out.println("Goodbye.");
				biggerFlag = false;
				//System.exit(0);
			}
			else if (player.getMoney() <= 0) {
				System.out.println("You cannot play with no money!");
				biggerFlag = false;
				//System.exit(0);
			}
			else flag = true;
		}		
	}
}
