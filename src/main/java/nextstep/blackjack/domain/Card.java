package nextstep.blackjack.domain;

import nextstep.blackjack.enums.CardNumber;
import nextstep.blackjack.enums.Suit;

public class Card {
    private final Suit suit;
    private final CardNumber number;

    public Card(Suit suit, CardNumber number) {
        this.suit = suit;
        this.number = number;
    }
}
