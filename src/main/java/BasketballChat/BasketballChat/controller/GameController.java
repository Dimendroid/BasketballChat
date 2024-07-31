package BasketballChat.BasketballChat.controller;

import BasketballChat.BasketballChat.dto.GameDto;
import BasketballChat.BasketballChat.service.gameService.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<GameDto> addGame(@RequestBody GameDto gameDto) {
        log.info("получен POST запрос на добавление Game c id {}", gameDto.getId());
        return new ResponseEntity<>(gameService.addGame(gameDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGame(@PathVariable Long id) {
        log.info("получен DELETE запрос на удаление Game c id {}", id);
        gameService.deleteGame(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDto> getGameById(@PathVariable Long id) {
        log.info("получен GET запрос на получение Game c id {}", id);
        return new ResponseEntity<>(gameService.getGameById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GameDto> updateGame(@RequestBody GameDto gameDto,@PathVariable Long id) {
        log.info("получен Patch запрос на получение с Game c id {}", gameDto.getId());
        return new ResponseEntity<>(gameService.updateGame(gameDto,id), HttpStatus.OK);
    }
}