package com.dgp.core.model;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(name = "keys")
    private Integer keys;

    @Column(name = "pill")
    private Integer pill;

    @Column(name = "canshoot")
    private Boolean canShoot;

    @Column(name = "extraportrait")
    private String extraportrait;

    @Column(name = "playable", nullable = false)
    private boolean playable;

    @Column(name = "tainted", nullable = false)
    private boolean tainted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItGame() {
        return itGame;
    }

    public void setItGame(Long itGame) {
        this.itGame = itGame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getArmor() {
        return armor;
    }

    public void setArmor(Integer armor) {
        this.armor = armor;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Integer getItems() {
        return items;
    }

    public void setItems(Integer items) {
        this.items = items;
    }

    public Integer getAchievement() {
        return achievement;
    }

    public void setAchievement(Integer achievement) {
        this.achievement = achievement;
    }

    public Integer getBlack() {
        return black;
    }

    public void setBlack(Integer black) {
        this.black = black;
    }

    public Integer getCostume() {
        return costume;
    }

    public void setCostume(Integer costume) {
        this.costume = costume;
    }

    public Integer getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(Integer skinColor) {
        this.skinColor = skinColor;
    }

    public String getCostumeSuffix() {
        return costumeSuffix;
    }

    public void setCostumeSuffix(String costumeSuffix) {
        this.costumeSuffix = costumeSuffix;
    }

    public Integer getBombs() {
        return bombs;
    }

    public void setBombs(Integer bombs) {
        this.bombs = bombs;
    }

    public String getNameimage() {
        return nameimage;
    }

    public void setNameimage(String nameimage) {
        this.nameimage = nameimage;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getBirthright() {
        return birthright;
    }

    public void setBirthright(String birthright) {
        this.birthright = birthright;
    }

    public Integer getCard() {
        return card;
    }

    public void setCard(Integer card) {
        this.card = card;
    }

    public Integer getPocketActive() {
        return pocketActive;
    }

    public void setPocketActive(Integer pocketActive) {
        this.pocketActive = pocketActive;
    }

    public Integer getKeys() {
        return keys;
    }

    public void setKeys(Integer keys) {
        this.keys = keys;
    }

    public Integer getPill() {
        return pill;
    }

    public void setPill(Integer pill) {
        this.pill = pill;
    }

    public Boolean getCanShoot() {
        return canShoot;
    }

    public void setCanShoot(Boolean canShoot) {
        this.canShoot = canShoot;
    }

    public String getExtraportrait() {
        return extraportrait;
    }

    public void setExtraportrait(String extraportrait) {
        this.extraportrait = extraportrait;
    }

    public boolean isPlayable() {
        return playable;
    }

    public void setPlayable(boolean playable) {
        this.playable = playable;
    }

    public boolean isTainted() {
        return tainted;
    }

    public void setTainted(boolean tainted) {
        this.tainted = tainted;
    }
}
