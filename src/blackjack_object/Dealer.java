package blackjack_object;

import java.util.ArrayList;

public class Dealer {

	int score = 0;
	int point = 0;

	Card card = new Card();

	ArrayList<Integer> dHand = new ArrayList<>();
	ArrayList<String> dHandData = new ArrayList<>();
	ArrayList<Integer> dHandScore = new ArrayList<>();

	public Dealer(int num1, int num2) {
		dHand.add(num1);
		dHand.add(num2);
	}

	public void addHand(int num) {
		dHand.add(num);
	}

	public Integer getHand(int num) {
		return dHand.get(num);
	}

	public void createHandData() {
		for (int i = 0; i < dHand.size(); i++) {
			//System.out.println(hand.get(i));
			dHandData.add(card.createCardData(dHand.get(i)));
		}
	}

	public void createOneHandData(int num) {
		dHandData.add(card.createCardData(num));
	}

	public String getHandData(int i) {
		return dHandData.get(i);
	}

	public void sumPoint(int x) {
		if (x == 11 || x == 12 || x == 13) {
			this.point += 10;
			dHandScore.add(10);
		} else {
			this.point += x;
			dHandScore.add(x);
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

	public int getSumPoint() {
		return this.point;
	}

	public ArrayList<Integer> getHandScore() {
		return dHandScore;
	}

	public ArrayList<String> getAllHandData() {
		return dHandData;
	}
}
