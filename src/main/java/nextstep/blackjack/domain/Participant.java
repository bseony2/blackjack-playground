package nextstep.blackjack.domain;

import nextstep.blackjack.enums.CardNumber;

import java.util.ArrayList;
import java.util.List;

public class Participant {
    private final List<Card> cardList;

    public Participant() {
        this.cardList = new ArrayList<>();
    }
    public void addCard(Card card) {
        cardList.add(card);
    }

    public int getScore() {
        int score = this.cardList.stream()
                .mapToInt(Card::score)
                .sum();

        return calAceCard(score);
    }

    private int calAceCard(int score) {
        if(hasAceCard() && score <= 11) {
            return score + 10;
        }
        return score;
    }

    private boolean hasAceCard() {
        return this.cardList.stream()
                .anyMatch(card -> card.getNumber() == CardNumber.ACE);
    }
}
