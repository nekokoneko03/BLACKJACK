package blackjack_object;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		int DECK_COUNT = 0;
		int HAND_COUNT = 0;
		int pDRAW_COUNT = 0;
		int dDRAW_COUNT = 0;

		Deck deck = new Deck();
		Card card = new Card();

		//deck.showDeck();

		System.out.println("ブラックジャックを開始します。");
		System.out.println("\n");

		//Player player = new Player(1, 9);

		Player player = new Player(deck.getOneCard(DECK_COUNT), deck.getOneCard(DECK_COUNT += 1));
		Dealer dealer = new Dealer(deck.getOneCard(DECK_COUNT += 1), deck.getOneCard(DECK_COUNT += 1));

		System.out.print("あなたのハンドは、");
		player.createHandData();
		System.out.print(player.getAllHandData());
		player.sumPoint(player.toScore(player.getHand(HAND_COUNT)));
		player.sumPoint(player.toScore(player.getHand(HAND_COUNT + 1)));
		System.out.println("です。");

		//System.out.println(player.getHand(HAND_COUNT));
		//System.out.println(card.getSuit());

		System.out.print("ディーラーのハンドは、");
		dealer.createHandData();
		System.out.println("[" + dealer.getHandData(0) + "]" + "と[秘密]です。");
		dealer.sumPoint(dealer.toScore(dealer.getHand(HAND_COUNT)));
		dealer.sumPoint(dealer.toScore(dealer.getHand(HAND_COUNT + 1)));
		System.out.println("\n");

		if (player.getHandScore().contains(1) && player.getHandScore().contains(10)) {
			System.out.println("ブラックジャックです。");
			player.sumPoint(10);

		} else {
			while (true) {

				pDRAW_COUNT++;

				//System.out.println(DECK_COUNT);

				System.out.print("追加でカードを引きますか？ y/n >");

				Scanner sc = new Scanner(System.in);
				String str = sc.nextLine();

				if (str.contentEquals("y")) {
					System.out.println("\n");
					player.addHand(deck.getOneCard(DECK_COUNT += 1));
					player.createOneHandData(player.getHand((HAND_COUNT + 1) + pDRAW_COUNT));
					System.out.print("引かれたのは" + "[");
					System.out.println(player.getHandData((HAND_COUNT + 1) + pDRAW_COUNT) + "]です。");
					System.out.print("あなたのハンドは、");
					System.out.print(player.getAllHandData());
					System.out.println("です。");

					//System.out.println(player.getAllHandData());
					//System.out.println(player.getAllHandData());
					//System.out.println((HAND_COUNT + 1) + DRAW_COUNT);

					player.sumPoint(player.toScore(player.getHand((HAND_COUNT + 1) + pDRAW_COUNT)));
					System.out.println("合計スコアは" + player.getSumPoint() + "です。");
					System.out.println("\n");

					if (card.checkBurst(player.getSumPoint()) == true) {
						return;
					}
					if (player.getSumPoint() == 21) {
						System.out.println("ブラックジャックです。");
						break;
					}

				} else if (str.contentEquals("n")) {
					if(player.getHandScore().contains(1) && player.getSumPoint() <= 10) {
						player.sumPoint(10);
					}
					break;
				}
			}
		}
		//if ディーラースコア<17
		if (dealer.getSumPoint() < 17) {
			System.out.println("\n");
			System.out.println("ディーラーのスコアが17以上になるまで、ディーラーがドローします。");
			while (true) {
				System.out.println("\n");

				//				System.out.println(dealer.getSumPoint());

				dDRAW_COUNT++;

				dealer.addHand(deck.getOneCard(DECK_COUNT += 1));
				dealer.createOneHandData(dealer.getHand((HAND_COUNT + 1) + dDRAW_COUNT));
				dealer.sumPoint(dealer.toScore(dealer.getHand((HAND_COUNT + 1) + dDRAW_COUNT)));
				System.out.println(dealer.getAllHandData());
				System.out.print("引かれたのは" + "[");
				System.out.println(dealer.getHandData((HAND_COUNT + 1) + dDRAW_COUNT) + "]です。");
				pDRAW_COUNT++;
				if (dealer.getSumPoint() > 21) {
					System.out.println("ディーラーがブレイクしました。あなたの勝ちです。");
					return;
				} else if (dealer.getSumPoint() >= 17) {
					break;
				}
			}
		}

		System.out.println("\n");
		System.out.println("あなたの合計スコアは" + player.getSumPoint() + "です。");
		System.out.println("ディーラーの合計スコアは" + dealer.getSumPoint() + "です。");

		System.out.println("\n");
		if (player.getSumPoint() == dealer.getSumPoint()) {
			System.out.println("ディーラーの勝ちです。");
		} else if (player.getSumPoint() > dealer.getSumPoint()) {
			System.out.println("あなたの勝ちです。");
		} else {
			System.out.println("ディーラーの勝ちです。");
		}

	}
}
