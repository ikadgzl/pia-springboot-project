package com.example.piacase.dto.converter;

import com.example.piacase.dto.PlayerDto;
import com.example.piacase.model.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerDtoConverter {
  public PlayerDto convert(Player from) {
    return new PlayerDto(
        from.getId(),
        from.getFirstName(),
        from.getLastName(),
        from.getPosition(),
        from.getNationality(),
        from.getSquadNumber(),
        from.getTeam().getName()
    );
  }
}
