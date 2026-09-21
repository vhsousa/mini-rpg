public class Hero {


    private String name;
    private int hp;
    private int maxHp;
    private int attack;
    private int defend;
    private int pp;
    private Potion potion;

    public Hero(String name, int hp, int attack, int defend, int pp, Potion potion) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defend = defend;
        this.pp = pp;
        this.potion = potion;
        this.maxHp = 100;
    }

    public int getHp() {
        return hp;
    }

    public void recoverHealth() {
        if (potion == null || maxHp == hp) return;

        this.hp = Math.min(hp + potion.getHealAmount(), maxHp);
        this.potion = null;
    }

    public boolean hasPotion() {
        return potion != null;
    }

    public void sufferDamage(int damage) {
        this.hp -= damage;
    }

    @Override
    public String toString() {
        return "[Hero] "+ this.name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
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

    public void setDefend(int defend) {
        this.defend = defend;
    }

    public boolean isAlive() {
        return hp > 0;
    }
}
