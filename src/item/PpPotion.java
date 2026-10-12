package item;

import core.Consumable;
import entity.Hero;

public class PpPotion implements Consumable {
    private final int amnt;

    public PpPotion(int amnt) {
        this.amnt = amnt;
    }

    @Override
    public void consume(Hero hero) {
        hero.setPp(hero.getPp() + this.amnt);
    }
}
