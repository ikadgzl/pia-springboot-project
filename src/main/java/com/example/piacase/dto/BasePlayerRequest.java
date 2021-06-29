package com.example.piacase.dto;

import com.example.piacase.model.Nationality;
import com.example.piacase.model.Position;
import lombok.Data;

@Data
public class BasePlayerRequest {
  private String firstName;
  private String lastName;
  private Position position;
  private Nationality nationality;
  private Integer squadNumber;
  private String teamName;
}
