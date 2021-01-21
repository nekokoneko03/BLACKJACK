package blackjack_object;

public class Card {

	private int num, point, score, sumPoint;
	private String suit;

	public Card() {
		;
	}

	public void toScore(int x) {
		this.num = x;

		if(this.num % 13 == 0) {
			this.score = 13;
		}else {
			this.score = x % 13;
		}
	}

	public void toSuit(int x) {
		this.num = x;

		//System.out.println((this.num - 1 )/ 13);
		switch((this.num - 1) / 13) {
		case 0:
			this.suit = "ハート";
			break;
		case 1:
			this.suit = "ダイヤ";
			break;
		case 2:
			this.suit = "スペード";
			break;
		case 3:
			this.suit = "クラブ";
			break;
		default:
			this.suit = "エラー";
			break;
		}
	}

	public void toPoint(int x) {
		if(x == 11 || x == 12|| x == 13) {
			this.point = 10;
		}else {
			this.point = x;
		}
	}

	public void sumPoint(int... x) {
		for(int i = 0; i <= x.length; i++) {
			if(x[i] == 11|| x[i] == 12|| x[i] == 13) {
				sumPoint = sumPoint + 10;
			}else {
				sumPoint = sumPoint + x[i];
			}
		}
	}

	public String createCardData(int x) {
		this.toScore(x);
		this.toSuit(x);
		this.toPoint(x);

		return this.getSuit() + "の" + this.getScore();
	}

	public boolean checkBurst(int x) {
		if(x > 21) {
			System.out.println("バーストしました。あなたの負けです。");
			return true;
		}else {
			return false;
		}
	}

	public boolean checkA(int x, int y) {
		if(x == 1 && y == 10) {
			return true;
		}else {
			return false;
		}
	}

	public int getScore() {
		return this.score;
	}
	public String getSuit() {
		return this.suit;
	}
	public int getPoint() {
		return this.point;
	}
	public int getSumPoint() {
		return this.sumPoint;
	}
	public int test() {
		return 9191;
	}
}