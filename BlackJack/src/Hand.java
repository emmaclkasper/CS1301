/*
* Hand.java
* Author: Emma Kasper
* Submission Date: 2 December 2016 
* Purpose:This class represents the cards in either the player's or dealer's hand 
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
 * 
 * @author ghyzel
 *
 */
public class Hand {

	/**
	 * The cards in the hand
	 */
	private Card[] cards;

	/**
	 * Creates an empty hand
	 */
	public Hand() {

		cards = new Card[0];
	}

	/**
	 * Adds Card c to the hand
	 * 
	 * @param c
	 *            card to be added
	 */

	public void addCard(Card c) {

		Card[] newCard = new Card[this.cards.length + 1];
		for (int i = 0; i < this.cards.length; i++) {
			newCard[i] = this.cards[i];
		}

		newCard[newCard.length - 1] = c;
		this.cards = newCard;
	}

	/**
	 * @return number of cards in the hand
	 */
	public int size() {

		return this.cards.length;
	}

	/**
	 * Returns an array of all the cards in the hand
	 * 
	 * @return the cards in the hand
	 */
	public Card[] getCards() {

		if (this.cards.length == 0)

		{
			Card[] emptyHand = new Card[0];
			return emptyHand;
		}

		else

		{
			Card[] newHand = new Card[this.cards.length];
			for (int i = 0; i < this.cards.length; i++) {
				newHand[i] = this.cards[i];
			}
			return newHand;
		}
	}

	/**
	 * Empties the hand, and returns an array containing the discarded cards.
	 * 
	 * @return the discarded cards
	 */
	public Card[] emptyHand() {

		Card[] discarded = new Card[this.cards.length];
		for (int i = 0; i < this.cards.length; i++)

		{
			discarded[i] = this.cards[i];
		}

		this.cards = new Card[0];
		return discarded;
	}

	/**
	 * Returns a String representation of the hand
	 * 
	 * E.g.
	 * 
	 * "Empty Hand" "1. ACE OF SPADES\n2. QUEEN OF HEARTS"
	 * 
	 * @return a String representing the hand
	 */

	public String toString() {

		if (this.cards.length == 0)

		{
			String empty = "Empty Hand";
			return empty;
		}

		String hand = "";
		for (int i = 0; i < this.cards.length; i++)

		{
			hand = hand + (i + 1) + ". " + this.cards.toString() + "\n";
		}

		return hand;
	}
}
