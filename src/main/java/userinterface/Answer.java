package userinterface;

import domain.Player;

import java.util.Scanner;

public class Answer {
    public static Scanner sc = new Scanner(System.in);

    public static String[] askParticipants() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return sc.nextLine().split(",");
    }

    public static void askBettingAmt(Player player) {
        System.out.println(player.getName() + "의 배팅 금액은?");
        player.setBetAmt(sc.nextInt());
    }

    public static String askHit(String name) {
        System.out.println(name + "는 한장의 카드를 더 받겠습니까?");
        return sc.nextLine();
    }
}
