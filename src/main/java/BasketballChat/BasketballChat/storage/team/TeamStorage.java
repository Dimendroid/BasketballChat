package BasketballChat.BasketballChat.storage.team;

import BasketballChat.BasketballChat.model.team.Team;

import java.util.List;

public interface TeamStorage {
    Team addTeam(Team team);

    void deleteTeam(Long id);

    Team getTeam(Long id);

    Team updateTeam(Team team,Long id);
    List<Team> searchTeamByName(String name);
}
