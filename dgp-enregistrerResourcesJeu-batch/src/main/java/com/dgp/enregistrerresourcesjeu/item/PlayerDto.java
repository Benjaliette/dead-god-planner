package com.dgp.enregistrerresourcesjeu.item;

import jakarta.persistence.Column;
import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "player")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerDto {
    @XmlAttribute(name = "id")
    private Long itGame;

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "skin")
    private String skin;

    @XmlAttribute(name = "hp")
    private Integer hp;

    @XmlAttribute(name = "armor")
    private Integer armor;

    @XmlAttribute(name = "coins")
    private Integer coins;

    @XmlAttribute(name = "items")
    private Integer items;

    @XmlAttribute(name = "achievement")
    private Integer achievement;

    @XmlAttribute(name = "black")
    private Integer black;

    @XmlAttribute(name = "costume")
    private Integer costume;

    @XmlAttribute(name = "skinColor")
    private Integer skinColor;

    @XmlAttribute(name = "costumeSuffix")
    private String costumeSuffix;

    @XmlAttribute(name = "bombs")
    private Integer bombs;

    @XmlAttribute(name = "nameimage")
    private String nameimage;

    @XmlAttribute(name = "portrait")
    private String portrait;

    @XmlAttribute(name = "birthright")
    private String birthright;

    @XmlAttribute(name = "card")
    private Integer card;

    @XmlAttribute(name = "pocketActive")
    private Integer pocketActive;

    @XmlAttribute(name = "keys")
    private Integer keys;

    @XmlAttribute(name = "pill")
    private Integer pill;

    @XmlAttribute(name = "canShoot")
    private Boolean canShoot;

    @XmlAttribute(name = "extraportrait")
    private String extraportrait;

    @XmlAnyElement
    private List<Object> anyElements;

    // ====== GETTERS ======== //

    public Long getItGame() {
        return itGame;
    }

    public String getName() {
        return name;
    }

    public String getSkin() {
        return skin;
    }

    public Integer getHp() {
        return hp;
    }

    public Integer getArmor() {
        return armor;
    }

    public Integer getCoins() {
        return coins;
    }

    public Integer getItems() {
        return items;
    }

    public Integer getAchievement() {
        return achievement;
    }

    public Integer getBlack() {
        return black;
    }

    public Integer getCostume() {
        return costume;
    }

    public Integer getSkinColor() {
        return skinColor;
    }

    public String getCostumeSuffix() {
        return costumeSuffix;
    }

    public Integer getBombs() {
        return bombs;
    }

    public String getNameimage() {
        return nameimage;
    }

    public String getPortrait() {
        return portrait;
    }

    public String getBirthright() {
        return birthright;
    }

    public Integer getCard() {
        return card;
    }

    public Integer getPocketActive() {
        return pocketActive;
    }

    public Integer getKeys() {
        return keys;
    }

    public Integer getPill() {
        return pill;
    }

    public Boolean getCanShoot() {
        return canShoot;
    }

    public String getExtraportrait() {
        return extraportrait;
    }

    // ====== SETTERS ======== //

    public void setItGame(Long itGame) {
        this.itGame = itGame;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public void setArmor(Integer armor) {
        this.armor = armor;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public void setItems(Integer items) {
        this.items = items;
    }

    public void setAchievement(Integer achievement) {
        this.achievement = achievement;
    }

    public void setBlack(Integer black) {
        this.black = black;
    }

    public void setCostume(Integer costume) {
        this.costume = costume;
    }

    public void setSkinColor(Integer skinColor) {
        this.skinColor = skinColor;
    }

    public void setCostumeSuffix(String costumeSuffix) {
        this.costumeSuffix = costumeSuffix;
    }

    public void setBombs(Integer bombs) {
        this.bombs = bombs;
    }

    public void setNameimage(String nameimage) {
        this.nameimage = nameimage;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public void setBirthright(String birthright) {
        this.birthright = birthright;
    }

    public void setCard(Integer card) {
        this.card = card;
    }

    public void setPocketActive(Integer pocketActive) {
        this.pocketActive = pocketActive;
    }

    public void setKeys(Integer keys) {
        this.keys = keys;
    }

    public void setPill(Integer pill) {
        this.pill = pill;
    }

    public void setCanShoot(Boolean canShoot) {
        this.canShoot = canShoot;
    }

    public void setExtraportrait(String extraportrait) {
        this.extraportrait = extraportrait;
    }

    public void setAnyElements(List<Object> anyElements) {
        this.anyElements = anyElements;
    }
}
