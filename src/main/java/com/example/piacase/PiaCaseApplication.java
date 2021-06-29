package com.example.piacase;

import com.example.piacase.model.*;
import com.example.piacase.repository.PlayerRepository;
import com.example.piacase.repository.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;


@SpringBootApplication
public class PiaCaseApplication implements CommandLineRunner {

  private final PlayerRepository playerRepository;
  private final TeamRepository teamRepository;

  public PiaCaseApplication(PlayerRepository playerRepository, TeamRepository teamRepository) {
    this.playerRepository = playerRepository;
    this.teamRepository = teamRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(PiaCaseApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Team team1 = new Team(
        "a",
        League.AMATEUR,
        "www.logourl.com",
        "Ankara",
        LocalDate.now(),
        "Red-Blue"
    );

    Team team2 = new Team(
        "b",
        League.FIRST,
        "www.logourl.com",
        "Istanbul",
        LocalDate.now(),
        "White-Green"
    );

    Player player1 = new Player(
        "Ilker",
        "Ilker",
        Position.FORWARD,
        Nationality.NATIVE,
        4,
        team1
    );

    Player player2 = new Player(
        "Zehra",
        "Zehra",
        Position.GOALKEEPER,
        Nationality.NATIVE,
        6,
        team1
    );

    Player player3 = new Player(
        "Efekan",
        "Efekan",
        Position.GOALKEEPER,
        Nationality.NATIVE,
        6,
        team2
    );

    System.out.println(team1);

    teamRepository.saveAll(List.of(team1, team2));
    playerRepository.saveAll(List.of(player1,player2, player3));
  }
}
