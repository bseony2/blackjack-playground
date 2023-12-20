package state;

import domain.Cards;

public abstract class Started implements State{

    protected final Cards cards;

    public Started(Cards cards) {
        this.cards = cards;
    }

    @Override
    public Cards cards() {
        return this.cards;
    }
}
