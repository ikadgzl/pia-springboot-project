package com.example.piacase.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Player {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String firstName;
  private String lastName;
  private Position position;
  private Nationality nationality;
  private Integer squadNumber;

  @ManyToOne
  @JoinColumn(name="team_id")
  @JsonIgnore
  private Team team;

  public Player(String firstName, String lastName, Position position, Nationality nationality, Integer squadNumber, Team team) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.position = position;
    this.nationality = nationality;
    this.squadNumber = squadNumber;
    this.team = team;
  }

  public Player() {

  }
}
