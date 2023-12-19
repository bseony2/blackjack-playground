package domain;

import enums.Denomination;
import enums.Suit;

public class PlayingCard {
    private final Suit suit;
    private final Denomination denomination;

    public PlayingCard(Suit suit, Denomination denomination) {
        this.suit = suit;
        this.denomination = denomination;
    }
}
