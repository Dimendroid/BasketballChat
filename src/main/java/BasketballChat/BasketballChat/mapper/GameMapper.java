package BasketballChat.BasketballChat.mapper;

import BasketballChat.BasketballChat.dto.GameDto;
import BasketballChat.BasketballChat.model.game.Game;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<GameDto> listToListDto(List<Game> list){
        return list.stream().map(GameMapper::gameToGameDto).collect(Collectors.toList());
    }
    public List<Game> listDtoToList (List<GameDto> list){
        return list.stream().map(GameMapper::gameDtoToGame).collect(Collectors.toList());
    }
}
