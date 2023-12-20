import domain.Dealer;
import domain.Deck;
import domain.Participant;
import domain.Player;
import factory.StateFactory;
import userinterface.Answer;
import userinterface.Notice;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();
        ArrayList<Participant> participants = new ArrayList<>();
        participants.add(new Dealer("딜러", StateFactory.stateGenerate(deck.initDraw())));
        for (String name : Answer.askParticipants()) {
            participants.add(new Player(name, StateFactory.stateGenerate(deck.initDraw())));
        }

        System.out.println(Notice.noticePlayer(participants));
        System.out.println();

        participants.stream()
                .filter(participant -> participant instanceof Player)
                .map(player -> (Player) player)
                .forEach(Answer::askBettingAmt);

        System.out.println(Notice.noticeStart(participants));

        System.out.println(Notice.noticeParticipantsCards(participants));
    }
}
