package entity;

import core.Character;
import core.Consumable;

public class Hero extends Character {
    private final int defend;
    private int pp;
    private Consumable consumable;

    public Hero(String name, int hp, int attackDamage, int defend, int pp, Consumable consumable) {
        super(name, hp, 100, attackDamage);
        this.defend = defend;
        this.pp = pp;
        this.consumable = consumable;
    }

    public void useConsumable() {
        if (hasConsumable()) {
            consumable.consume(this);
            consumable = null;
        }
    }

    public boolean hasConsumable() {
        return consumable != null;
    }

    @Override
    public String toString() {
        return "[Hero] " + getName();
    }

    public int getPp() {
        return pp;
    }

    public void decreasePp() {
        --this.pp;
    }

    public int getDefend() {
        return defend;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }
}
