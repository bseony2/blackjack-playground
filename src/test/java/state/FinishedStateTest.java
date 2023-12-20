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

public class FinishedStateTest {

    @Test
    void bustStateProfitTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.KING, Suit.HEARTS),
                new PlayingCard(Denomination.FIVE, Suit.CLUBS),
                new PlayingCard(Denomination.SEVEN, Suit.CLUBS)
        );

        State state = StateFactory.stateGenerate(new Cards(cardList));

        assertThat(state.profit(2500.5)).isEqualTo(0);
    }
    @Test
    void blackjackStateProfitTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.ACE, Suit.HEARTS),
                new PlayingCard(Denomination.KING, Suit.CLUBS)
        );

        State state = StateFactory.stateGenerate(new Cards(cardList));

        assertThat(state.profit(3000)).isEqualTo(4500);
    }

    @Test
    void stayStateProfitTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.ACE, Suit.HEARTS),
                new PlayingCard(Denomination.FOUR, Suit.CLUBS)
        );

        State state = StateFactory.stateGenerate(new Cards(cardList));

        state = state.stay();

        assertThat(state.profit(3000)).isEqualTo(6000);
    }

    @Test
    void bustStateIsFinishedTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.KING, Suit.HEARTS),
                new PlayingCard(Denomination.FOUR, Suit.CLUBS),
                new PlayingCard(Denomination.JACK, Suit.CLUBS)
        );

        State state = StateFactory.stateGenerate(new Cards(cardList));

        assertThat(state).isInstanceOf(Bust.class);
        assertThat(state.isFinished()).isTrue();
    }

    @Test
    void blackjackStateIsFinishedTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.ACE, Suit.HEARTS),
                new PlayingCard(Denomination.JACK, Suit.CLUBS)
        );

        State state = StateFactory.stateGenerate(new Cards(cardList));

        assertThat(state).isInstanceOf(Blackjack.class);
        assertThat(state.isFinished()).isTrue();
    }

    @Test
    void stayStateIsFinishedTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.NINE, Suit.HEARTS),
                new PlayingCard(Denomination.JACK, Suit.CLUBS)
        );

        State state = StateFactory.stateGenerate(new Cards(cardList));
        state = state.stay();

        assertThat(state).isInstanceOf(Stay.class);
        assertThat(state.isFinished()).isTrue();
    }
}
