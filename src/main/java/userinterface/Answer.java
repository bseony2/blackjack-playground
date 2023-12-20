package userinterface;

import domain.Participant;
import domain.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Answer {
    public static Scanner sc = new Scanner(System.in);

    public static List<Participant> askParticipants() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        String[] participants = sc.nextLine().split(",");
        return Arrays.stream(participants).map(Player::new).collect(Collectors.toList());
    }

    public static int askBettingAmt(String name) {
        System.out.println(name + "의 배팅 금액은?");
        return sc.nextInt();
    }

    public static String askHit(String name) {
        System.out.println(name + "는 한장의 카드를 더 받겠습니까?");
        return sc.nextLine();
    }
}
