package nextstep.blackjack.domain;

import nextstep.blackjack.enums.CardNumber;
import nextstep.blackjack.enums.Suit;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantTest {

    @Test
    void twoAceScoreTest() {
        Participant p = new Player("shy");
        p.addCard(new Card(Suit.CLUB, CardNumber.ACE));
        p.addCard(new Card(Suit.HEART, CardNumber.ACE));

        assertThat(p.getScore()).isEqualTo(12);
    }

    @Test
    void oneAceAndOverThanElevenScoreTest() {
        Participant p = new Player("oner");
        p.addCard(new Card(Suit.CLUB, CardNumber.KING));
        p.addCard(new Card(Suit.CLUB, CardNumber.ACE));
        p.addCard(new Card(Suit.CLUB, CardNumber.FOUR));

        assertThat(p.getScore()).isEqualTo(15);
    }

    @Test
    void oneAceAndlessThanElevenScoreTest() {
        Participant p = new Player("piglet");
        p.addCard(new Card(Suit.CLUB, CardNumber.KING));
        p.addCard(new Card(Suit.CLUB, CardNumber.ACE));

        assertThat(p.getScore()).isEqualTo(21);
    }
}