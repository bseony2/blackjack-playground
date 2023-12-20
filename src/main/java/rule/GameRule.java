package rule;

import domain.Participant;
import domain.Player;
import enums.GameResult;
import enums.ResultState;

public class GameRule {

    public static GameResult getResult(Participant dealer, Participant player) {

        if (ResultState.getResultState(player) == ResultState.BUST) {
            return GameResult.LOSE;
        }

        if (ResultState.getResultState(dealer) == ResultState.BUST
                && ResultState.getResultState(player) != ResultState.BUST) {
            return GameResult.WIN;
        }

        if (ResultState.getResultState(dealer) == ResultState.BLACKJACK
                && ResultState.getResultState(player) == ResultState.BLACKJACK) {
            return GameResult.DRAW;
        }

        if (player.getScore() > dealer.getScore()) {
            return GameResult.WIN;
        }

        if (player.getScore() == dealer.getScore()) {
            return GameResult.DRAW;
        }

        return GameResult.LOSE;
    }

}
