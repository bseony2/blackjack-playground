package nextstep.blackjack.util;

import nextstep.blackjack.domain.Player;
import nextstep.blackjack.enums.UserAnswer;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    public static Scanner sc = new Scanner(System.in);

    public static String[] askName() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return sc.nextLine().split(",");
    }

    public static int askBatAmt(List<Player> players) {

        int totalAmt = 0;
        for (Player player : players) {

            int batAmt = askBatAmt(player);
            totalAmt += batAmt;
        }

        return totalAmt;
    }
    private static int askBatAmt(Player player) {
        int amt = 0;
        try {
            System.out.println(player.getName() + "의 배팅 금액은?");
            amt = sc.nextInt();
        } catch (Error e) {
            System.out.println(e.getMessage());
            askBatAmt(player);
        }
        player.setBattingMoney(amt);
        return amt;
    }

    public static UserAnswer askExtrCard(Player player) {
        System.out.println(player.getName() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        String answer = sc.next();
        return UserAnswer.getAnswer(answer);
    }
}
