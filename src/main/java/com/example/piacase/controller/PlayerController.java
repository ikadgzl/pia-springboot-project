package com.example.piacase.controller;

import com.example.piacase.dto.CreatePlayerRequest;
import com.example.piacase.dto.PlayerDto;
import com.example.piacase.dto.UpdatePlayerRequest;
import com.example.piacase.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/player")
@RequiredArgsConstructor
public class PlayerController {

  private final PlayerService playerService;

  @PostMapping
  public ResponseEntity<PlayerDto> createPlayer(@RequestBody CreatePlayerRequest createPlayerRequest) throws Exception {
    return ResponseEntity.ok(playerService.createPlayer(createPlayerRequest));
  }

  @GetMapping
  public ResponseEntity<List<PlayerDto>> getAllPlayers() {
    return ResponseEntity.ok(playerService.getAllPlayers());
  }

  @GetMapping("/{id}")
  public ResponseEntity<PlayerDto> getPlayerById(@PathVariable Long id) {
    return ResponseEntity.ok(playerService.getPlayerById(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<PlayerDto> updatePlayerById(@PathVariable Long id, UpdatePlayerRequest updatePlayerRequest) {
    return ResponseEntity.ok(playerService.updatePlayerById(id, updatePlayerRequest));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<PlayerDto> deletePlayerById(@PathVariable Long id) {
    return ResponseEntity.ok(playerService.deletePlayerById(id));

  }
}
