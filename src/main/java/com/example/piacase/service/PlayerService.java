package com.example.piacase.service;

import com.example.piacase.dto.CreatePlayerRequest;
import com.example.piacase.dto.PlayerDto;
import com.example.piacase.dto.UpdatePlayerRequest;
import com.example.piacase.dto.converter.PlayerDtoConverter;
import com.example.piacase.model.Nationality;
import com.example.piacase.model.Player;
import com.example.piacase.model.Position;
import com.example.piacase.model.Team;
import com.example.piacase.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayerService {

  private final PlayerDtoConverter playerDtoConverter;
  private final PlayerRepository playerRepository;
  private final TeamService teamService;

  public PlayerDto createPlayer(CreatePlayerRequest createPlayerRequest) throws Exception {
    Team team = teamService.getTeamByName(createPlayerRequest.getTeamName());

    if (team.getPlayers().size() > 17) {
      throw new Exception("Player limit exceeded, up to 18.");
    }

    if (team.getPlayers().stream().filter(player -> player.getNationality() == Nationality.FOREIGN).count() > 5) {
      throw new Exception("Club can have only 6 foreign players.");
    }

    if (team.getPlayers().stream().filter(player -> player.getPosition() == Position.GOALKEEPER).count() > 1) {
      throw new Exception("Team can have only 2 goalkeeper at the same time.");
    }

    Player player = new Player(createPlayerRequest.getFirstName(),
        createPlayerRequest.getLastName(),
        createPlayerRequest.getPosition(),
        createPlayerRequest.getNationality(),
        createPlayerRequest.getSquadNumber(),
        team);

    playerRepository.save(player);

    return playerDtoConverter.convert(player);
  }

  public List<PlayerDto> getAllPlayers() {
    List<Player> players = playerRepository.findAll();

    return players.stream().map(playerDtoConverter::convert).collect(Collectors.toList());
  }

  public PlayerDto getPlayerById(Long id) {
    Player player = playerRepository.findById(id).orElseThrow();

    return playerDtoConverter.convert(player);
  }


  public PlayerDto updatePlayerById(Long id, UpdatePlayerRequest updatePlayerRequest) {
    Player player = playerRepository.findById(id).orElseThrow();
    Team team = teamService.getTeamByName(updatePlayerRequest.getTeamName());


    player.setFirstName(updatePlayerRequest.getFirstName());
    player.setLastName(updatePlayerRequest.getLastName());
    player.setPosition(updatePlayerRequest.getPosition());
    player.setNationality(updatePlayerRequest.getNationality());
    player.setSquadNumber(updatePlayerRequest.getSquadNumber());
    player.setTeam(team);

    playerRepository.save(player);

    return playerDtoConverter.convert(player);
  }


  public PlayerDto deletePlayerById(Long id) {
    Player player = playerRepository.findById(id).orElseThrow();

    playerRepository.delete(player);

    return playerDtoConverter.convert(player);
  }
}
