package dev.michaelcao512.backend.Repositories;

import dev.michaelcao512.backend.Entities.GameSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameSessionRepository extends JpaRepository<GameSession, Long>{
}
