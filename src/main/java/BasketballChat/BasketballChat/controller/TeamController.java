package BasketballChat.BasketballChat.controller;

import BasketballChat.BasketballChat.dto.TeamDto;
import BasketballChat.BasketballChat.service.teamService.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("team")
public class TeamController {
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public ResponseEntity<TeamDto> addTeam(@RequestBody TeamDto teamDto) {
        log.info("получен POST запрос на добавление Team c id {}", teamDto.getId());
        return new ResponseEntity<>(teamService.addTeam(teamDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable Long id) {
        log.info("получен DELETE запрос на удаление Team c id {}", id);
        teamService.deleteTeam(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDto> getTeam(@PathVariable Long id) {
        log.info("получен GET запрос на получение Team c id {}", id);
        return new ResponseEntity<>(teamService.getTeam(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TeamDto> updateTeam(@RequestBody TeamDto teamDto, @PathVariable Long id) {
        log.info("получен PATCH запрос на обновление Team c id {}", teamDto.getId());
        return new ResponseEntity<>(teamService.updateTeam(teamDto, id), HttpStatus.OK);
    }

    @GetMapping("/seacrh")
    public ResponseEntity<List<TeamDto>> searchTeam(@RequestParam(required = false) String name) {
        log.info("получен GET запрос на поиск Team c name {}", name);
        return new ResponseEntity<>(teamService.searchTeam(name), HttpStatus.OK);
    }
}
