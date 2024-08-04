package BasketballChat.BasketballChat.storage.game;

import BasketballChat.BasketballChat.model.game.Game;

import java.time.LocalDate;
import java.util.List;

public interface GameStorage {
    Game addGame(Game game);

    void deleteGame(Long id);

    Game getGameById(Long id);

    Game updateGame(Game game,Long id);
    List<Game> searchByDate(LocalDate date);
    List<Game> searchByAddress(String address);
    List<Game> searchBySkillPlayer(String skillPlayer);
    List<Game> searchByMode(String mode);
}
