package nextstep.blackjack.enums;

import java.util.Arrays;

public enum CardNumber {
    ACE(0, "A", 1),
    TWO(1, "2", 2),
    THREE(2, "3", 3),
    FOUR(3, "4", 4),
    FIVE(4, "5", 5),
    SIX(5, "6", 6),
    SEVEN(6, "7", 7),
    EIGHT(7, "8", 8),
    NINE(8, "9", 9),
    TEN(9, "10", 10),
    JACK(10, "J", 10),
    QUEEN(11, "Q", 10),
    KING(12, "K", 10);

    private final int index;
    private final String symbol;
    private final int score;

    CardNumber(int index, String symbol, int score) {
        this.index = index;
        this.symbol = symbol;
        this.score = score;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getScore() {
        return score;
    }

    public static CardNumber getCardNumberByIndex(int index) {
        return Arrays.stream(values())
                .filter(s -> s.index == index)
                .findAny().orElseThrow(() -> new IllegalArgumentException("카드 번호의 인자값을 확인하시기 바랍니다."));
    }
}
