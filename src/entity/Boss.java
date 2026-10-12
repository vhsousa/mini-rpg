package entity;

import core.Difficulty;

public class Boss extends Monster {
    private boolean enraged;
    private int attackCounter = 0;

    public Boss(String name, int hp, int maxHp, Difficulty difficulty) {
        super(name, hp, maxHp, difficulty);
    }
    @Override
    public String toString() {
        return "[Boss] " + getName();
    }

    @Override
    public int attack() {
        int factor = enraged ? 10 : 1;
        int baseAttack = super.attack() * factor;

        attackCounter++;
        if (!enraged && attackCounter >= 5) {
            enraged = true;
        }

        return baseAttack;
    }
}
