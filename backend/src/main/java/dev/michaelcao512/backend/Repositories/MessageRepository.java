package dev.michaelcao512.backend.Repositories;

import dev.michaelcao512.backend.Entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long>{
}
