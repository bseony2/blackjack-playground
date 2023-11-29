package nextstep.blackjack.util;

import nextstep.blackjack.domain.Participant;
import nextstep.blackjack.domain.Player;
import nextstep.blackjack.enums.GameResult;

public class GameRule {
    public static final int WINNER_TIME = 2;
    public static final double BLACKJACK_TIME = 1.5;
    public static GameResult getResult(Participant participant, Participant challenger) {
        if (challenger.getScore() > 21) {
            return GameResult.LOSE;
        } else if (participant.getScore() > 21) {
            return GameResult.WIN;
        } else if (challenger.getScore() < participant.getScore()) {
            return GameResult.LOSE;
        } else if (challenger.getScore() > participant.getScore()) {
            return GameResult.WIN;
        }
        return GameResult.DRAW;
    }

    public static double getProfit(GameResult gameResult, Player player) {
        if(GameResult.isWin(gameResult) && player.cardList.size() > 2) {
            return player.getBattingMoney() * WINNER_TIME;
        } else if (GameResult.isWin(gameResult)) {
            return player.getBattingMoney() * BLACKJACK_TIME;
        } else if (GameResult.isLose(gameResult)) {
            return 0;
        }
        return player.getBattingMoney();
    }
}
