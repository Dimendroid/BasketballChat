package BasketballChat.BasketballChat.mapper;

import BasketballChat.BasketballChat.dto.GameDto;
import BasketballChat.BasketballChat.model.game.Game;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GameMapper {
    public GameDto gameToGameDto(Game game) {
        return new GameDto(game.getId(),
                game.getDate(),
                game.getAddress(),
                game.getSkillPlayer(),
                game.getMode());
    }

    public Game gameDtoToGame(GameDto gameDto) {
        return new Game(gameDto.getId(),
                gameDto.getDate(),
                gameDto.getAddress(),
                gameDto.getSkillPlayer(),
                gameDto.getMode());
    }
}
