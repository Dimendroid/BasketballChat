package BasketballChat.BasketballChat.service.gameService;

import BasketballChat.BasketballChat.dto.GameDto;
import BasketballChat.BasketballChat.mapper.GameMapper;
import BasketballChat.BasketballChat.model.game.Game;
import BasketballChat.BasketballChat.storage.game.GameStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    private final GameStorage gameStorage;

    @Autowired
    public GameServiceImpl(GameStorage gameStorage) {
        this.gameStorage = gameStorage;
    }

    @Override
    public GameDto addGame(GameDto gameDto) {
        Game game = GameMapper.gameDtoToGame(gameDto);
        return GameMapper.gameToGameDto(game);
    }

    @Override
    public void deleteGame(Long id) {
        gameStorage.deleteGame(id);
    }

    @Override
    public GameDto getGameById(Long id) {
        return GameMapper.gameToGameDto(gameStorage.getGameById(id));
    }

    @Override
    public GameDto updateGame(GameDto gameDto,Long id) {
        Game game=GameMapper.gameDtoToGame(gameDto);
        return GameMapper.gameToGameDto(game);
    }
}
