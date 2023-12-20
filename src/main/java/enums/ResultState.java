package enums;

import domain.Participant;
import state.Blackjack;
import state.Bust;

public enum ResultState {
    BUST
    ,BLACKJACK
    ,STAY;

    public static ResultState getResultState(Participant participant) {
        if (participant.state instanceof Bust) {
            return BUST;
        }

        if (participant.state instanceof Blackjack) {
            return BLACKJACK;
        }

        return STAY;
    }
}
