package BasketballChat.BasketballChat.mapper;

import BasketballChat.BasketballChat.dto.TeamDto;
import BasketballChat.BasketballChat.model.team.Team;
import lombok.*;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<TeamDto> listDtoToList(List<Team> list){
        return list.stream().map(TeamMapper::teamToTeamDto).collect(Collectors.toList());
    }
    public List<Team> listToListDto(List<TeamDto> list){
        return list.stream().map(TeamMapper::teamDtoToTeam).collect(Collectors.toList());
    }
}
