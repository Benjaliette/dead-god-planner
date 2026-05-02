package com.dgp.enregistrerresourcesjeu.mapper;

import com.dgp.core.model.Player;
import com.dgp.enregistrerresourcesjeu.item.PlayerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Locale;
import java.util.StringJoiner;

@Mapper(componentModel = "spring")
public interface PlayerMapper {
    @Named("modifyPlayerName")
    public static String modifyPlayerName(final String birthright) {
        String[] playerLowerCaseWords = birthright.replace("#", "")//
                .replace("BIRTHRIGHT", "")//
                .replace("_", " ")//
                .toLowerCase(Locale.FRANCE)
                .trim()
                .split("\\s");

        StringJoiner sj = new StringJoiner(" ");

        if (Arrays.asList(playerLowerCaseWords).contains("b")) {
            sj.add("Tainted");
        }

        for (String playerLowerCaseWord : playerLowerCaseWords) {
            if (!playerLowerCaseWord.equals("b")) {
                sj.add(StringUtils.capitalize(playerLowerCaseWord));
            }
        }

        return sj.toString();
    }

    @Mapping(source = "birthright", target = "name", qualifiedByName = "modifyPlayerName")
    @Mapping(source = "hp", target = "hp", defaultValue = "0")
    @Mapping(source = "canShoot", target = "canShoot")
    Player toEntity(final PlayerDto playerDto);
}
