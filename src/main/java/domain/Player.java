package domain;

import state.State;

public class Player extends Participant{
    public Player(String name) {
        super(name);
    }

    public Player(String name, State state) {
        super(name, state);
    }
}
