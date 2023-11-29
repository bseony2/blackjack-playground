package nextstep.blackjack.enums;

import java.util.Arrays;

public enum Suit {

    CLUB(0, "클로버")
    ,HEART(1, "하트")
    ,DIAMOND(2, "다이아몬드")
    ,SPADE(3, "스페이드");

    private final int index;
    private final String name;

    Suit(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public static Suit getSuit(int index) {
        return Arrays.stream(values())
                .filter(s -> s.index == index)
                .findAny().orElseThrow(() -> new IllegalArgumentException("문양 인자값을 확인하시기 바랍니다."));
    }

    public String getName() {
        return name;
    }
}
