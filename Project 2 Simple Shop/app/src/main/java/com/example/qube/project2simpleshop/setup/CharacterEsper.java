package com.example.qube.project2simpleshop.setup;

/**
 * Created by Qube on 8/1/16.
 */
public class CharacterEsper {

    private int id, price, quantity, hp, mp, atk, def, mag, spr;
    private String icon, name, type, rarity, category, origin;

    public CharacterEsper() {
    }

    public CharacterEsper(int id, String icon, String name, String type, String rarity, int price, int quantity,
                          String category, int hp, int mp, int atk, int def, int mag, int spr, String origin) {

        this.id = id;
        this.icon = icon;
        this.name = name;
        this.type = type;
        this.rarity = rarity;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.hp = hp;
        this.mp = mp;
        this.atk = atk;
        this.def = def;
        this.mag = mag;
        this.spr = spr;
        this.origin = origin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getMag() {
        return mag;
    }

    public void setMag(int mag) {
        this.mag = mag;
    }

    public int getSpr() {
        return spr;
    }

    public void setSpr(int spr) {
        this.spr = spr;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
