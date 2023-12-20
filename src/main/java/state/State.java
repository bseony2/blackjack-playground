package state;

import domain.Cards;
import domain.PlayingCard;

public interface State {

    State draw(PlayingCard card);

    State stay();

    boolean isFinished();

    Cards cards();

    double profit(double betAmt);
}
