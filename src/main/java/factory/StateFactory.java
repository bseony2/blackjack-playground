package factory;

import domain.Cards;
import state.Blackjack;
import state.Bust;
import state.Hit;
import state.State;

public class StateFactory {

    private static final int BLACKJACK_SCORE = 21;

    public static State stateGenerate(Cards cards) {
        int score = cards.getScore();

        if (score == BLACKJACK_SCORE && cards.size() == 2) {
            return new Blackjack(cards);
        }
        if (score <= BLACKJACK_SCORE) {
            return new Hit(cards);
        }

        return new Bust(cards);
    }
}
