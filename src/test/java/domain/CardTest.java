package domain;

import enums.Denomination;
import enums.Suit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static domain.Deck.NUM_OF_PLAYING_CARD;
import static org.assertj.core.api.Assertions.assertThat;

class CardTest {

    @Test
    void CardEqualsTest() {
        PlayingCard card1 = new PlayingCard(Denomination.ACE, Suit.CLUBS);
        PlayingCard card2 = new PlayingCard(Denomination.ACE, Suit.CLUBS);
        PlayingCard card3 = new PlayingCard(Denomination.ACE, Suit.HEARTS);

        assertThat(card1).isEqualTo(card2);
        assertThat(card1).isNotEqualTo(card3);
    }

    @Test
    void deckGenerateTest() {
        Deck deck = new Deck();
        List<PlayingCard> cardList = new ArrayList<>();

        for (int i = 0; i < NUM_OF_PLAYING_CARD; i++) {
            PlayingCard card = deck.draw();
            assertThat(cardList).doesNotContain(card);
            cardList.add(card);
        }

    }
}