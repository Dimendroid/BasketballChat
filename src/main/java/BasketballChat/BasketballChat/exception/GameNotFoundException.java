package BasketballChat.BasketballChat.exception;

public class GameNotFoundException extends IllegalArgumentException{
    public GameNotFoundException(String s) {
        super(s);
    }
}
