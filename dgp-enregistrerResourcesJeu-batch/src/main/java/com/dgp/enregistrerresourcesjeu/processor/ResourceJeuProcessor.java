package com.dgp.enregistrerresourcesjeu.processor;

import com.dgp.enregistrerresourcesjeu.item.PlayerDto;
import com.dgp.enregistrerresourcesjeu.mapper.PlayerMapper;
import com.dgp.core.model.Player;
import org.jspecify.annotations.Nullable;
import org.springframework.batch.infrastructure.item.ItemProcessor;

public class ResourceJeuProcessor implements ItemProcessor<PlayerDto, Player> {
    private final PlayerMapper playerMapper;

    public ResourceJeuProcessor(PlayerMapper playerMapper) {
        this.playerMapper = playerMapper;
    }

    @Override
    public @Nullable Player process(PlayerDto item) throws Exception {
        Player player = playerMapper.toEntity(item);
        return player;
    }
}
