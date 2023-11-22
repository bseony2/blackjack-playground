package nextstep.blackjack.domain;

import nextstep.blackjack.util.GeneratorFactory;

import java.util.List;

public class Deck {
    public static final int TOTAL_CARD_QNTY = 52;
    private List<Card> deck;
    int cardIdx;

    public Deck() {
        initCardDeck();
    }

    private void initCardDeck() {
        this.deck = GeneratorFactory.getNewCardDeck();
        cardIdx = 0;
    }

    public Card getNextCard() {
        Card card = deck.get(cardIdx++);
        if (cardIdx == TOTAL_CARD_QNTY) {
            initCardDeck();
        }
        return card;
    }

}
