package domain;

import enums.Denomination;
import enums.Suit;
import factory.CardFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

    public static final int NUM_OF_PLAYING_CARD = 52;
    private List<PlayingCard> deck;
    private int idx;

    public Deck() {
        initDeck();
    }

    private void initDeck() {
        this.deck = CardFactory.getNewDeck();
        this.idx = 0;
    }

    public PlayingCard draw() {
        PlayingCard card = this.deck.get(idx++);
        if (idx == NUM_OF_PLAYING_CARD) {
            initDeck();
        }

        return card;
    }
}
