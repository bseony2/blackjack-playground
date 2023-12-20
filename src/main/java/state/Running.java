package state;

import domain.Cards;

public abstract class Running extends Started{
    public Running(Cards cards) {
        super(cards);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public double profit(double betAmt) {
        return betAmt * 2;
    }
}
