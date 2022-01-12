import java.util.*;

public class Pokemon {
    //Reusable random
    public static Random rand = new Random();

    //Instance Variables
    private String name;
    private Types.type type1;
    private Types.type type2;
    private int MAXHP;
    private int HP;
    private int ATK;
    private int DEF;
    private int SPATK;
    private int SPDEF;
    private int SPD;
    private int level;
    private int critModifier;
    private double evasion;
    private boolean canMove;
    private List<Types.status> statuses = new ArrayList<Types.status>();
    private Object[][] moveSetArray;

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Types.type getType1() {
        return type1;
    }

    public void setType1(Types.type type1) {
        this.type1 = type1;
    }

    public Types.type getType2() {
        return type2;
    }

    public void setType2(Types.type type2) {
        this.type2 = type2;
    }

    public int getMAXHP() {
        return MAXHP;
    }

    public void setMAXHP(int MAXHP) {
        this.MAXHP = MAXHP;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
        if (this.HP < 0) {
            this.HP = 0;
        }
        if (this.HP > this.MAXHP) {
            this.HP = this.MAXHP;
        }
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getDEF() {
        return DEF;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public int getSPATK() {
        return SPATK;
    }

    public void setSPATK(int SPATK) {
        this.SPATK = SPATK;
    }

    public int getSPDEF() {
        return SPDEF;
    }

    public void setSPDEF(int SPDEF) {
        this.SPDEF = SPDEF;
    }

    public int getSPD() {
        return SPD;
    }

    public void setSPD(int SPD) {
        this.SPD = SPD;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCritModifier() {
        return critModifier;
    }

    public void setCritModifier(int critModifier) {
        this.critModifier = critModifier;
    }

    public double getEvasion() {
        return evasion;
    }

    public void setEvasion(double evasion) {
        this.evasion = evasion;
    }

    public boolean getCanMove() {
        return canMove;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public void addStatus(Types.status status) {
        this.statuses.add(status);
    }

    public void removeStatus(Types.status status) {
        this.statuses.remove(status);
    }

    public String getStatusesToString() {
        return statuses.toString();
    }

    public Object[][] getMoveSetArray() {
        return moveSetArray;
    }

    public void setMoveSetArray(Object[][] moveSetArray) {
        this.moveSetArray = moveSetArray;
    }

    //Constructors
    public Pokemon(String name, Types.type type1, int HP, int ATK, int DEF, int SPATK, int SPDEF, int SPD, Object[][] moveSetArray) {
        this.name = name;
        this.type1 = type1;
        this.type2 = Types.type.NOSECONDTYPE;
        this.MAXHP = HP;
        this.HP = HP;
        this.ATK = ATK;
        this.DEF = DEF;
        this.SPATK = SPATK;
        this.SPDEF = SPDEF;
        this.SPD = SPD;
        this.level = 80;
        this.critModifier = 0;
        this.evasion = 1.0;
        this.canMove = true;
        this.moveSetArray = moveSetArray;
    }
    public Pokemon(String name, Types.type type1, Types.type type2, int HP, int ATK, int DEF, int SPATK, int SPDEF, int SPD, Object[][] moveSetArray) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.MAXHP = HP;
        this.HP = HP;
        this.ATK = ATK;
        this.DEF = DEF;
        this.SPATK = SPATK;
        this.SPDEF = SPDEF;
        this.SPD = SPD;
        this.level = 80;
        this.critModifier = 0;
        this.evasion = 1.0;
        this.canMove = true;
        this.moveSetArray = moveSetArray;
    }

    private static boolean critTester(int critModifier) {
        int max;
        if (critModifier == 0) {
            max = 24;
        }
        else if (critModifier == 1) {
            max = 8;
        }
        else {
            max = 2;
        }
        int randomNum = rand.nextInt(max+1)+1;
        int randomNum2 = rand.nextInt(max+1)+1;
        return randomNum == randomNum2;
    }

    private static boolean accuracyTester(int moveAccuracy, double enemyEvasion) {
        double adjustedAccuracy = moveAccuracy * enemyEvasion;
        int randomNum = rand.nextInt(100)+1;
        return adjustedAccuracy > randomNum;
    }

    private static double effectivnessChecker(Types.type moveType, Types.type enemyType, Types.type enemyType2) {
        double[][] typeWeaknessesChart = {
                        // nor  fir  wat  ele  gra  ice  fig  poi  gro  fly  psy  bug  roc  gho  dra  dar  ste  fai  nos
                /* nor */ {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 0.0, 1.0, 1.0, 0.5, 1.0, 1.0},
                /* fir */ {1.0, 0.5, 0.5, 1.0, 2.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 0.5, 1.0, 2.0, 1.0, 1.0},
                /* wat */ {1.0, 2.0, 0.5, 1.0, 0.5, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 1.0, 1.0, 1.0},
                /* ele */ {1.0, 1.0, 2.0, 0.5, 0.5, 1.0, 1.0, 1.0, 0.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 1.0},
                /* gra */ {1.0, 0.5, 2.0, 1.0, 0.5, 1.0, 1.0, 0.5, 2.0, 0.5, 0.0, 0.5, 2.0, 1.0, 0.5, 1.0, 0.5, 1.0, 1.0},
                /* ice */ {1.0, 0.5, 0.5, 1.0, 2.0, 0.5, 1.0, 1.0, 2.0, 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 1.0},
                /* fig */ {2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 0.5, 0.5, 0.5, 2.0, 0.0, 1.0, 2.0, 2.0, 0.5, 1.0},
                /* poi */ {1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 0.5, 1.0, 1.0, 1.0, 0.5, 0.5, 1.0, 1.0, 0.0, 2.0, 1.0},
                /* gro */ {1.0, 2.0, 1.0, 2.0, 0.5, 1.0, 1.0, 2.0, 1.0, 0.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0},
                /* fly */ {1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0},
                /* psy */ {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 0.0, 0.5, 1.0, 1.0},
                /* bug */ {1.0, 0.5, 1.0, 1.0, 2.0, 1.0, 0.5, 0.5, 1.0, 0.5, 2.0, 1.0, 1.0, 0.5, 1.0, 2.0, 0.5, 0.5, 1.0},
                /* roc */ {1.0, 2.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 0.5, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0},
                /* gho */ {0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 1.0, 1.0},
                /* dra */ {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 0.0, 1.0},
                /* dar */ {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 0.5, 1.0},
                /* ste */ {1.0, 0.5, 0.5, 0.5, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0},
                /* fai */ {1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 0.5, 1.0, 1.0}
        };
        double effectivness = 1.0;
        effectivness = typeWeaknessesChart[moveType.ordinal()] [enemyType.ordinal()] * typeWeaknessesChart[moveType.ordinal()] [enemyType2.ordinal()];
        return effectivness;
    }

    private int physicalAttack(Types.type moveType, Pokemon opponent, int power) {
        int damage = 0;
        double randomnessModifier = 0.85 + (1.0 - 0.85) * rand.nextDouble();

        double STAB = 1.0;
        if (moveType == getType1() || moveType == getType2()) {
            STAB = 1.5;
        }
        damage = (int) (((((((2 * this.getLevel()) / 5) + 2) * power * ((double) this.getATK() / (double) opponent.getDEF())) /50) + 2) * randomnessModifier * STAB * effectivnessChecker(moveType, opponent.getType1(), opponent.getType2()));
        return damage;
    }
    private int specialAttack(Types.type moveType, Pokemon opponent, int power) {
        int damage = 0;
        double randomnessModifier = 0.85 + (1.0 - 0.85) * rand.nextDouble();
        double STAB = 1.0;
        if (moveType == getType1() || moveType == getType2()) {
            STAB = 1.5;
        }
        damage = (int) (((((((2 * this.getLevel()) / 5) + 2) * power * ((double) this.getSPATK() / (double) opponent.getSPDEF())) / 50) + 2) * randomnessModifier * STAB * effectivnessChecker(moveType, opponent.getType1(), opponent.getType2()));
        return damage;
    }

    private String effectivenessString(Types.type moveType, Pokemon opponent) {
        double effectiveness = effectivnessChecker(moveType, opponent.getType1(), opponent.getType2());
        if (effectiveness == 0.0) {
            return "It had no effect.";
        } else if (effectiveness > 1.0) {
            return "It was super effective!";
        } else if (effectiveness < 1.0) {
            return "It wasn't very effective.";
        } else {
            return "";
        }
    }

    public void attackString(Pokemon player, String attackName, Types.type moveType, Types.attackType attackType, int power, int healingPower, int accuracy, Types.status status, int statusChance, String target, Pokemon opponent) throws InterruptedException {
        if (accuracyTester(accuracy, opponent.getEvasion())) {
            int damage = 0;
            boolean critCheck = true;
            if (attackType.equals(Types.attackType.SPECIAL)) {
                damage = specialAttack(moveType, opponent, power);
            } else if (attackType.equals(Types.attackType.PHYSICAL)) {
                damage = physicalAttack(moveType, opponent, power);
            }

            if (damage == 0) {
                critCheck = false;
            }

            System.out.println(this.getName() + " used " + attackName);
            Thread.sleep(1000);

            String effectivenessString = effectivenessString(moveType, opponent);
            if (effectivenessString.equals("It had no effect.")) {
                critCheck = false;
            }
            if (!effectivenessString.equals("")) {
                System.out.println(effectivenessString);
            }
            Thread.sleep(1000);

            if(critTester(getCritModifier()) && critCheck) {
                System.out.println("A critical hit!");
                damage *= 1.5;
                Thread.sleep(1000);
            }

            if (damage != 0) {
                opponent.setHP(opponent.getHP() - damage);
                System.out.println(attackName + " dealt " + damage + " damage");
            }
            if (healingPower > 0) {
                player.setHP(player.getHP()+healingPower);
                System.out.println("Healed for " + healingPower + " HP");
            }

            if (status != Types.status.NOSTATUSEFFECT) {
                if (target.equals("OPPONENT")) {
                    if (rand.nextInt(100) + 1 <= statusChance) {
                        opponent.addStatus(status);
                        Thread.sleep(1000);
                        System.out.println(opponent.getName() + " is " + status.toString());
                    }
                } else {
                    if (rand.nextInt(100) + 1 <= statusChance) {
                        player.addStatus(status);
                        Thread.sleep(1000);
                        System.out.println(player.getName() + " is " + status.toString());
                    }
                }
            }
            return;
        }
        System.out.println(player.getName() + " used " + attackName + ", but it failed!");
    }

    //temp variable for paralyzation check
    boolean hasBeenParalyzed = true;

    public void statusDamage() {
        if (this.getHP() > 0) {
            if (statuses.contains(Types.status.BURNED)) {
                int burnDamage = getMAXHP() / 16;
                setHP(getHP() - burnDamage);
                System.out.println(getName() + " is BURNED");
                System.out.println(getName() + " took " + burnDamage + " damage.");
            }
            if (statuses.contains(Types.status.FROZEN)) {
                this.setCanMove(false);
                if (rand.nextInt((5 - 1) + 1) + 1 == 1) {
                    this.setCanMove(true);
                    removeStatus(Types.status.FROZEN);
                    System.out.println(getName() + " was unfrozen");
                } else {
                    System.out.println(getName() + " is FROZEN!");
                }
            }
            if (statuses.contains(Types.status.PARALYZED)) {
                if (hasBeenParalyzed) {
                    this.setSPD((this.getSPD() * 3) / 4);
                    hasBeenParalyzed = false;
                }
                if (rand.nextInt((4 - 1) + 1) + 1 == 1) {
                    this.setCanMove(false);
                    hasBeenParalyzed = true;
                    System.out.println(getName() + " is PARALYZED, it cannot move");
                }
            }
            if (statuses.contains(Types.status.POISONED)) {
                int poisonDamage = getMAXHP() / 16;
                setHP(getHP() - poisonDamage);
                System.out.println(getName() + " is POSIONED");
                System.out.println(getName() + " took " + poisonDamage + " damage.");
            }
            if (statuses.contains(Types.status.ASLEEP)) {
                if (rand.nextInt((4 - 1) + 1) + 1 < 4) {
                    this.setCanMove(false);
                    System.out.println(getName() + " is ASLEEP, it cannot move");
                } else {
                    this.setCanMove(true);
                    System.out.println(getName() + " woke up!");
                    this.statuses.remove(Types.status.ASLEEP);
                }
            }
            if (statuses.contains(Types.status.RECHARGING)) {
                this.setCanMove(false);
                System.out.println(getName() + " is RECHARGING and cannot move this turn");
                this.statuses.remove(Types.status.RECHARGING);
            }
        }

    }
}
