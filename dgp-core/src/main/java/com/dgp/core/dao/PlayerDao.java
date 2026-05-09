package com.dgp.core.dao;

import com.dgp.core.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerDao extends JpaRepository<Player, Long> {
    @Query("""
               SELECT player FROM Player player
               WHERE player.playable IS TRUE 
            """)
    public List<Player> findPlayablePlayers();

    @Query("""
               SELECT player FROM Player player
               WHERE player.playable IS TRUE AND player.tainted IS FALSE
            """)
    public List<Player> findPlayableNormalPlayers();

    @Query("""
               SELECT player FROM Player player
               WHERE player.playable IS TRUE AND player.tainted IS TRUE
            """)
    public List<Player> findPlayableTaintedPlayers();
}
