package nextstep.blackjack.util;

import java.util.Scanner;

public class UserInterface {
    public static Scanner sc = new Scanner(System.in);

    public static String[] askName() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return sc.nextLine().split(",");
    }

    public static int askBatAmt(String name) {
        int amt = 0;
        try {
            System.out.println(name + "의 배팅 금액은?");
            amt = sc.nextInt();
        } catch (Error e) {
            System.out.println(e.getMessage());
            askBatAmt(name);
        }
        return amt;
    }
}
