package com.example.piacase.dto;

import com.example.piacase.model.Nationality;
import com.example.piacase.model.Position;
import com.example.piacase.model.Team;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PlayerDto {
  private Long id;
  private String firstName;
  private String lastName;
  private Position position;
  private Nationality nationality;
  private Integer squadNumber;
  private String teamName;
}
