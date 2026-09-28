public class Boss extends Monster {
    private boolean enraged;
    private int attackCounter = 0;

    public Boss(String name, int hp, int maxHp, Difficulty difficulty) {
        super(name, hp, maxHp, difficulty);
    }

    @Override
    public int attack() {
        System.out.printf("BOSS IS ATTACKING enraged:%b\n", enraged);
        int factor = enraged ? 10 : 1;
        int baseAttack = super.attack() * factor;

        attackCounter++;
        if (!enraged && attackCounter >= 5) {
            enraged = true;
        }

        return baseAttack;
    }
}
