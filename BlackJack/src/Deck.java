/*
* Deck.java
* Author: Emma Kasper
* Submission Date: 2 December 2016 
* Purpose:This class represents the deck where the player and the dealer's hand come from 
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
import java.util.Random;

/**
 * Class representing a standard 52 card deck. Allows users to shuffle, draw,
 * and add cards to the bottom for the purpose of playing various card games.
 */
public class Deck {

	/**
	 * Cards in the deck
	 */
	private Card[] cards;

	/**
	 * The number of cards in the physical deck on the table.
	 */
	private int numCardsInDeck;

	/**
	 * Create a standard 52 card deck w/ one of each type (Ace, King, Queen...)
	 * for each Suit (Hearts, Spades ..)
	 */
	public Deck() {

		Card.Suit[] suits = Card.Suit.values();
		Card.Type[] types = Card.Type.values();
		cards = new Card[suits.length * types.length];
		numCardsInDeck = 0;

		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < types.length; j++) {

				cards[numCardsInDeck] = new Card(types[j], suits[i]);
				numCardsInDeck++;
			}
		}
	}

	/**
	 * Draws card from the top
	 * 
	 * @return the top card
	 */
	public Card draw() {
		if (numCardsInDeck == 0)

		{
			System.out.println("Error: The deck is empty");
			return null;
		}

		else

		{
			Card drawTop = this.cards[numCardsInDeck - 1];
			numCardsInDeck--;
			return drawTop;
		}
	}

	/**
	 * Swaps card at a with card at b
	 * 
	 * @param a
	 *            card to be swapped with b
	 * @param b
	 *            card to be swapped with a
	 */
	private void swap(int a, int b) {

		Card swapping = this.cards[a];
		this.cards[a] = this.cards[b];
		this.cards[b] = swapping;
	}

	/**
	 * Shifts all the cards in the deck right by one place
	 */
	private void shiftRightOne() {

		if (numCardsInDeck == 52) {
			System.out.println("Error: The deck is full");
		} else {
			for (int i = numCardsInDeck, j = numCardsInDeck - 1; i > 0; j--, i--) {
				swap(j, i);
			}
		}
	}

	/**
	 * Add c to the bottom of the deck Print "Deck Full" when count equals the
	 * size of the deck
	 * 
	 * @param c
	 *            card to add
	 */
	public void addToBottom(Card c) {

		if (numCardsInDeck == 52)

		{
			System.out.println("Error: The deck is full");
		}

		else

		{
			shiftRightOne();
			this.cards[0] = c;
			numCardsInDeck++;
		}
	}

	/**
	 * Shuffles the deck by swapping the cards 100 times
	 */
	public void shuffle() {
		Random random = new Random();

		for (int i = 0; i < 100; i++)

		{
			swap(random.nextInt(52), random.nextInt(52));
		}
	}

	/**
	 * Shuffles the deck by swapping cards n times
	 * 
	 * @param n
	 *            number of swaps
	 */
	public void shuffle(int n) {
		Random random = new Random();

		for (int i = 0; i < n; i++)

		{
			swap(random.nextInt(52), random.nextInt(52));
		}
		
		
	}

}
