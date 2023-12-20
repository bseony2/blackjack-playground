package state;

import domain.Cards;

public class Stay extends Finished{
    public Stay(Cards cards) {
        super(cards);
    }

    @Override
    public double earningRate() {
        return 2;
    }
}
