package rule;

import domain.Cards;
import domain.Dealer;
import domain.Player;
import domain.PlayingCard;
import enums.Denomination;
import enums.GameResult;
import enums.ResultState;
import enums.Suit;
import factory.StateFactory;
import org.junit.jupiter.api.Test;
import state.Blackjack;
import state.Bust;
import state.Stay;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameRuleTest {

    @Test
    void resultStateStayTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.JACK, Suit.HEARTS)
                , new PlayingCard(Denomination.KING, Suit.DIAMONDS)
        );
        Player player = new Player("배선영", StateFactory.stateGenerate(new Cards(cardList)));

        player.stay();
        assertThat(player.state instanceof Stay).isTrue();
        assertThat(ResultState.getResultState(player)).isSameAs(ResultState.STAY);
    }

    @Test
    void resultStateBustTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.JACK, Suit.HEARTS)
                , new PlayingCard(Denomination.KING, Suit.DIAMONDS)
                , new PlayingCard(Denomination.THREE, Suit.DIAMONDS)
        );
        Player player = new Player("배선영", StateFactory.stateGenerate(new Cards(cardList)));

        assertThat(player.state instanceof Bust).isTrue();
        assertThat(ResultState.getResultState(player)).isSameAs(ResultState.BUST);
    }

    @Test
    void resultStateBlackjackTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.JACK, Suit.HEARTS)
                , new PlayingCard(Denomination.ACE, Suit.DIAMONDS)
        );
        Player player = new Player("배선영", StateFactory.stateGenerate(new Cards(cardList)));

        assertThat(player.state instanceof Blackjack).isTrue();
        assertThat(ResultState.getResultState(player)).isSameAs(ResultState.BLACKJACK);
    }

    @Test
    void highSchoreThanDealerTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.NINE, Suit.HEARTS)
                , new PlayingCard(Denomination.KING, Suit.DIAMONDS)
        );
        Dealer dealer = new Dealer("딜러", StateFactory.stateGenerate(new Cards(cardList)));

        cardList = Arrays.asList(
                new PlayingCard(Denomination.JACK, Suit.HEARTS)
                , new PlayingCard(Denomination.KING, Suit.DIAMONDS)
        );
        Player player = new Player("배선영", StateFactory.stateGenerate(new Cards(cardList)));

        assertThat(GameRule.getResult(dealer, player)).isSameAs(GameResult.WIN);
    }

    @Test
    void dealerBustWinTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.NINE, Suit.HEARTS)
                , new PlayingCard(Denomination.KING, Suit.DIAMONDS)
                , new PlayingCard(Denomination.FOUR, Suit.DIAMONDS)
        );
        Dealer dealer = new Dealer("딜러", StateFactory.stateGenerate(new Cards(cardList)));

        cardList = Arrays.asList(
                new PlayingCard(Denomination.JACK, Suit.HEARTS)
                , new PlayingCard(Denomination.KING, Suit.DIAMONDS)
        );
        Player player = new Player("배선영", StateFactory.stateGenerate(new Cards(cardList)));

        player.stay();
        assertThat(GameRule.getResult(dealer, player)).isSameAs(GameResult.WIN);
    }

    @Test
    void playerBustTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.NINE, Suit.HEARTS)
                , new PlayingCard(Denomination.KING, Suit.DIAMONDS)
                , new PlayingCard(Denomination.FOUR, Suit.DIAMONDS)
        );
        Player player = new Player("배선영", StateFactory.stateGenerate(new Cards(cardList)));

        cardList = Arrays.asList(
                new PlayingCard(Denomination.JACK, Suit.HEARTS)
                , new PlayingCard(Denomination.KING, Suit.DIAMONDS)
        );
        Dealer dealer = new Dealer("딜러", StateFactory.stateGenerate(new Cards(cardList)));

        assertThat(GameRule.getResult(dealer, player)).isSameAs(GameResult.LOSE);
    }

    @Test
    void blackjackDrawTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.ACE, Suit.HEARTS)
                , new PlayingCard(Denomination.KING, Suit.DIAMONDS)
        );
        Player player = new Player("배선영", StateFactory.stateGenerate(new Cards(cardList)));

        cardList = Arrays.asList(
                new PlayingCard(Denomination.QUEEN, Suit.HEARTS)
                , new PlayingCard(Denomination.ACE, Suit.DIAMONDS)
        );
        Dealer dealer = new Dealer("딜러", StateFactory.stateGenerate(new Cards(cardList)));

        assertThat(GameRule.getResult(dealer, player)).isSameAs(GameResult.DRAW);
    }

    @Test
    void sameScoreTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.NINE, Suit.HEARTS)
                , new PlayingCard(Denomination.SEVEN, Suit.DIAMONDS)
        );
        Player player = new Player("배선영", StateFactory.stateGenerate(new Cards(cardList)));

        cardList = Arrays.asList(
                new PlayingCard(Denomination.EIGHT, Suit.HEARTS)
                , new PlayingCard(Denomination.EIGHT, Suit.DIAMONDS)
        );
        Dealer dealer = new Dealer("딜러", StateFactory.stateGenerate(new Cards(cardList)));

        player.stay();
        dealer.stay();

        assertThat(GameRule.getResult(dealer, player)).isSameAs(GameResult.DRAW);
    }

    @Test
    void lowerScoreTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.TWO, Suit.HEARTS)
                , new PlayingCard(Denomination.SEVEN, Suit.DIAMONDS)
        );
        Player player = new Player("배선영", StateFactory.stateGenerate(new Cards(cardList)));

        cardList = Arrays.asList(
                new PlayingCard(Denomination.EIGHT, Suit.HEARTS)
                , new PlayingCard(Denomination.EIGHT, Suit.DIAMONDS)
        );
        Dealer dealer = new Dealer("딜러", StateFactory.stateGenerate(new Cards(cardList)));

        player.stay();
        dealer.stay();

        assertThat(GameRule.getResult(dealer, player)).isSameAs(GameResult.LOSE);
    }

    @Test
    void winProfitTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.TWO, Suit.HEARTS)
                , new PlayingCard(Denomination.SEVEN, Suit.DIAMONDS)
        );
        Player player = new Player("배선영", StateFactory.stateGenerate(new Cards(cardList)));
        player.setBetAmt(10000);
        double profit = GameRule.profit(player, GameResult.WIN);
        assertThat(20000.0).isEqualTo(profit);
    }

    @Test
    void drawProfitTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.TWO, Suit.HEARTS)
                , new PlayingCard(Denomination.SEVEN, Suit.DIAMONDS)
        );
        Player player = new Player("배선영", StateFactory.stateGenerate(new Cards(cardList)));
        player.setBetAmt(10000);
        double profit = GameRule.profit(player, GameResult.DRAW);
        assertThat(0.0).isEqualTo(profit);
    }

    @Test
    void loseProfitTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.TWO, Suit.HEARTS)
                , new PlayingCard(Denomination.SEVEN, Suit.DIAMONDS)
        );
        Player player = new Player("배선영", StateFactory.stateGenerate(new Cards(cardList)));
        player.setBetAmt(10000);
        double profit = GameRule.profit(player, GameResult.LOSE);
        assertThat(-20000.0).isEqualTo(profit);
    }
}