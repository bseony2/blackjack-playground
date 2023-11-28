package nextstep.blackjack.util;

import nextstep.blackjack.domain.Card;
import nextstep.blackjack.domain.Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneratorFactory {
    public static List<Card> getNewCardDeck() {
        List<Card> newDeck = new ArrayList<>();
        for(int i=0; i< Deck.TOTAL_CARD_QNTY; i++) {
            newDeck.add(new Card(i));
        }

        Collections.shuffle(newDeck);

        return newDeck;
    }
}
