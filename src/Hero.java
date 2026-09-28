public class Hero extends Character {
    private final int defend;
    private int pp;
    private Potion potion;

    public Hero(String name, int hp, int attackDamage, int defend, int pp, Potion potion) {
        super(name, hp, 100, attackDamage);
        this.defend = defend;
        this.pp = pp;
        this.potion = potion;
    }

    public void recoverHealth() {
        if (potion == null) return;
        setHp(getHp() + potion.getHealAmount());
        this.potion = null;
    }

    public boolean hasPotion() {
        return potion != null;
    }

    @Override
    public String toString() {
        return "[Hero] "+ getName();
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
}
