package BasketballChat.BasketballChat.storage.game;

import BasketballChat.BasketballChat.dto.GameDto;
import BasketballChat.BasketballChat.exception.GameNotFoundException;
import BasketballChat.BasketballChat.model.game.Game;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Slf4j
public class GameStorageImpl implements GameStorage {
    private Map<Long, Game> games = new HashMap<>();
    private Long idGen = 1L;

    @Override
    public Game addGame(Game game) {
        game.setId(idGen);
        games.put(idGen, game);
        idGen++;
        log.info("Game c id {} успешн добавлен", game.getId());
        return game;
    }

    @Override
    public void deleteGame(Long id) {
        gameExist(id);
        games.remove(id);
        log.info("Game c id {} успешно удален", id);
    }

    @Override
    public Game getGameById(Long id) {
        gameExist(id);
        log.info("Game c id {} получен",id);
        return games.get(id);
    }

    @Override
    public Game updateGame(Game game, Long id) {
        gameExist(id);
        Game gameFromStorage=games.get(id);
        game.setId(id);
        if(game.getAddress()==null){
            game.setAddress(gameFromStorage.getAddress());
        }if(game.getDate()==null){
            game.setDate(gameFromStorage.getDate());
        }if(game.getMode()==null){
            game.setMode(gameFromStorage.getMode());
        }if(game.getSkillPlayer()==null){
            game.setSkillPlayer(gameFromStorage.getSkillPlayer());
        }
        log.info("Game c id {} успешно обновлен",id);
        return null;
    }

    public void gameExist(Long id) {
        if (!games.containsKey(id)) {
            log.warn("Game c таким id {} не найден", id);
            throw new GameNotFoundException("Game c таким id не найден");
        }
    }

    @Override
    public List<Game> searchByDate(LocalDate date) {
        List<Game> list=new ArrayList<>(games.values());
        return list.stream().filter(a->a.getDate().toLocalDate().equals(date)).collect(Collectors.toList());
    }

    @Override
    public List<Game> searchByAddress(String address) {
        List<Game> list=new ArrayList<>(games.values());
        return list.stream().filter(a->a.getAddress().equalsIgnoreCase(address)).collect(Collectors.toList());
    }

    @Override
    public List<Game> searchBySkillPlayer(String skillPlayer) {
        List<Game> list=new ArrayList<>(games.values());
        return list.stream().filter(a->a.getSkillPlayer().toString().equalsIgnoreCase(skillPlayer)).
                collect(Collectors.toList());
    }

    @Override
    public List<Game> searchByMode(String mode) {
        List<Game> list=new ArrayList<>(games.values());
        return list.stream().filter(a->a.getMode().toString().equalsIgnoreCase(mode)).collect(Collectors.toList());
    }
}
