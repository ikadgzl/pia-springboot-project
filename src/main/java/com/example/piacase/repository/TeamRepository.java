package com.example.piacase.repository;

import com.example.piacase.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
  Team findByName(String teamName);
}
