package BasketballChat.BasketballChat.service.teamService;

import BasketballChat.BasketballChat.dto.TeamDto;

public interface TeamService {
    TeamDto addTeam(TeamDto teamDto);

    void deleteTeam(Long id);

    TeamDto getTeam(Long id);

    TeamDto updateTeam(TeamDto teamDto,Long id);
}
