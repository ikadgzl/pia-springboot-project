package com.example.piacase.dto.converter;

import com.example.piacase.dto.TeamDto;
import com.example.piacase.model.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TeamDtoConverter {

  private final PlayerDtoConverter playerDtoConverter;

  public TeamDto convert(Team from) {
    return new TeamDto(from.getId(),
        from.getName(),
        from.getLeague(),
        from.getLogoUrl(),
        from.getCity(),
        from.getFoundedIn(),
        from.getColors(),
        from.getPlayers().stream().map(playerDtoConverter::convert).collect(Collectors.toList()));
  }
}
