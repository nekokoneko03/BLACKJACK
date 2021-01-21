package blackjack_object;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	ArrayList<Integer> deck = new ArrayList<>(52);

	public Deck() {
		for(int i = 1; i <= 52; i++) {
			deck.add(i);
			Collections.shuffle(deck);
		}
	}

	public ArrayList<Integer> getDeck() {
		return deck;
	}

	public int getOneCard(int num) {
		return deck.get(num);
	}

	public void showDeck() {
		System.out.println(deck);
	}

}
