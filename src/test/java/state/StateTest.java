package state;

import domain.Cards;
import domain.PlayingCard;
import enums.Denomination;
import enums.Suit;
import factory.StateFactory;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StateTest {

    @Test
    void blackjackGenerateTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.ACE, Suit.CLUBS),
                new PlayingCard(Denomination.KING, Suit.CLUBS)
        );

        State result = StateFactory.stateGenerate(new Cards(cardList));

        assertThat(result).isInstanceOf(Blackjack.class);
    }

    @Test
    void blackjackGenerateWithAceTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.KING, Suit.HEARTS),
                new PlayingCard(Denomination.FIVE, Suit.CLUBS)
        );

        State result = StateFactory.stateGenerate(new Cards(cardList));

        assertThat(result).isInstanceOf(Hit.class);
    }
}