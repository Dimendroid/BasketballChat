package BasketballChat.BasketballChat.storage.team;

import BasketballChat.BasketballChat.exception.TeamNotFoundException;
import BasketballChat.BasketballChat.model.team.Team;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class TeamStorageImpl implements TeamStorage {
    private Map<Long, Team> teams = new HashMap<>();
    private Long idGen = 1L;

    @Override
    public Team addTeam(Team team) {
        team.setId(idGen);
        teams.put(idGen, team);
        idGen++;
        log.info("team c id {} успешно добавлен", team.getId());
        return team;
    }

    @Override
    public void deleteTeam(Long id) {
        teamExist(id);
        teams.remove(id);
        log.info("Team c id {} успешно удалена",id);
    }

    @Override
    public Team getTeam(Long id) {
        teamExist(id);
        log.info("Team c id {} получена",id);
        return teams.get(id);
    }

    @Override
    public Team updateTeam(Team team, Long id) {
        teamExist(id);
        Team teamFromStorage=teams.get(id);
        team.setId(id);
        if(team.getName()==null){
            team.setName(teamFromStorage.getName());
        }
        log.info("Team c id {} успешно обновлена",id);
        return null;
    }

    public void teamExist(Long id) {
        if (!teams.containsKey(id)) {
            log.warn("Team c id {} не найдено", id);
            throw new TeamNotFoundException("Team c таким id не найдено");
        }
    }
}
