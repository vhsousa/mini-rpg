package entity;

import core.Character;
import core.Difficulty;

public class Monster extends Character {
    public Monster(String name, int hp, int maxHp, Difficulty difficulty) {
        super(name, hp, maxHp);
        setAttackDamage(getAttackDamage(difficulty));
    }

    @Override
    public String toString() {
        return "[Monster] " + getName();
    }

    private int getAttackDamage(Difficulty difficulty) {
        return switch (difficulty) {
            case EASY -> 3;
            case MEDIUM -> 10;
            case HARD -> 25;
        };
    }
}
