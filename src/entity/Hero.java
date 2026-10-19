package entity;

import core.Character;
import core.Consumable;

import java.util.ArrayList;

public class Hero extends Character {
    private final int defend;
    private int pp;
    private final ArrayList<Consumable> inventory = new ArrayList<>();

    public Hero(String name, int hp, int attackDamage, int defend, int pp) {
        super(name, hp, 100, attackDamage);
        this.defend = defend;
        this.pp = pp;
    }

    public boolean addConsumable(Consumable consumable) {
        if (consumable != null) {
            this.inventory.add(consumable);
            return true;
        }
        return false;
    }

    public void showInventory() {
        int i = 0;
        for (Consumable consumable : this.inventory) {
            System.out.println(i++ + " " + consumable.toString());
        }
    }

    public boolean useConsumable(int index) {
        if (hasConsumables()) {
            Consumable c = inventory.get(index);
            c.consume(this);
            inventory.remove(index);
            return true;
        }
        return false;
    }

    public boolean hasConsumables() {
        return !inventory.isEmpty();
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

    public void recoverPp(int pp) {
        this.pp = pp;
    }
}
