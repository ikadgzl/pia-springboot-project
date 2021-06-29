package com.example.piacase.dto;

import com.example.piacase.model.League;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BaseTeamRequest {
  private String name;
  private League league;
  private String logoUrl;
  private String city;
  private LocalDate foundedIn;
  private String colors;
}
