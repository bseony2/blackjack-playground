package domain;

public class Dealer extends Participant{
    public Dealer(String name) {
        super(name);
    }

    public String showOneCard() {
        return this.state.cards().stream()
                .findAny()
                .map(PlayingCard::toString)
                .orElse("카드 없습니다!");
    }
}
