package com.dgp.enregistrerresourcesjeu;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.dgp.core.dao.PlayerDao;
import com.dgp.core.model.Player;
import com.dgp.enregistrerresourcesjeu.controller.EnregistrerResourcesJeuBatchController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Test d'intégration du batch d'enregistrement des ressources de jeu
 */
@SpringBootTest
@ActiveProfiles("test")
class EnregistrerResourcesJeuBatchIntegrationTest {
    private MockMvc mockMvc;

    @Autowired
    private EnregistrerResourcesJeuBatchController controller;

    @Autowired
    private PlayerDao playerDao;

    @Autowired
    private JobRepository jobRepository;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void doitEnregistrerLesPlayersDuFichierXmlEnBase() throws Exception {
        // GIVEN
        String inDir = getClass().getClassLoader().getResource("data").getFile();

        // WHEN
        mockMvc.perform(get("/start")
                        .param("inDir", inDir)
                        .param("resource", "players"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

        Thread.sleep(3000);

        // THEN
        List<Player> players = playerDao.findAll();

        assertThat(players)
                .as("Le fichier XML contient 3 players, tous doivent être persistés")
                .hasSize(3);

        Player isaac = players.stream()
                .filter(p -> p.getItGame() == 1L)
                .findFirst()
                .orElseThrow();

        assertThat(isaac.getName())
                .as("Le nom doit être transformé par le mapper (suppression de # et _NAME, capitalisation)")
                .isEqualTo("Isaac");
        assertThat(isaac.getSkin()).isEqualTo("character_001_isaac.png");
        assertThat(isaac.getHp()).isEqualTo(6);
        assertThat(isaac.getBombs()).isEqualTo(1);
        assertThat(isaac.getCanShoot()).isTrue();

        Player theLost = players.stream()
                .filter(p -> p.getItGame() == 3L)
                .findFirst()
                .orElseThrow();

        assertThat(theLost.getName())
                .as("Le nom composé doit être correctement transformé")
                .isEqualTo("The Lost");
        assertThat(theLost.getHp())
                .as("The Lost n'a pas de HP dans le XML, la valeur par défaut doit être 0")
                .isEqualTo(0);
        assertThat(theLost.getAchievement()).isEqualTo(345);
    }
}
