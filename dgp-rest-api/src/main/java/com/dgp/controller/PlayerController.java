package com.dgp.controller;

import com.dgp.core.service.PlayerService;
import com.dgp.dto.PlayerDto;
import com.dgp.mapper.PlayerMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping
    @Operation(summary = "Récupérer tous les personnages", description = "Récupérer tous les personnages")
    @ApiResponse(responseCode = "200", description = "Personnages trouvés, peut être vide")
    public ResponseEntity<List<PlayerDto>> findAll() {
        List<PlayerDto> players = playerService.findAll()
                .stream().map(playerMapper::toPlayerDto)
                .toList();

        return ResponseEntity.ok(players);
    }
}
