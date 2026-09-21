Random rand = new Random();
Scanner sc = new Scanner(System.in);

String heroName = "Arin";
int heroHp = 100;
int heroMaxHp = 100;
int heroAttack = 10;
int heroDefend = 2;
int heroPP = 5;

String monsterName = "Goblin";
int monsterHp = 80;
int monsterDamage = 12;

boolean flee = false;

void menu() {
    IO.println("1 - Attack");
    IO.println("2 - Heal");
    IO.println("3 - Flee");
}

void heroAttack() {
    // Hero's turn
    IO.println("Hero is attacking...");
    int attack = rand.nextInt(5) + heroAttack;
    monsterHp -= attack;
    IO.println("Hero dealt a " + attack + " attack");
}

void monsterAttack() {
    // Monster's turn
    IO.println("Monster is attacking...");
    boolean canDefend = rand.nextBoolean();
    int attack = rand.nextInt(monsterDamage);
    if (canDefend) {
        if (heroPP > 0) {

            // We can defend a partial attack
            heroPP--;
            IO.println("Hero is defending...");
            attack -= heroDefend;

            if (attack == 0) {
                IO.println("Hero deflected the attack!");
            }
        } else {
            IO.println("Hero tried to defend but has no PP left");
        }
    }

    if (attack > 0) {
        heroHp -= attack;
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
    IO.println("Hero is recovering health...");
    heroHp = Math.min(heroHp + 5, heroMaxHp);
    attack(false);
}

void main() {
    while (heroHp > 0 && monsterHp > 0 && !flee) {
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
            System.out.printf("[%s] Hero's health: %d hp\n", heroName, heroHp);
            System.out.printf("[%s] Monsters's health: %d hp\n", monsterName, monsterHp);
        }

        if (heroHp == 0) {
            IO.println("Hero defeated!");
        } else if (monsterHp == 0) {
            IO.println("Monster defeated!");
        }
    }
}