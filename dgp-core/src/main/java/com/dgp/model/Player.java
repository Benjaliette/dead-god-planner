package com.dgp.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Nonnull
    @Column(name = "it_game", nullable = false)
    private Long itGame;

    @Nonnull
    @Column(name = "skin", nullable = false)
    private String skin;

    @Nonnull
    @Column(name = "hp", nullable = false)
    private Integer hp;

    @Column(name = "armor")
    private Integer armor;

    @Column(name = "coins")
    private Integer coins;

    @Column(name = "items")
    private Integer items;

    @Column(name = "achievement")
    private Integer achievement;

    @Column(name = "black")
    private Integer black;

    @Column(name = "costume")
    private Integer costume;

    @Nonnull
    @Column(name = "skinColor", nullable = false)
    private Integer skinColor;

    @Column(name = "costumeSuffix")
    private Integer costumeSuffix;

    @Column(name = "bombs")
    private Integer bombs;

    @Nonnull
    @Column(name = "nameimage", nullable = false)
    private Integer nameimage;

    @Nonnull
    @Column(name = "portrait", nullable = false)
    private Integer portrait;

    @Nonnull
    @Column(name = "birthright", nullable = false)
    private Integer birthright;

    @Column(name = "card")
    private Integer card;

    @Column(name = "pocketActive")
    private Integer pocketActive;
}
