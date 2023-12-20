package userinterface;

import domain.Dealer;
import domain.Participant;
import domain.Player;

import java.util.List;
import java.util.stream.Collectors;

public class Notice {
    public static String noticePlayer(List<Participant> participants) {
        return participants.stream()
                .filter(participant -> participant instanceof Player)
                .map(Participant::getName)
                .collect(Collectors.joining(","));
    }

    public static String noticeStart(List<Participant> participants) {
        String answer = "딜러와 ";
        answer += participants.stream()
                .filter(participant -> participant instanceof Player)
                .map(Participant::getName)
                .collect(Collectors.joining(", "));
        answer += "에게 2장씩 카드를 나누었습니다.";

        return answer;
    }

    public static String noticeParticipantsCards(List<Participant> participants) {
        StringBuilder sb = new StringBuilder();
        Dealer dealer = participants.stream()
                .filter(participant -> participant instanceof Dealer)
                .map(d -> (Dealer) d)
                .findFirst()
                .orElse(new Dealer("딜러"));
        
        sb.append("딜러: ").append(dealer.showOneCard()).append("\n");

        participants.stream()
                .filter(participant -> participant instanceof Player)
                .map(participant -> (Player) participant)
                .forEach(participant -> sb.append(participant.getName())
                                            .append("카드: ")
                                            .append(participant.getcards())
                                            .append("\n"));

        return sb.toString();
    }
}
