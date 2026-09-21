Random rand = new Random();
Scanner sc = new Scanner(System.in);

Potion potion = new Potion("Health potion", 10);
Hero hero = new Hero("Arin", 100, 10, 4, 5, potion);
Monster monster = new Monster("Goblin", 80, Difficulty.HARD);
boolean flee = false;

void menu() {
    IO.println("1 - Attack");
    IO.println("2 - Heal");
    IO.println("3 - Flee");
}

void heroAttack() {
    // Hero's turn
    IO.println("Hero is attacking...");
    int attack = rand.nextInt(5) + hero.getAttack();
    monster.sufferDamage(attack);
    IO.println("Hero dealt a " + attack + " attack");
}

void monsterAttack() {
    // Monster's turn
    IO.println("Monster is attacking...");
    boolean canDefend = rand.nextBoolean();
    int attack = rand.nextInt(monster.getAttack());
    if (canDefend) {
        if (hero.getPp() > 0) {
            // We can defend a partial attack
            hero.decreasePp();
            IO.println("Hero is defending...");
            attack -= hero.getDefend();

            if (attack == 0) {
                IO.println("Hero deflected the attack!");
            }
        } else {
            IO.println("Hero tried to defend but has no PP left");
        }
    }

    if (attack > 0) {
        hero.sufferDamage(attack);
        IO.println("Hero suffered a " + attack + " attack");
    }
}

void attack(boolean heroCanAttack) {
    boolean heroAttacks = rand.nextBoolean();

    if (!heroCanAttack) {
        monsterAttack();
    } else if (heroAttacks) {
        heroAttack();
        monsterAttack();
    } else {
        monsterAttack();
        heroAttack();
    }
}

void flee() {
    flee = rand.nextBoolean();
    if (flee) {
        IO.println("Ran away safely...");
    } else {
        IO.println("The monster has blocked you from running away!!");
    }
}

void heal() {
    // Hero health +++
    if (hero.hasPotion()) {
        IO.println("Hero is recovering health...");
        int previousHealth = hero.getHp();
        hero.recoverHealth();
        System.out.printf("Hero recovered %d\n", hero.getHp() - previousHealth);
        attack(false);
    } else {
        IO.println("No potions left!");
    }
}

void main() {
    while (hero.isAlive() && monster.isAlive() && !flee) {
        menu();
        String command = sc.nextLine();
        switch (command) {
            case "1":
                attack(true);
                break;
            case "2":
                heal();
                break;
            case "3":
                flee();
                break;
            default:
                IO.println("Invalid command!");
                continue;
        }

        if (!flee) {
            System.out.printf("[%s] health: %d hp\n", hero, hero.getHp());
            System.out.printf("[%s] health: %d hp\n", monster, monster.getHp());
        }

        if (!hero.isAlive()) {
            IO.println("Hero defeated!");
        } else if (!monster.isAlive()) {
            IO.println("Monster defeated!");
        }
    }
}