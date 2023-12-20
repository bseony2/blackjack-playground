package factory;

import domain.PlayingCard;
import enums.Denomination;
import enums.Suit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardFactory {
    public static List<PlayingCard> getNewDeck() {
        ArrayList<PlayingCard> newDeck = new ArrayList<>();
        Arrays.stream(Denomination.values()).forEach(denomination -> Arrays.stream(Suit.values()).forEach(suit -> newDeck.add(new PlayingCard(denomination, suit))));
        Collections.shuffle(newDeck);

        return newDeck;
    }
}
