package nextstep.blackjack.domain;

import nextstep.blackjack.enums.UserAnswer;
import nextstep.blackjack.util.UserInterface;

public class Player extends Participant{

    int battingMoney = 0;

    public Player(String name) {
        super(name);
    }

    public int getBattingMoney() {
        return battingMoney;
    }

    public void setBattingMoney(int battingMoney) {
        this.battingMoney = battingMoney;
    }

    public void getExtraCard(Deck deck) {
        while (this.getScore() < 21 && UserInterface.askExtrCard(this) == UserAnswer.YES) {

            this.addCard(deck.getNextCard());
            System.out.println(getAllCards());
        }
    }
}
