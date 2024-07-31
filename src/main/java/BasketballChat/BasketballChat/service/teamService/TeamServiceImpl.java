package BasketballChat.BasketballChat.service.teamService;

import BasketballChat.BasketballChat.dto.TeamDto;
import BasketballChat.BasketballChat.mapper.TeamMapper;
import BasketballChat.BasketballChat.model.team.Team;
import BasketballChat.BasketballChat.storage.team.TeamStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamStorage teamStorage;

    @Autowired
    public TeamServiceImpl(TeamStorage teamStorage) {
        this.teamStorage = teamStorage;
    }

    @Override
    public TeamDto addTeam(TeamDto teamDto) {
        Team team = TeamMapper.teamDtoToTeam(teamDto);
        return TeamMapper.teamToTeamDto(teamStorage.addTeam(team));
    }

    @Override
    public void deleteTeam(Long id) {
        teamStorage.deleteTeam(id);
    }

    @Override
    public TeamDto getTeam(Long id) {
        return TeamMapper.teamToTeamDto(teamStorage.getTeam(id));
    }

    @Override
    public TeamDto updateTeam(TeamDto teamDto,Long id) {
        Team team=TeamMapper.teamDtoToTeam(teamDto);
        return TeamMapper.teamToTeamDto(teamStorage.updateTeam(team,id));
    }
}
