package com.example.piacase.service;

import com.example.piacase.dto.CreateTeamRequest;
import com.example.piacase.dto.TeamDto;
import com.example.piacase.dto.UpdateTeamRequest;
import com.example.piacase.dto.converter.TeamDtoConverter;
import com.example.piacase.model.Team;
import com.example.piacase.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamService {

  private final TeamRepository teamRepository;
  private final TeamDtoConverter teamDtoConverter;


  public TeamDto createTeam(CreateTeamRequest createTeamRequest) {
    Team newTeam = new Team(
        createTeamRequest.getName(),
        createTeamRequest.getLeague(),
        createTeamRequest.getLogoUrl(),
        createTeamRequest.getCity(),
        createTeamRequest.getFoundedIn(),
        createTeamRequest.getColors());

    teamRepository.save(newTeam);

    return teamDtoConverter.convert(newTeam);
  }

  public List<TeamDto> getAllTeams() {
    List<Team> teams = teamRepository.findAll();

    return teams.stream().map(teamDtoConverter::convert).collect(Collectors.toList());
  }

  public TeamDto getTeamById(Long id) {
    Team team = teamRepository.findById(id).orElseThrow();

    return teamDtoConverter.convert(team);
  }

  public Team getTeamByName(String teamName) {

    return teamRepository.findByName(teamName);
  }


  public TeamDto updateTeamById(Long id, UpdateTeamRequest updateTeamRequest) {
    Team team = teamRepository.findById(id).orElseThrow();

    team.setName(updateTeamRequest.getName());
    team.setLeague(updateTeamRequest.getLeague());
    team.setLogoUrl(updateTeamRequest.getLogoUrl());
    team.setColors(updateTeamRequest.getColors());
    team.setCity(updateTeamRequest.getCity());
    team.setFoundedIn(updateTeamRequest.getFoundedIn());

    teamRepository.save(team);

    return teamDtoConverter.convert(team);
  }

  public TeamDto deleteTeamById(Long id) {
    Team team = teamRepository.findById(id).orElseThrow();

    teamRepository.delete(team);

    return teamDtoConverter.convert(team);
  }
}
