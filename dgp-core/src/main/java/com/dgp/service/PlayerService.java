package com.dgp.service;

import com.dgp.dao.PlayerDao;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private final PlayerDao playerDao;

    public PlayerService(final PlayerDao playerDao) {
        this.playerDao = playerDao;
    }
}
