package com.example.piacase.dto;

import com.example.piacase.model.League;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public class TeamDto {
  private Long id;
  private String name;
  private League league;
  private String logoUrl;
  private String city;
  private LocalDate foundedIn;
  private String colors;
  private List<PlayerDto> players;
}
