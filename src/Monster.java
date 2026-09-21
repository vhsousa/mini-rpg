public class Monster {
    private final String name;
    private int hp;
    private int attack;

    public Monster(String name, int hp, Difficulty difficulty) {
        this.name = name;
        this.hp = hp;
        setAttack(difficulty);
    }

    @Override
    public String toString() {
        return "[Monster] " + this.name;
    }

    public int getHp() {
        return hp;
    }

    public void sufferDamage(int damage) {
        this.hp -= damage;
    }

    public int getAttack() {
        return attack;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    private void setAttack(Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                attack = 3;
                break;
            case MEDIUM:
                attack = 10;
                break;
            case HARD:
                attack = 25;
                break;
        }
    }
}
