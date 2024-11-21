package dev.michaelcao512.backend.Services;

import dev.michaelcao512.backend.Entities.GameSession;
import dev.michaelcao512.backend.Entities.Message;
import dev.michaelcao512.backend.Entities.Player;
import dev.michaelcao512.backend.Repositories.GameSessionRepository;
import dev.michaelcao512.backend.Repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private final GameSessionRepository gameSessionRepository;
    private final MessageRepository messageRepository;

    @Autowired
    public GameService(GameSessionRepository gameSessionRepository, MessageRepository messageRepository) {
        this.gameSessionRepository = gameSessionRepository;
        this.messageRepository = messageRepository;
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

    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

}