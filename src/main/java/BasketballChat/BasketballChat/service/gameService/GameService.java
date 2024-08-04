package BasketballChat.BasketballChat.service.gameService;

import BasketballChat.BasketballChat.dto.GameDto;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDate;
import java.util.List;

public interface GameService {
    GameDto addGame(GameDto gameDto);

    void deleteGame(Long id);

    GameDto getGameById(Long id);

    GameDto updateGame(GameDto gameDto,Long id);

    List<GameDto> searchGame(LocalDate date, String address, String skillPlayer, String mode);
}
