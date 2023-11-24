package nextstep.blackjack.domain;

import nextstep.blackjack.enums.CardNumber;
import nextstep.blackjack.enums.Suit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ParticipantTest {

    @Test
    void twoAceScoreTest() {
        Participant p = new Participant();
        p.addCard(new Card(Suit.CLUB, CardNumber.ACE));
        p.addCard(new Card(Suit.HEART, CardNumber.ACE));

        Assertions.assertThat(p.getScore()).isEqualTo(12);
    }

    @Test
    void oneAceAndOverThanElevenScoreTest() {
        Participant p = new Participant();
        p.addCard(new Card(Suit.CLUB, CardNumber.KING));
        p.addCard(new Card(Suit.CLUB, CardNumber.ACE));
        p.addCard(new Card(Suit.CLUB, CardNumber.FOUR));

        Assertions.assertThat(p.getScore()).isEqualTo(15);
    }

    @Test
    void oneAceAndlessThanElevenScoreTest() {
        Participant p = new Participant();
        p.addCard(new Card(Suit.CLUB, CardNumber.KING));
        p.addCard(new Card(Suit.CLUB, CardNumber.ACE));

        Assertions.assertThat(p.getScore()).isEqualTo(21);
    }
}