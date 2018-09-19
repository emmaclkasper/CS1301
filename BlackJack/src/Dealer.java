/*
* Dealer.java
* Author: Emma Kasper
* Submission Date: 2 December 2016 
* Purpose:This class represents the dealer 
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with 
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing
* or posting of source code for this project is strictly
* prohibited unless you have written consent from the Department
* of Computer Science at the University of Georgia. */

/**
 * The Dealer in your game of BlackJack. Draws until he/she gets 17 points or
 * has 5 cards.
 *
 */
public class Dealer {
	/**
	 * The dealers hand
	 */
	Hand hand;

	/**
	 * Construct a new dealer with an empty hand
	 */
	public Dealer() {

		hand = new Hand();
	}

	/**
	 * Dealer draws a card if his hand is worth less than 17 points and has less
	 * than 5 cards in in his hand.
	 * 
	 * @param deck
	 * @return
	 */
	public Card playTurn(Deck d) {
		if (this.hand.size() < 5 && BlackJack.getValueOfHand(this.hand) < 17) {
			Card drawCard = d.draw();
			this.hand.addCard(drawCard);
			return drawCard;
		} else {

			return null;
		}
	}

	/**
	 * A method to check if the dealer has busted
	 * 
	 * @return boolean true if the dealer has busted
	 */
	public boolean busted() {

		if (BlackJack.getValueOfHand(this.hand) > 21)

		{
			return true;
		}

		else

		{
			return false;
		}
	}

	/**
	 * A method to check if the dealer will draw a card.
	 * 
	 * @return
	 */
	public boolean isDone() {

		if (this.hand.size() < 5 || BlackJack.getValueOfHand(this.hand) < 17)

		{
			return false;
		}

		else {
			return true;
		}
	}

	/**
	 * Returns the dealers cards to the deck
	 * 
	 * @param d
	 *            Deck to return the cards to
	 */
	public void returnCardstoDeck(Deck d) {

		Card[] returnCards = new Card[hand.size()];
		for (int i = 0; i < hand.size(); i++)

		{
			returnCards[i] = hand.getCards()[i];
			d.addToBottom(returnCards[i]);
		}

		this.hand.emptyHand();
	}

	/**
	 * @return Hand the dealer's hand
	 */
	public Hand getHand()

	{
		return hand;
	}
}
