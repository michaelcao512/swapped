package dev.michaelcao512.backend.Controllers;

import dev.michaelcao512.backend.Entities.Player;
import dev.michaelcao512.backend.Services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {
    private final GameService gameService;
    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

//    gets all game session ids
    @GetMapping()
    public List<Long> getGameSessions() {
        return gameService.getGameSessions();
    }
//   creates a new game session
    @PostMapping("/create")
    public Long createGameSession() {
        return gameService.createGameSession();
    }

//    adds a new player to a game session
    @PostMapping("/{sessionId}/join")
    public void joinGame(@PathVariable Long sessionId, @RequestBody String playerName) {
        gameService.addPlayer(sessionId, playerName);
    }

//    gets all players in a game session
    @GetMapping("/{sessionId}/players")
    public List<Player> getPlayers(@PathVariable Long sessionId) {
        return gameService.getPlayers(sessionId);
    }







}
