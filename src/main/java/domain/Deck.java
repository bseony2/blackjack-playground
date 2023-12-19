package domain;

import enums.Denomination;
import enums.Suit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

    static final int NUM_OF_CARD = 52;
    private List<PlayingCard> deck;
    private int cardIdx;

    public Deck() {
        getNewDeck();
    }

    private void getNewDeck() {
        this.deck = initDeck();
        this.cardIdx = 0;
    }

    private List<PlayingCard> initDeck() {
        List<PlayingCard> newDeck = new ArrayList<>();
        Arrays.stream(Suit.values())
                .forEach(suit -> Arrays.stream(Denomination.values()).forEach(denomination -> newDeck.add(new PlayingCard(suit, denomination))));

        Collections.shuffle(newDeck);
        return newDeck;
    }

    public PlayingCard draw() {
        PlayingCard card = deck.get(cardIdx++);
        if (cardIdx == NUM_OF_CARD) {
            getNewDeck();
        }

        return card;
    }
}
