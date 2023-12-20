package enums;

public enum Suit {
    CLUBS("클로버")
    ,DIAMONDS("다이아몬드")
    ,HEARTS("하트")
    ,SPADES("스페이드");

    private final String abbreviation;

    Suit(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }
}
