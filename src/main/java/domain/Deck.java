package domain;

import enums.Denomination;
import enums.Suit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

    private static final int NUM_OF_PLAYING_CARD = 52;
    private List<PlayingCard> deck;
    private int idx;

    public Deck() {
        initDeck();
    }

    private void initDeck() {
        this.deck = getNewDeck();
        this.idx = 0;
    }

    private List<PlayingCard> getNewDeck() {
        ArrayList<PlayingCard> newDeck = new ArrayList<>();
        Arrays.stream(Denomination.values()).forEach(denomination -> Arrays.stream(Suit.values()).forEach(suit -> newDeck.add(new PlayingCard(denomination, suit))));
        Collections.shuffle(newDeck);

        return newDeck;
    }

    public PlayingCard draw() {
        PlayingCard card = this.deck.get(idx++);
        if (idx == NUM_OF_PLAYING_CARD) {
            initDeck();
        }

        return card;
    }
}
