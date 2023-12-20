package domain;

import java.util.Iterator;
import java.util.List;

public class Cards implements Iterable<PlayingCard>{
    private final List<PlayingCard> cards;

    public Cards(List<PlayingCard> cards) {
        this.cards = cards;
    }

    public int getScore() {

        int score = cards.stream().mapToInt(PlayingCard::getScore).sum();

        return calAceCard(score);
    }

    private int calAceCard(int score) {
        if(score <= 11 && cards.stream().anyMatch(PlayingCard::isAceCard)) {
            score += 10;
        }
        return score;
    }

    public int size() {
        return cards.size();
    }

    @Override
    public Iterator<PlayingCard> iterator() {
        return this.cards.iterator();
    }
}
