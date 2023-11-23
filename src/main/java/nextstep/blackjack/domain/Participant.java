package nextstep.blackjack.domain;

import java.util.List;

public class Participant {
    private List<Card> cardList;

    public void addCard(Card card) {
        cardList.add(card);
    }

    public int getScore() {
        return this.cardList.stream()
                .mapToInt(Card::score)
                .sum();
    }
}
