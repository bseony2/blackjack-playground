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
        ArrayList<Player> players = new ArrayList<>();
        participants.add(new Dealer("딜러", StateFactory.stateGenerate(deck.initDraw())));
        for (String name : Answer.askParticipants()) {
            Player player = new Player(name, StateFactory.stateGenerate(deck.initDraw()));
            participants.add(player);
            players.add(player);
        }


        System.out.println(Notice.noticePlayer(participants));
        System.out.println();

        players.forEach(Answer::askBettingAmt);

        System.out.println(Notice.noticeStart(participants));

        System.out.println(Notice.noticeParticipantsCards(participants));

        players.forEach(player -> Answer.getExtraCard(player, deck));
    }
}
