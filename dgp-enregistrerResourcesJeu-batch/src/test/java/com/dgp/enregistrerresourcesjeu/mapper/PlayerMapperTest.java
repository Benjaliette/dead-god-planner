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
        playerDto.setHp(1);
        playerDto.setCanShoot(true);

        // WHEN
        Player player = playerMapper.toEntity(playerDto);

        // THEN
        assertThat(player.getName()).as("mapping du player avec le nom").isEqualTo("Keeper");
        assertThat(player.getHp()).as("mapping du player avec les hp").isEqualTo(1);
        assertThat(player.getCanShoot()).as("mapping du player avec canShoot").isTrue();
    }

    @Test
    public void testToEntityAvecNomCompose() {
        // GIVEN
        PlayerDto playerDto = new PlayerDto();
        playerDto.setName("#THE_LOST_NAME");
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

        // WHEN
        Player player = playerMapper.toEntity(playerDto);

        // THEN
        assertThat(player.getName()).as("mapping du player avec le nom").isEqualTo("Keeper");
        assertThat(player.getHp()).as("HP = 0 quand null dans le DTO").isEqualTo(0);
    }
}
