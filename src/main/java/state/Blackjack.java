package state;

import domain.Cards;

public class Blackjack extends Finished{
    public Blackjack(Cards cards) {
        super(cards);
    }

    @Override
    public double earningRate() {
        return 0;
    }
}
