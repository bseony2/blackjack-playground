package state;

import domain.Cards;
import domain.PlayingCard;
import factory.StateFactory;

import java.util.ArrayList;
import java.util.List;

public class Hit extends Running{
    public Hit(Cards cards) {
        super(cards);
    }

    @Override
    public State draw(PlayingCard card) {
        List<PlayingCard> cardList = new ArrayList<>();
        cardList.add(card);
        for (PlayingCard playingCard : cards) {
            cardList.add(playingCard);
        }

        return StateFactory.stateGenerate(new Cards(cardList));
    }

    @Override
    public State stay() {
        return new Stay(cards());
    }
}
