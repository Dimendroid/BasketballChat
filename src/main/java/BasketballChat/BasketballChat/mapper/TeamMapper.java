package BasketballChat.BasketballChat.mapper;

import BasketballChat.BasketballChat.dto.TeamDto;
import BasketballChat.BasketballChat.model.team.Team;
import lombok.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TeamMapper {
    public TeamDto teamToTeamDto(Team team) {
        return new TeamDto(team.getId(),
                team.getUsers(),
                team.getName());
    }
    public Team teamDtoToTeam(TeamDto teamDto){
        return new Team(teamDto.getId(),
                teamDto.getUsers(),
                teamDto.getName());
    }
}
