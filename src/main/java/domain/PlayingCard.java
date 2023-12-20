package domain;

import enums.Denomination;
import enums.Suit;

import java.util.Objects;

public class PlayingCard {

    private final Denomination denomination;
    private final Suit suit;

    public PlayingCard(Denomination denomination, Suit suit) {
        this.denomination = denomination;
        this.suit = suit;
    }

    public int getScore() {
        return denomination.getScore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayingCard that = (PlayingCard) o;
        return denomination == that.denomination && suit == that.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(denomination, suit);
    }

    public boolean isAceCard() {
        return this.denomination.isAce();
    }

    @Override
    public String toString() {
        return this.denomination.getAbbreviation() + this.suit.getAbbreviation();
    }
}
