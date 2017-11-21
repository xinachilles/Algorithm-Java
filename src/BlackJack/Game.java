package BlackJack;

import java.util.ArrayList;

public class Game {

    private Deck<BlackJackCard> deck;
    private BlackJackHand[] hands;
    private static final int HIT_UNTIL = 16;

    public Game(int numPlayers) {
        hands = new BlackJackHand[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            hands[i] = new BlackJackHand();
        }
    }

    public boolean dealInitial() {
        for (BlackJackHand hand : hands) {
            BlackJackCard card1 = deck.dealCard();
            BlackJackCard card2 = deck.dealCard();
            if (card1 == null || card2 == null) {
                return false;
            }
            hand.addCard(card1);
            hand.addCard(card2);
        }
        return true;
    }

    public ArrayList<Integer> getBlackJacks() {
        ArrayList<Integer> winners = new ArrayList<Integer>();
        for (int i = 0; i < hands.length; i++) {
            if (hands[i].isBlackJack()) {
                winners.add(i);
            }
        }
        return winners;
    }

    public boolean playHand(int i) {
        BlackJackHand hand = hands[i];
        return playHand(hand);
    }


    public boolean playHand(BlackJackHand hand) {
        //while (hand.score() < HIT_UNTIL) {
        BlackJackCard card = deck.dealCard();
        if (card == null) {
            return false;
        }
        hand.addCard(card);
        // }
        return true;
    }

    public boolean playAllHands() {
        for (BlackJackHand hand : hands) {
            String input = hand.getInput();

            if (input == "STOP") {
                hand.status = Hand.Status.Stop;
            } else if (input == "CONTINUE") {

                if (!playHand(hand)) {
                    return false;
                }
            }

        }

        return true;
    }

    public ArrayList<Integer> getWinners() {
        ArrayList<Integer> winners = new ArrayList<Integer>();
        int winningScore = 0;
        for (int i = 0; i < hands.length; i++) {
            BlackJackHand hand = hands[i];
            if (!hand.busted()) {
                if (hand.score() > winningScore) {
                    winningScore = hand.score();
                    winners.clear();
                    winners.add(i);
                } else if (hand.score() == winningScore) {
                    winners.add(i);
                }
            }
        }
        return winners;
    }

    public void initializeDeck() {
        ArrayList<BlackJackCard> cards = new ArrayList<BlackJackCard>();
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j <= 3; j++) {
                Suit suit = Suit.getSuitFromValue(j);
                BlackJackCard card = new BlackJackCard(i, suit);
                cards.add(card);
            }
        }

        deck = new Deck<BlackJackCard>();
        deck.setDeckOfCards(cards);
        deck.shuffle();
    }

    public void printHandsAndScore() {
        for (int i = 0; i < hands.length; i++) {
            System.out.print("Hand " + i + " (" + hands[i].score() + "): ");
            hands[i].print();
            System.out.println("");
        }
    }

    public static void Main(String[] args) {

        Game BlackJackGame = new Game(4);
        BlackJackGame.initializeDeck();
        boolean success = BlackJackGame.dealInitial();
        if (!success) {
            System.out.println("Error. Out of cards.");
        } else {
            System.out.println("-- Initial --");
            BlackJackGame.printHandsAndScore();
            ArrayList<Integer> blackjacks = BlackJackGame.getBlackJacks();
            if (blackjacks.size() > 0) {
                System.out.print("Blackjack at ");
                for (int i : blackjacks) {
                    System.out.print(i + ", ");
                }
                System.out.println("");
            } else {
                success = BlackJackGame.playAllHands();
                if (!success) {
                    System.out.println("Error. Out of cards.");
                } else {
                    System.out.println("\n-- Completed Game --");
                    BlackJackGame.printHandsAndScore();
                    ArrayList<Integer> winners = BlackJackGame.getWinners();
                    if (winners.size() > 0) {
                        System.out.print("Winners: ");
                        for (int i : winners) {
                            System.out.print(i + ", ");
                        }
                        System.out.println("");
                    } else {
                        System.out.println("Draw. All players have busted.");
                    }
                }
            }
        }
    }


}

