package com.dgp.controller;

import com.dgp.core.model.Player;
import com.dgp.core.service.PlayerService;
import com.dgp.dto.PlayerDto;
import com.dgp.mapper.PlayerMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/players")
@Tag(name = "Players", description = "Personnages jouables de The Binding of Isaac : Repentance")
public class PlayerController {
    private final PlayerService playerService;

    private final PlayerMapper playerMapper;

    public PlayerController(PlayerService playerService, PlayerMapper playerMapper) {
        this.playerService = playerService;
        this.playerMapper = playerMapper;
    }

    @GetMapping("/all")
    @Operation(summary = "Récupérer tous les personnages", description = "Récupérer tous les personnages")
    @ApiResponse(responseCode = "200", description = "Personnages trouvés, peut être vide")
    public ResponseEntity<List<PlayerDto>> findAll() {
        List<PlayerDto> players = playerService.findAll()
                .stream()
                .map(playerMapper::toPlayerDto)
                .toList();

        return ResponseEntity.ok(players);
    }

    @GetMapping
    @Operation(summary = "Récupérer tous les personnages jouables", description = "Récupérer tous les personnages jouables")
    @ApiResponse(responseCode = "200", description = "Personnages jouables trouvés, peut être vide")
    @ApiResponse(responseCode = "400", description = "Mauvaise query dans l'URL")
    public ResponseEntity<List<PlayerDto>> findAllPlayablePlayers(@RequestParam(required = false) Boolean tainted) {
        List<Player> retrievedPlayers;

        if (tainted == null) {
            retrievedPlayers = playerService.findAllPlayablePlayers();
        } else if (tainted) {
            retrievedPlayers = playerService.findAllPlayableTaintedPlayers();
        } else {
            retrievedPlayers = playerService.findAllPlayableNormalPlayers();
        }

        List<PlayerDto> players = retrievedPlayers
                .stream()
                .map(playerMapper::toPlayerDto)
                .toList();

        return ResponseEntity.ok(players);
    }
}
