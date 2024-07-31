package BasketballChat.BasketballChat.exception;

public class TeamNotFoundException extends IllegalArgumentException {
    public TeamNotFoundException(String s) {
        super(s);
    }
}
