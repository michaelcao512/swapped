package dev.michaelcao512.backend.Repositories;

import dev.michaelcao512.backend.Entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
