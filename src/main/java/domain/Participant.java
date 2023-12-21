package domain;

import state.State;

import java.util.stream.Collectors;

public abstract class Participant {

    public final String name;
    public State state;

    protected Participant(String name) {
        this.name = name;
    }

    public Participant(String name, State state) {
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public String getcards() {
        return state.cards().stream().map(PlayingCard::toString).collect(Collectors.joining(", "));
    }

    public int getScore() {
        return state.cards().getScore();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void stay() {
        this.state = state.stay();
    }

    public boolean isFinished() {
        return state.isFinished();
    }

    public void draw(PlayingCard card) {
        state = state.draw(card);
    }
}