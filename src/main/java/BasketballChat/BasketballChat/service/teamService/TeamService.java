package BasketballChat.BasketballChat.service.teamService;

import BasketballChat.BasketballChat.dto.TeamDto;

import java.util.List;

public interface TeamService {
    TeamDto addTeam(TeamDto teamDto);

    void deleteTeam(Long id);

    TeamDto getTeam(Long id);

    TeamDto updateTeam(TeamDto teamDto,Long id);

    List<TeamDto> searchTeam(String name);
}
