package nextstep.blackjack.domain;

public class Dealer extends Participant{

    double money;

    public Dealer() {
        super("딜러");
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
