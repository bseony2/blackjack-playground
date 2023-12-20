package state;

import domain.Cards;
import domain.PlayingCard;

public abstract class Finished extends Started{
    public Finished(Cards cards) {
        super(cards);
    }

    @Override
    public State draw(PlayingCard card) {
        return this;
    }

    @Override
    public State stay() {
        return this;
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public double profit(double betAmt) {
        return betAmt * earningRate();
    }

    public abstract double earningRate();
}
