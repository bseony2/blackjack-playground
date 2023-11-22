package nextstep.blackjack.util;

import nextstep.blackjack.domain.Card;
import nextstep.blackjack.domain.Deck;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneratorFactory {
    public static List<Card> getNewCardDeck() {
        List<Card> newDeck = new ArrayList<>();
        for(int i=0; i< Deck.TOTAL_CARD_QNTY; i++) {
            newDeck.add(new Card(i));
        }

        Random random = new Random();
        for(int i=0; i<Deck.TOTAL_CARD_QNTY; i++) {
            int nextIdx = random.nextInt(Deck.TOTAL_CARD_QNTY);
            Card temp = newDeck.get(i);
            newDeck.set(i, newDeck.get(nextIdx));
            newDeck.set(nextIdx, temp);
        }

        return newDeck;
    }
}
