package com.dgp.enregistrerresourcesjeu.mapper;

import com.dgp.enregistrerresourcesjeu.item.PlayerDto;
import com.dgp.core.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.util.StringUtils;

import java.util.Locale;
import java.util.StringJoiner;

@Mapper(componentModel = "spring")
public interface PlayerMapper {
    @Mapping(source = "name", target = "name", qualifiedByName = "modifyPlayerName")
    @Mapping(source = "hp", target = "hp", defaultValue = "0")
    @Mapping(source = "canShoot", target = "canShoot")
    Player toEntity(final PlayerDto playerDto);

    @Named("modifyPlayerName")
    public static String modifyPlayerName(final String name) {
        String[] playerLowerCaseWords = name.replace("#", "")//
                .replace("NAME", "")//
                .replace("_", " ")//
                .toLowerCase(Locale.FRANCE)
                .trim()
                .split("\\s");

        StringJoiner sj = new StringJoiner(" ");

        for (String playerLowerCaseWord : playerLowerCaseWords) {
            sj.add(StringUtils.capitalize(playerLowerCaseWord));
        }

        return sj.toString();
    }
}
