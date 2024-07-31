package BasketballChat.BasketballChat.service.gameService;

import BasketballChat.BasketballChat.dto.GameDto;
import org.springframework.http.HttpStatusCode;

public interface GameService {
    GameDto addGame(GameDto gameDto);

    void deleteGame(Long id);

    GameDto getGameById(Long id);

    GameDto updateGame(GameDto gameDto,Long id);
}
