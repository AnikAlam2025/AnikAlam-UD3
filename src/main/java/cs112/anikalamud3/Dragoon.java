package cs112.anikalamud3;

public class Dragoon extends WarriorOfLight {

    //CONSTANT VARIABLES
    public static final String DEFAULT_NAME = "Estinien Wyrmblood", DEFAULT_RACE = "Elezen", DEFAULT_MOUNT = "Midgardsormr", DEFAULT_MINION = "	Wind-up Estinien";
    public static final int DEFAULT_CHARACTER_LEVEL = 50, DEFAULT_HIT_POINTS = 9250, DEFAULT_DEFENSE = 40;
    public static final Weapon DEFAULT_WEAPON = new Weapon("Gae Bolg", "Polearm", "Physical", 46, 50);

    //FULL CONSTRUCTOR
    public Dragoon(String name, String race, String mount, String minion, int characterLevel, int hitPoints, int defense, Weapon weapon) {
        super(name, race, mount, minion, characterLevel, hitPoints, defense, weapon);
    }

    //DEFAULT CONSTRUCTOR
    public Dragoon() {
        this(Dragoon.DEFAULT_NAME, Dragoon.DEFAULT_RACE, Dragoon.DEFAULT_MOUNT, Dragoon.DEFAULT_MINION, Dragoon.DEFAULT_CHARACTER_LEVEL, Dragoon.DEFAULT_HIT_POINTS, Dragoon.DEFAULT_DEFENSE,  Dragoon.DEFAULT_WEAPON);
    }

    public Dragoon(Dragoon original) {
        super(original);
    }

    // ABSTRACT METHODS

    // autoAttack
    /*
     * Default attack of every character, does damage based on the auto attack damage of the weapon
     *
     * @Param other WarriorOfLight attacks opposing character
     */
    @Override
    public boolean autoAttack(WarriorOfLight other) {
        int baseDamage = 500;
        int updatedHitPoints = other.getHitPoints();

        if(baseDamage > updatedHitPoints) {
            baseDamage = updatedHitPoints;
        }
        System.out.println(baseDamage);
        updatedHitPoints -= baseDamage;
        other.setHitPoints(updatedHitPoints);
        return true;
    }

    // offensiveAbility
    /*
     * offensiveAbility of each job, based on the damage type of the weapon with a modifier for each ability that scales with level
     *
     * @Param other WarriorOfLight attacks opposing character
     */
    @Override
    public boolean offensiveAbility(WarriorOfLight other) { //ability called Stardiver
        //int abilityDamage = (weapon.getAutoAttackDamage() * (other.getCharacterLevel()/2))  - (other.getDefense()/5);
        int abilityDamage = 500;
        int updatedHitPoints = other.getHitPoints();
        int diceRoll = (int)(Math.random() * 20);

        if(abilityDamage > updatedHitPoints) {
            abilityDamage = updatedHitPoints;
        }
        //will integrate job specific interactions that boost/detract from roll; will complete basic functionality first
        if(diceRoll > 10) {
            updatedHitPoints -= abilityDamage;
            other.setHitPoints(updatedHitPoints);
            System.out.println("Warrior Of Light successfully casts Stardiver, deals " + abilityDamage + " damage");
            System.out.println(abilityDamage);
            return true;
        } else {
            System.out.println("Warrior Of Light failed to cast Stardiver");
            return false;
        }
    }

    // defensiveAbility
    /*
     * defensiveAbility unique to each job, based on the damage type of the weapon with a modifier for each job
     *
     * @Param other WarriorOfLight uses defensive ability
     */
    @Override
    public void defensiveAbility(WarriorOfLight other) { //ability called Bloodbath
        int bloodbath = this.getHitPoints() + 150;
        int dragoonMastery = weapon.getAutoAttackDamage() + 25;

        this.setHitPoints(bloodbath);
        weapon.setAutoAttackDamage(dragoonMastery);
        System.out.println(this.getName() + " casted Bloodbath, +150 HP; Activated Dragoon Mastery, +25 Auto Attack Damage");
    }

    // emote
    /*
     * unique dance emote for each character
     *
     * @Param other WarriorOfLight emotes
     */
    @Override
    public void emote(WarriorOfLight other) {
        System.out.println(this.getName() + " performs the Goobbue Gallop!");
    }
}
