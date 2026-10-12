package item;

import core.Consumable;
import entity.Hero;

public class HealthPotion implements Consumable {
    private final int healAmount;

    public HealthPotion(int healAmount) {
        this.healAmount = healAmount;
    }

    @Override
    public void consume(Hero hero) {
        hero.setHp(hero.getHp() + healAmount);
    }
}
