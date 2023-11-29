package nextstep.blackjack.util;

import nextstep.blackjack.domain.Card;
import nextstep.blackjack.domain.Dealer;
import nextstep.blackjack.domain.Participant;
import nextstep.blackjack.domain.Player;
import nextstep.blackjack.enums.CardNumber;
import nextstep.blackjack.enums.GameResult;
import nextstep.blackjack.enums.Suit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameRuleTest {

    @Test
    @DisplayName("플레이어 점수가 21이 넘으면 무조건 패배한다.")
    void playerOverThanTwentyOneTest() {
        Participant dealer = new Dealer();
        Participant player = new Player("sh");

        dealer.cardList.add(new Card(Suit.DIAMOND, CardNumber.TWO));
        dealer.cardList.add(new Card(Suit.HEART, CardNumber.TWO));

        player.cardList.add(new Card(Suit.DIAMOND, CardNumber.KING));
        player.cardList.add(new Card(Suit.SPADE, CardNumber.FIVE));
        player.cardList.add(new Card(Suit.SPADE, CardNumber.SEVEN));

        GameResult result = GameRule.getResult(dealer, player);

        assertThat(GameResult.isLose(result)).isTrue();
    }

    @Test
    @DisplayName("플레이어 점수가 21 이하이고 딜러 점수가 21 점이 넘으면 플레이어가 무조건 승리한다")
    void delearOverThanTwentyOneTest() {
        Participant dealer = new Dealer();
        Participant player = new Player("sy");

        player.cardList.add(new Card(Suit.DIAMOND, CardNumber.TWO));
        player.cardList.add(new Card(Suit.HEART, CardNumber.TWO));

        dealer.cardList.add(new Card(Suit.DIAMOND, CardNumber.KING));
        dealer.cardList.add(new Card(Suit.SPADE, CardNumber.FIVE));
        dealer.cardList.add(new Card(Suit.SPADE, CardNumber.SEVEN));

        GameResult result = GameRule.getResult(dealer, player);

        assertThat(GameResult.isWin(result)).isTrue();
    }

    @Test
    @DisplayName("두 참가자가 점수가 21 이하이면 점수가 높은쪽이 이긴다.")
    void highScoreWinTest() {
        Participant dealer = new Dealer();
        Participant player = new Player("hj");

        dealer.cardList.add(new Card(Suit.DIAMOND, CardNumber.TWO));
        dealer.cardList.add(new Card(Suit.HEART, CardNumber.TWO));

        player.cardList.add(new Card(Suit.DIAMOND, CardNumber.KING));
        player.cardList.add(new Card(Suit.SPADE, CardNumber.FIVE));

        GameResult result = GameRule.getResult(dealer, player);

        assertThat(GameResult.isWin(result)).isTrue();
    }

    @Test
    @DisplayName("점수가 같으면 무승부")
    void drawTest() {
        Participant dealer = new Dealer();
        Participant player = new Player("ty");

        dealer.cardList.add(new Card(Suit.DIAMOND, CardNumber.FOUR));
        dealer.cardList.add(new Card(Suit.HEART, CardNumber.TWO));

        player.cardList.add(new Card(Suit.DIAMOND, CardNumber.THREE));
        player.cardList.add(new Card(Suit.SPADE, CardNumber.THREE));

        GameResult result = GameRule.getResult(dealer, player);

        assertThat(GameResult.isDraw(result)).isTrue();
    }

    @Test
    @DisplayName("시작 카드가 블랙잭이 되어서 이기면 배팅액의 1.5배를 받는다")
    void blackjackWinMoney() {
        Player p = new Player("faker");
        p.setBattingMoney(1000);
        p.cardList.add(new Card(Suit.CLUB, CardNumber.FOUR));
        p.cardList.add(new Card(Suit.CLUB, CardNumber.THREE));
        double resultMoney = GameRule.getProfit(GameResult.WIN, p);

        assertThat(resultMoney).isEqualTo(1500);
    }

    @Test
    @DisplayName("게임에 승리했으면 배팅액의 2배를 받음")
    void getWinMoney() {
        Player p = new Player("faker");
        p.setBattingMoney(1000);
        p.cardList.add(new Card(Suit.CLUB, CardNumber.FIVE));
        p.cardList.add(new Card(Suit.CLUB, CardNumber.FOUR));
        p.cardList.add(new Card(Suit.CLUB, CardNumber.THREE));
        double resultMoney = GameRule.getProfit(GameResult.WIN, p);

        assertThat(resultMoney).isEqualTo(2000);
    }

    @Test
    @DisplayName("게임에 패배하면 돈 다 잃음")
    void getLoseMoney() {
        Player p = new Player("guma");
        p.setBattingMoney(1000);
        double resultMoney = GameRule.getProfit(GameResult.LOSE, p);

        assertThat(resultMoney).isEqualTo(-1000);
    }

    @Test
    @DisplayName("비기면 변동 없음")
    void getDrawMoney() {
        Player p = new Player("zeus");
        int batMoney = 1000;
        p.setBattingMoney(batMoney);
        double resultMoney = GameRule.getProfit(GameResult.DRAW, p);

        assertThat(resultMoney).isEqualTo(batMoney);
    }

}