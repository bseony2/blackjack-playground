package nextstep.blackjack.enums;

public enum UserAnswer {
    YES(),
    NO();

    public static UserAnswer getAnswer(String s) {
        if (s.equals("y")) {
            return YES;
        }
        return NO;
    }
}
