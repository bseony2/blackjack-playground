package nextstep.blackjack;

import nextstep.blackjack.domain.*;
import nextstep.blackjack.enums.GameResult;
import nextstep.blackjack.util.GameRule;
import nextstep.blackjack.util.GeneratorFactory;
import nextstep.blackjack.util.UserInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    Dealer dealer;
    List<Player> players;
    Deck deck;

    public void start() {

        this.dealer = new Dealer();
        
        this.players = getPlayers();

        deck = new Deck(GeneratorFactory.getNewCardDeck());

        batting();

        distributeCards();

        getExtraCards();

        printAllParticipantsScore();
        
        calProfit();
    }

    private void calProfit() {
        StringBuilder sb = new StringBuilder();
        for (Player player : players) {
            GameResult result = GameRule.getResult(dealer, player);

            double profit = GameRule.getProfit(result, player);
            dealer.setMoney(dealer.getMoney()-profit);
            sb.append(player.getName()).append(": ").append(profit - player.getBattingMoney()).append("\n");
        }
        System.out.println("## 최종 수익");
        System.out.println(dealer.getName() + ": " + dealer.getMoney());
        System.out.println(sb);


    }

    private void printAllParticipantsScore() {
        System.out.println(dealer.getAllCards() + "- 결과: " + dealer.getScore());

        for (Player player : players) {
            System.out.println(player.getAllCards() + "- 결과: " + player.getScore());
        }
    }

    private void getExtraCards() {
        for (Player player : players) {
            player.getExtraCard(this.deck);
        }

        if (dealer.getScore() <= 16) {
            System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
            dealer.addCard(deck.getNextCard());
        }
    }

    private void distributeCards() {
        Card dealderFirstCard = deck.getNextCard();
        this.dealer.addCard(dealderFirstCard);
        this.dealer.addCard(deck.getNextCard());

        for (Participant participant : this.players) {
            participant.addCard(deck.getNextCard());
            participant.addCard(deck.getNextCard());
        }

        System.out.println("딜러와 " + players.stream().map(Player::getName).collect(Collectors.joining(",")) + "에게 2장의 나누었습니다.");

        System.out.println("딜러: " + dealderFirstCard.toString());
        for (Player player : players) {
            System.out.println(player.getAllCards());
        }
    }

    private void batting() {
        int batMoney = UserInterface.askBatAmt(players);

        dealer.setMoney(batMoney);
    }

    private List<Player> getPlayers() {
        List<Player> result = new ArrayList<>();
        String[] names = UserInterface.askName();
        for (String name : names) {
            result.add(new Player(name));
        }

        return result;
    }
}
