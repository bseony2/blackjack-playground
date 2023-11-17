package nextstep.blackjack.domain;

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
}
