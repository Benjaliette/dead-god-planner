package com.dgp.enregistrerresourcesjeu.mapper;

import static org.assertj.core.api.Assertions.*;

import com.dgp.core.model.Player;
import com.dgp.enregistrerresourcesjeu.item.PlayerDto;
import com.dgp.test.AbstractDgpUnitTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class PlayerMapperTest extends AbstractDgpUnitTest {
    @InjectMocks
    private PlayerMapperImpl playerMapper;

    @Test
    public void testToEntityAvecNomClassique() {
        // GIVEN
        PlayerDto playerDto = new PlayerDto();
        playerDto.setName("#KEEPER_NAME");
        playerDto.setBirthright("#KEEPER_BIRTHRIGHT");
        playerDto.setNameimage("PlayerName_14_TheKeeper.png");
        playerDto.setPortrait("PlayerPortrait_Keeper.png");
        playerDto.setSkin("Character_015_Keeper.png");
        playerDto.setHp(1);
        playerDto.setCanShoot(true);

        // WHEN
        Player player = playerMapper.toEntity(playerDto);

        // THEN
        assertThat(player.getName()).as("mapping du player avec le nom").isEqualTo("Keeper");
        assertThat(player.getHp()).as("mapping du player avec les hp").isEqualTo(1);
        assertThat(player.getCanShoot()).as("mapping du player avec canShoot").isTrue();
        assertThat(player.getNameimage()).as("mapping de l'image nom du player avec l'url").isEqualTo("http://jq8zqnl4lzomtrujfdrkadqk.88.182.27.241.sslip.io/gfx/ui/boss/playername_14_thekeeper.png");
        assertThat(player.getPortrait()).as("mapping du portrait du player avec l'url").isEqualTo("http://jq8zqnl4lzomtrujfdrkadqk.88.182.27.241.sslip.io/gfx/ui/stage/playerportrait_keeper.png");
        assertThat(player.getSkin()).as("mapping du skin du player avec l'url").isEqualTo("http://jq8zqnl4lzomtrujfdrkadqk.88.182.27.241.sslip.io/gfx/characters/costumes/character_015_keeper.png");
    }

    @Test
    public void testToEntityAvecNomCompose() {
        // GIVEN
        PlayerDto playerDto = new PlayerDto();
        playerDto.setName("#THE_LOST_NAME");
        playerDto.setBirthright("#THE_LOST_BIRTHRIGHT");
        playerDto.setHp(1);

        // WHEN
        Player player = playerMapper.toEntity(playerDto);

        // THEN
        assertThat(player.getName()).as("mapping du player avec le nom").isEqualTo("The Lost");
        assertThat(player.getHp()).as("mapping du player avec les hp").isEqualTo(1);
    }

    @Test
    public void testToEntityAvecHpNull() {
        // GIVEN
        PlayerDto playerDto = new PlayerDto();
        playerDto.setName("#KEEPER_NAME");
        playerDto.setBirthright("#KEEPER_BIRTHRIGHT");

        // WHEN
        Player player = playerMapper.toEntity(playerDto);

        // THEN
        assertThat(player.getName()).as("mapping du player avec le nom").isEqualTo("Keeper");
        assertThat(player.getHp()).as("HP = 0 quand null dans le DTO").isEqualTo(0);
    }

    @Test
    public void testToEntityAvecTaintedPlayer() {
        // GIVEN
        PlayerDto playerDto = new PlayerDto();
        playerDto.setName("#ISAAC_NAME");
        playerDto.setBirthright("#ISAAC_B_BIRTHRIGHT");

        // WHEN
        Player player = playerMapper.toEntity(playerDto);

        // THEN
        assertThat(player.getName()).as("mapping du player avec le nom").isEqualTo("Tainted Isaac");
    }
}
