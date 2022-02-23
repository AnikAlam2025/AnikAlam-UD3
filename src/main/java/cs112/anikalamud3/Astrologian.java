package cs112.anikalamud3;

public class Astrologian extends WarriorOfLight {

    //CONSTANT VARIABLES
    public static final String DEFAULT_NAME = "Urianger Augurelt", DEFAULT_RACE = "Elezen", DEFAULT_MOUNT = "SDS Fenrir", DEFAULT_MINION = "Fae Gwiber";
    public static final int DEFAULT_CHARACTER_LEVEL = 50, DEFAULT_HIT_POINTS = 9250, DEFAULT_DEFENSE = 35;
    public static final Weapon DEFAULT_WEAPON = new Weapon("Atlas", "Star Globe", "Magic", 81, 50);

    //FULL CONSTRUCTOR
    public Astrologian(String name, String race, String mount, String minion, int characterLevel, int hitPoints, int defense, Weapon weapon) {
        super(name, race, mount, minion, characterLevel, hitPoints, defense, weapon);
    }

    //DEFAULT CONSTRUCTOR
    public Astrologian() {
        this(Astrologian.DEFAULT_NAME, Astrologian.DEFAULT_RACE, Astrologian.DEFAULT_MOUNT, Astrologian.DEFAULT_MINION, Astrologian.DEFAULT_CHARACTER_LEVEL, Astrologian.DEFAULT_HIT_POINTS, Astrologian.DEFAULT_DEFENSE,  Astrologian.DEFAULT_WEAPON);
    }

    public Astrologian(Astrologian original) {
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
        //int baseDamage = weapon.getAutoAttackDamage();
        int baseDamage = 500;
        int updatedHitPoints = other.getHitPoints();

        if(baseDamage > updatedHitPoints) {
            baseDamage = updatedHitPoints;
        }

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
    public boolean offensiveAbility(WarriorOfLight other) { //ability called Malefic IV
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
            System.out.println("Warrior Of Light successfully casts Malefic IV, deals " + abilityDamage + " damage");
            return true;
        } else {
            System.out.println("Warrior Of Light failed to cast Malefic IV");
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
    public void defensiveAbility(WarriorOfLight other) { //ability called Benefic II
        int beneficII = this.getHitPoints() + 700;
        this.setHitPoints(beneficII);
        System.out.println(this.getName() + " casted Benefic II, +700 HP");
    }

    // emote
    /*
     * unique emote for each character
     *
     * @Param other WarriorOfLight emotes
     */
    @Override
    public void emote(WarriorOfLight other) {

        //System.out.println(this.getName() + " performs the Bees Knees!");

        String dance = " performs the Bees Knees!";
    }
}