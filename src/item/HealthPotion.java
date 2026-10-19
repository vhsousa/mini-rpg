package item;

import core.Consumable;
import entity.Hero;

public class HealthPotion implements Consumable, Comparable<HealthPotion> {
    private final int healAmount;

    public HealthPotion(int healAmount) {
        this.healAmount = healAmount;
    }

    @Override
    public void consume(Hero hero) {
        hero.setHp(hero.getHp() + healAmount);
    }

    @Override
    public String toString() {
        return "Health Potion (+" + healAmount + " HP)";
    }

    public int compareTo(HealthPotion o) {
        return Integer.compare(this.healAmount, o.healAmount);
    }
}
