package domain;

import enums.Denomination;
import enums.Suit;

public class PlayingCard {

    private final Denomination denomination;
    private final Suit suit;

    public PlayingCard(Denomination denomination, Suit suit) {
        this.denomination = denomination;
        this.suit = suit;
    }

    public double getScore() {
        return denomination.getScore();
    }
}
