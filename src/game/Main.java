import core.Consumable;
import core.Difficulty;
import entity.Boss;
import entity.Hero;
import entity.Monster;
import item.HealthPotion;

Random rand = new Random();
Scanner sc = new Scanner(System.in);

Consumable potion = new HealthPotion (10);

Hero hero = new Hero("Arin", 100, 10, 4, 5, potion);
Monster monster = new Boss("Goblin", 80, 100, Difficulty.HARD);

boolean flee = false;

void menu() {
    IO.println("1 - Attack");
    IO.println("2 - Heal");
    IO.println("3 - Flee");
}

void heroAttack() {
    // entity.Hero's turn
    int attack = hero.attack();
    monster.sufferDamage(attack);
    IO.println(hero + " dealt a " + attack + " attack");
}

void monsterAttack() {
    // entity.Monster's turn
    boolean canDefend = rand.nextBoolean();
    int attack = monster.attack();
    if (canDefend) {
        if (hero.getPp() > 0) {
            // We can defend a partial attack
            hero.decreasePp();
            IO.println(hero + " is defending...");
            attack -= hero.getDefend();

            if (attack == 0) {
                IO.println(hero + " deflected the attack!");
            }
        } else {
            IO.println(hero + " tried to defend but has no PP left");
        }
    }

    if (attack > 0) {
        hero.sufferDamage(attack);
        IO.println(hero + " suffered a " + attack + " attack");
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
    // entity.Hero health +++
    if (hero.hasConsumable()) {
        IO.println(hero + " is recovering health...");
        int previousHealth = hero.getHp();
        hero.useConsumable();
        System.out.printf(hero + " recovered %d\n", hero.getHp() - previousHealth);
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
            IO.println(hero + " defeated!");
        } else if (!monster.isAlive()) {
            IO.println(monster + " defeated!");
        }
    }
}