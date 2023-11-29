package nextstep.blackjack.domain;

import nextstep.blackjack.enums.CardNumber;

import java.util.ArrayList;
import java.util.List;

public abstract class Participant {

    public final String name;

    public List<Card> cardList = new ArrayList<>();

    protected Participant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public String getAllCards() {
        String answer = getName() + "카드: ";
        for (Card card : cardList) {
            answer += card.toString() + " ";
        }

        return answer;
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
