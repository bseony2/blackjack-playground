package domain;

import state.State;

import java.util.stream.Collectors;

public abstract class Participant {

    public final String name;
    protected State state;

    protected Participant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getcards() {
        return state.cards().stream().map(PlayingCard::toString).collect(Collectors.joining(", "));
    }

    public void setState(State state) {
        this.state = state;
    }
}