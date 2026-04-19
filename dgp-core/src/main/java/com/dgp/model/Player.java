package com.dgp.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "it_game", nullable = false)
    private Long itGame;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "skin", nullable = false)
    private String skin;

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

    @Column(name = "skinColor", nullable = false)
    private Integer skinColor;

    @Column(name = "costumeSuffix")
    private String costumeSuffix;

    @Column(name = "bombs")
    private Integer bombs;

    @Column(name = "nameimage", nullable = false)
    private String nameimage;

    @Column(name = "portrait", nullable = false)
    private String portrait;

    @Column(name = "birthright", nullable = false)
    private String birthright;

    @Column(name = "card")
    private Integer card;

    @Column(name = "pocketActive")
    private Integer pocketActive;
}
