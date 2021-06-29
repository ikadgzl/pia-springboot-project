package com.example.piacase.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Team {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String name;
  private League league;
  private String logoUrl;
  private String city;
  private LocalDate foundedIn;
  private String colors;

  @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  private List<Player> players;

  public Team(String name, League league, String logoUrl, String city, LocalDate foundedIn, String colors) {
    this.name = name;
    this.league = league;
    this.logoUrl = logoUrl;
    this.city = city;
    this.foundedIn = foundedIn;
    this.colors = colors;
  }

  public Team() {

  }
}
