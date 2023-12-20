package domain;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    private final List<PlayingCard> cards = new ArrayList<>();

    public int getScore() {
        return cards.stream().mapToInt(PlayingCard::getScore).sum();
    }
}
