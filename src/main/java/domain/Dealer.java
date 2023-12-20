package domain;

import state.State;

public class Dealer extends Participant{
    public Dealer(String name) {
        super(name);
    }

    public Dealer(String name, State state) {
        super(name, state);
    }

    public String showOneCard() {
        return this.state.cards().stream()
                .findAny()
                .map(PlayingCard::toString)
                .orElse("카드 없습니다!");
    }
}
