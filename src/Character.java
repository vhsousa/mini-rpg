public class Character {
    private final String name;
    private int hp;
    private int maxHp;
    private int attackDamage;

    public Character(String name, int hp, int maxHp, int attackDamage) {
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.attackDamage = attackDamage;
    }

    public Character(String name, int hp, int maxHp) {
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
    }

    public int getHp() {
        return hp;
    }

    public void sufferDamage(int damage) {
        this.hp -= damage;
    }

    @Override
    public String toString() {
        return "[Character] "+ this.name;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void setHp(int hp) {
        this.hp = Math.min(hp, this.maxHp);
    }

    public int attack() {
        System.out.println("CHARACTER IS ATTACKING");
        return attackDamage;
    }
}
