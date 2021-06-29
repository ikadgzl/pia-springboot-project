package com.example.piacase.controller;

import com.example.piacase.dto.CreateTeamRequest;
import com.example.piacase.dto.TeamDto;
import com.example.piacase.dto.UpdateTeamRequest;
import com.example.piacase.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/team")
@RequiredArgsConstructor
public class TeamController {

  private final TeamService teamService;

  @PostMapping
  public ResponseEntity<TeamDto> createTeam(@RequestBody CreateTeamRequest createTeamRequest)
  {
    return ResponseEntity.ok(teamService.createTeam(createTeamRequest));
  }

  @GetMapping
  public ResponseEntity<List<TeamDto>> getAllTeams() {
    return ResponseEntity.ok(teamService.getAllTeams());
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<TeamDto> getTeamById(@PathVariable Long id) {
    return ResponseEntity.ok(teamService.getTeamById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<TeamDto> updateTeamById(@PathVariable Long id, @RequestBody UpdateTeamRequest updateTeamRequest) {
    return ResponseEntity.ok(teamService.updateTeamById(id, updateTeamRequest));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<TeamDto> deleteTeamById(@PathVariable Long id) {
    return ResponseEntity.ok(teamService.deleteTeamById(id));
  }
}
