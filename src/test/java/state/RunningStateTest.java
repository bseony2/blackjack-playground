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

public class RunningStateTest {
    @Test
    void hitToBustTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.KING, Suit.HEARTS),
                new PlayingCard(Denomination.FIVE, Suit.CLUBS)
        );

        State result = StateFactory.stateGenerate(new Cards(cardList));

        result = result.draw(new PlayingCard(Denomination.SEVEN, Suit.DIAMONDS));

        assertThat(result).isInstanceOf(Bust.class);
    }

    @Test
    void hitToHitTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.KING, Suit.HEARTS),
                new PlayingCard(Denomination.FIVE, Suit.CLUBS)
        );

        State result = StateFactory.stateGenerate(new Cards(cardList));

        result = result.draw(new PlayingCard(Denomination.ACE, Suit.DIAMONDS));

        assertThat(result).isInstanceOf(Hit.class);
    }

    @Test
    void hitToStayTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.KING, Suit.HEARTS),
                new PlayingCard(Denomination.FIVE, Suit.CLUBS)
        );

        State state = StateFactory.stateGenerate(new Cards(cardList));

        State result = state.stay();

        assertThat(result).isInstanceOf(Stay.class);
    }

    @Test
    void runningStateIsFinishedTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.KING, Suit.HEARTS),
                new PlayingCard(Denomination.FIVE, Suit.CLUBS)
        );

        State state = StateFactory.stateGenerate(new Cards(cardList));

        assertThat(state.isFinished()).isFalse();
    }

    @Test
    void RunningStateProfitTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.KING, Suit.HEARTS),
                new PlayingCard(Denomination.FIVE, Suit.CLUBS)
        );

        State state = StateFactory.stateGenerate(new Cards(cardList));

        assertThat(state.profit(2500.5)).isEqualTo(5001);
    }
}
