package state;

import domain.Cards;
import domain.PlayingCard;

public class Hit extends Running{
    public Hit(Cards cards) {
        super(cards);
    }

    @Override
    public State draw(PlayingCard card) {
        return null;
    }

    @Override
    public State stay() {
        return null;
    }
}
