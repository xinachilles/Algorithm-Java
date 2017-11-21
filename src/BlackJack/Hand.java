package BlackJack;

import java.util.ArrayList;
public class Hand <T extends Card> {
    public enum Status {
        Continue, Stop
    }
    protected ArrayList<T> cards = new ArrayList<T>();
    public  Status status;

    public int score() {
        int score = 0;
        for (T card : cards) {
            score += card.value();
        }
        return score;
    }

    public void addCard(T card) {
        cards.add(card);
    }

    public void print() {
        for (Card card : cards) {
            card.print();
        }
    }

    public String getInput(){
        return "";
    }

    public void StopDealing(){
        status = Status.Stop;
    }
}
