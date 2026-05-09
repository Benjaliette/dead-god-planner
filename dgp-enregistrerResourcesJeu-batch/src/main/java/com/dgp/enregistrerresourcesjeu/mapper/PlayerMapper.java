package com.dgp.enregistrerresourcesjeu.mapper;

import com.dgp.core.model.Player;
import com.dgp.enregistrerresourcesjeu.constantes.EnregistrerResourcesJeuConstantes;
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
    static String modifyPlayerName(final String birthright) {
        String[] playerLowerCaseWords = birthright.replace("#", "")//
                .replace("BIRTHRIGHT", "")//
                .replace("_", " ")//
                .toLowerCase(Locale.FRANCE).trim().split("\\s");

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

    @Named("modifySkinUrl")
    static String modifySkinUrl(final String skin) {
        if (skin == null || skin.isBlank()) {
            return skin;
        }
        return EnregistrerResourcesJeuConstantes.BASE_ASSETS_URL + "characters/costumes/" + skin.toLowerCase(Locale.FRANCE);
    }

    @Named("modifyPlayernameUrl")
    static String modifyPlayernameUrl(final String nameimage) {
        if (nameimage == null || nameimage.isBlank()) {
            return nameimage;
        }
        return EnregistrerResourcesJeuConstantes.BASE_ASSETS_URL + "ui/boss/" + nameimage.toLowerCase(Locale.FRANCE);
    }

    @Named("modifyPortraitUrl")
    static String modifyPortraitUrl(final String portrait) {
        if (portrait == null || portrait.isBlank()) {
            return portrait;
        }
        return EnregistrerResourcesJeuConstantes.BASE_ASSETS_URL + "ui/stage/" + portrait.toLowerCase(Locale.FRANCE);
    }

    @Mapping(source = "birthright", target = "name", qualifiedByName = "modifyPlayerName")
    @Mapping(source = "skin", target = "skin", qualifiedByName = "modifySkinUrl")
    @Mapping(source = "nameimage", target = "nameimage", qualifiedByName = "modifyPlayernameUrl")
    @Mapping(source = "portrait", target = "portrait", qualifiedByName = "modifyPortraitUrl")
    @Mapping(source = "hp", target = "hp", defaultValue = "0")
    @Mapping(source = "canShoot", target = "canShoot")
    Player toEntity(final PlayerDto playerDto);
}
