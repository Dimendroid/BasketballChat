package BasketballChat.BasketballChat.storage.game;

import BasketballChat.BasketballChat.model.game.Game;

public interface GameStorage {
    Game addGame(Game game);

    void deleteGame(Long id);

    Game getGameById(Long id);

    Game updateGame(Game game,Long id);
}
