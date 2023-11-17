package nextstep.blackjack.domain;

import nextstep.blackjack.enums.CardNumber;
import nextstep.blackjack.enums.Suit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CardTest {

    @Test
    @DisplayName("문양 생성에 성공하는 테스트")
    void Suit_success_test() {
        assertThat(Suit.CLUB).isEqualTo(Suit.getSuit(0));
        assertThat(Suit.HEART).isEqualTo(Suit.getSuit(1));
        assertThat(Suit.DIAMOND).isEqualTo(Suit.getSuit(2));
        assertThat(Suit.SPADE).isEqualTo(Suit.getSuit(3));
    }

    @Test
    @DisplayName("문양 생성에 실패하는 테스트")
    void Suit_fail_test() {
        assertThatThrownBy(() -> Suit.getSuit(4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("문양 인자값을 확인하시기 바랍니다.");
    }

    @Test
    @DisplayName("카드 번호 테스트")
    void cardNumberTest() {
        assertThat(CardNumber.getCardNumberByIndex(0)).isEqualTo(CardNumber.ACE);
        assertThat(CardNumber.getCardNumberByIndex(1)).isEqualTo(CardNumber.TWO);
        assertThat(CardNumber.getCardNumberByIndex(2)).isEqualTo(CardNumber.THREE);
        assertThat(CardNumber.getCardNumberByIndex(3)).isEqualTo(CardNumber.FOUR);
        assertThat(CardNumber.getCardNumberByIndex(4)).isEqualTo(CardNumber.FIVE);
        assertThat(CardNumber.getCardNumberByIndex(5)).isEqualTo(CardNumber.SIX);
        assertThat(CardNumber.getCardNumberByIndex(6)).isEqualTo(CardNumber.SEVEN);
        assertThat(CardNumber.getCardNumberByIndex(7)).isEqualTo(CardNumber.EIGHT);
        assertThat(CardNumber.getCardNumberByIndex(8)).isEqualTo(CardNumber.NINE);
        assertThat(CardNumber.getCardNumberByIndex(9)).isEqualTo(CardNumber.TEN);
        assertThat(CardNumber.getCardNumberByIndex(10)).isEqualTo(CardNumber.JACK);
        assertThat(CardNumber.getCardNumberByIndex(11)).isEqualTo(CardNumber.QUEEN);
        assertThat(CardNumber.getCardNumberByIndex(12)).isEqualTo(CardNumber.KING);
    }
}
