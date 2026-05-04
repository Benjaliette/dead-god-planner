package com.dgp.core.service;

import com.dgp.core.dao.PlayerDao;
import com.dgp.core.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private final PlayerDao playerDao;

    public PlayerService(final PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    public List<Player> findAll() {
        return playerDao.findAll();
    }
}
