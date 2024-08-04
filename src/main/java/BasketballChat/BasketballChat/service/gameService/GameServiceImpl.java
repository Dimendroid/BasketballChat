package BasketballChat.BasketballChat.service.gameService;

import BasketballChat.BasketballChat.dto.GameDto;
import BasketballChat.BasketballChat.mapper.GameMapper;
import BasketballChat.BasketballChat.model.game.Game;
import BasketballChat.BasketballChat.storage.game.GameStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
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
    public GameDto updateGame(GameDto gameDto, Long id) {
        Game game = GameMapper.gameDtoToGame(gameDto);
        return GameMapper.gameToGameDto(game);
    }

    @Override
    public List<GameDto> searchGame(LocalDate date, String address, String skillPlayer, String mode) {
        List<GameDto> list = new ArrayList<>();
        if (date != null) {
            list.addAll(GameMapper.listToListDto(gameStorage.searchByDate(date)));
        }
        if (address != null && list.isEmpty()) {
            list.addAll(GameMapper.listToListDto(gameStorage.searchByAddress(address)));
        } else if (address != null) {
            list = filterByAddress(list, address);
        }
        if (skillPlayer != null && list.isEmpty()) {
            list.addAll(GameMapper.listToListDto(gameStorage.searchBySkillPlayer(skillPlayer)));
        } else if (skillPlayer != null) {
            list = filterBySkillPlayer(list, skillPlayer);
        }
        if (mode != null&&list.isEmpty()) {
            list.addAll(GameMapper.listToListDto(gameStorage.searchByMode(mode)));
        } else if (mode != null) {
            list=filterByMode(list,mode);
        }
        log.info("получен список Game c date {}, address {}, skillPlayer {}, mode {}",date,address,skillPlayer,mode);
        return list;
    }

    private List<GameDto> filterByAddress(List<GameDto> list, String address) {
        return list.stream().filter(a -> a.getAddress().equalsIgnoreCase(address)).collect(Collectors.toList());
    }

    private List<GameDto> filterBySkillPlayer(List<GameDto> list, String skillPlayer) {
        return list.stream().filter(a -> a.getSkillPlayer().toString().equalsIgnoreCase(skillPlayer)).
                collect(Collectors.toList());
    }
    private List<GameDto> filterByMode(List<GameDto> list,String mode){
        return list.stream().filter(a->a.getMode().toString().equalsIgnoreCase(mode)).collect(Collectors.toList());
    }
}
