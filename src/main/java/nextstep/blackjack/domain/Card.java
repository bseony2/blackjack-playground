package nextstep.blackjack.domain;

import nextstep.blackjack.enums.CardNumber;
import nextstep.blackjack.enums.Suit;

public class Card {
    public static final int CARD_PER_SUIT = 13;
    private final Suit suit;
    private final CardNumber number;

    public Card(int idx) {
        this.suit = Suit.getSuit(idx / CARD_PER_SUIT);
        this.number = CardNumber.getCardNumberByIndex(idx % CARD_PER_SUIT);
    }
    public Suit getSuit() {
        return suit;
    }

    public CardNumber getNumber() {
        return number;
    }

    public Card(Suit suit, CardNumber number) {
        this.suit = suit;
        this.number = number;
    }
}
