package dev.michaelcao512.backend.Services;

import dev.michaelcao512.backend.Entities.GameSession;
import dev.michaelcao512.backend.Entities.Player;
import dev.michaelcao512.backend.Repositories.GameSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private final GameSessionRepository gameSessionRepository;

    @Autowired
    public GameService(GameSessionRepository gameSessionRepository) {
        this.gameSessionRepository = gameSessionRepository;
    }

    public List<Long> getGameSessions() {
        return gameSessionRepository.findAll()
                .stream()
                .map(GameSession::getId)
                .toList();
    }
    public Long createGameSession() {
        GameSession session = new GameSession();
        return gameSessionRepository.save(session).getId();
    }

    public void addPlayer(Long sessionId, String playerName) {
        GameSession session = gameSessionRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid session ID"));
        session.addPlayer(new Player(playerName));
        gameSessionRepository.save(session);
    }

    public List<Player> getPlayers(Long sessionId) {
        GameSession session = gameSessionRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid session ID"));
        return session.getPlayers();
    }
}