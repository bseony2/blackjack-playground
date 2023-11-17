package nextstep.blackjack.enums;

import java.util.Arrays;

public enum Suit {

    CLUB(0)
    ,HEART(1)
    ,DIAMOND(2)
    ,SPADE(3);

    private final int index;

    Suit(int index) {
        this.index = index;
    }

    public static Suit getSuit(int index) {
        return Arrays.stream(values())
                .filter(s -> s.index == index)
                .findAny().orElseThrow(() -> new IllegalArgumentException("문양 인자값을 확인하시기 바랍니다."));
    }
}
