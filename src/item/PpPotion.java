package item;

import core.Consumable;
import entity.Hero;

public class PpPotion implements Consumable, Comparable<PpPotion> {
    private final int ppAmount;

    public PpPotion(int ppAmount) {
        this.ppAmount = ppAmount;
    }

    @Override
    public void consume(Hero hero) {
        hero.recoverPp(hero.getPp() + this.ppAmount);
    }

    @Override
    public String toString() {
        return "Health Potion (+" + ppAmount + " PP)";
    }

    @Override
    public int compareTo(PpPotion o) {
        return Integer.compare(this.ppAmount, o.ppAmount);
    }
}
