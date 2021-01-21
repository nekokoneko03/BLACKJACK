package blackjack_object;

import java.util.ArrayList;

public class Player {

	ArrayList<Integer> pHand = new ArrayList<>();
	ArrayList<String> pHandData = new ArrayList<>();
	ArrayList<Integer> pHandScore = new ArrayList<>();

	int score = 0;
	int point = 0;

	Card card = new Card();
	Deck deck = new Deck();

	//呼び出されると同時に引数をリストhandに追加
	public Player(int num1, int num2) {
		pHand.add(num1);
		pHand.add(num2);
	}

	public void addHand(int num) {
		pHand.add(num);
	}

	public Integer getHand(int num) {
		return pHand.get(num);
	}

	public void createHandData() {
		for (int i = 0; i < pHand.size(); i++) {
			//System.out.println(hand.get(i));
			pHandData.add(card.createCardData(pHand.get(i)));
		}
	}

	public void createOneHandData(int num) {
		pHandData.add(card.createCardData(num));
	}

	public void sumPoint(int x) {
		if (x == 11 || x == 12 || x == 13) {
			this.point += 10;
			pHandScore.add(10);
		} else {
			this.point += x;
			pHandScore.add(x);
		}
	}

	public int toScore(int x) {
		this.score = 0;
		if (x % 13 == 0) {
			this.score = 13;
		} else {
			this.score = x % 13;
		}
		return this.score;
	}

	public void drawCard(int DECK_COUNT, int HAND_COUNT) {
		this.addHand(deck.getOneCard(DECK_COUNT));
		this.createOneHandData(this.getHand(HAND_COUNT));
	}

	public int getPoint(int x) {
		if (x == 11 || x == 12 || x == 13) {
			return 10;
		} else {
			return x;
		}
	}

	public ArrayList<Integer> getHandScore() {
		return pHandScore;
	}

	public int getSumPoint() {
		return this.point;
	}

	public String getHandData(int i) {
		return pHandData.get(i);

	}

	public ArrayList<String> getAllHandData() {
		return pHandData;
	}
}
