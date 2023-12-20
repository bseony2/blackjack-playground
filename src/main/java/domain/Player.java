package domain;

import state.State;

public class Player extends Participant{

    private double betAmt = 0;

    public Player(String name) {
        super(name);
    }

    public Player(String name, State state) {
        super(name, state);
    }

    public double getBetAmt() {
        return betAmt;
    }

    public void setBetAmt(double betAmt) {
        this.betAmt = betAmt;
    }

    public double profit() {
        return this.state.profit(this.betAmt);
    }
}
