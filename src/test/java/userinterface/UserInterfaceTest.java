package userinterface;

import domain.*;
import enums.Denomination;
import enums.Suit;
import factory.StateFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserInterfaceTest {

    @Test
    void noticePlayerTest() {
        List<Participant> participants = new ArrayList<>();
        participants.add(new Dealer("딜러"));
        participants.add(new Player("잭스"));
        participants.add(new Player("렉사이"));

        assertThat(Notice.noticePlayer(participants)).isEqualTo("잭스,렉사이");
    }

    @Test
    void noticeStartTest() {
        List<Participant> participants = new ArrayList<>();
        participants.add(new Dealer("딜러"));
        participants.add(new Player("트위스티드 페이티드"));
        participants.add(new Player("그레이브즈"));

        assertThat(Notice.noticeStart(participants)).isEqualTo("딜러와 트위스티드 페이티드, 그레이브즈에게 2장씩 카드를 나누었습니다.");
    }

    @Test
    void cardPrintTest() {
        PlayingCard card = new PlayingCard(Denomination.FIVE, Suit.SPADES);
        assertThat(card.toString()).isEqualTo("5스페이드");

        card = new PlayingCard(Denomination.ACE, Suit.HEARTS);
        assertThat(card.toString()).isEqualTo("ACE하트");

        card = new PlayingCard(Denomination.KING, Suit.DIAMONDS);
        assertThat(card.toString()).isEqualTo("K다이아몬드");
    }

    @Test
    void participantCardsTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.ACE, Suit.HEARTS)
                , new PlayingCard(Denomination.KING, Suit.DIAMONDS)
        );

        Player player = new Player("배선영");

        player.setState(StateFactory.stateGenerate(new Cards(cardList)));

        assertThat("ACE하트, K다이아몬드").isEqualTo(player.getcards());
    }

    @Test
    void noticeParticipantsCardsTest() {
        List<PlayingCard> cardList = Arrays.asList(
                new PlayingCard(Denomination.ACE, Suit.HEARTS)
                , new PlayingCard(Denomination.KING, Suit.DIAMONDS)
        );
        Player player = new Player("배선영");
        player.setState(StateFactory.stateGenerate(new Cards(cardList)));

        cardList = Arrays.asList(
                new PlayingCard(Denomination.NINE, Suit.HEARTS)
                , new PlayingCard(Denomination.KING, Suit.DIAMONDS)
        );
        Dealer dealer = new Dealer("딜러");
        dealer.setState(StateFactory.stateGenerate(new Cards(cardList)));


        System.out.println(Notice.noticeParticipantsCards(Arrays.asList(dealer, player)));
    }
}