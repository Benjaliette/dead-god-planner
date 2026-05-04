package com.dgp.mapper;

import com.dgp.core.model.Player;
import com.dgp.dto.PlayerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", implementationName = "PlayerMapperImpl")
public interface PlayerMapper {
    PlayerDto toPlayerDto(final Player player);
}
