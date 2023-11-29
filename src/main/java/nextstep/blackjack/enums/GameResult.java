package nextstep.blackjack.enums;

public enum GameResult {
    WIN,
    DRAW,
    LOSE;

    public static boolean isWin(GameResult result) {
        return result == WIN;
    }

    public static boolean isLose(GameResult result) {
        return result == LOSE;
    }

    public static boolean isDraw(GameResult result) {
        return result == DRAW;
    }
}
