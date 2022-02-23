package cs112.anikalamud3;

public class Scholar extends WarriorOfLight {

    //CONSTANT VARIABLES
    public static final String DEFAULT_NAME = "Alphinaud Leveilleur", DEFAULT_RACE = "Elezen", DEFAULT_MOUNT = "Peridot Carbuncle", DEFAULT_MINION = "	Wind-up Alphinaud";
    public static final int DEFAULT_CHARACTER_LEVEL = 50, DEFAULT_HIT_POINTS = 7000, DEFAULT_DEFENSE = 30;
    public static final Weapon DEFAULT_WEAPON = new Weapon("Last Resort Zeta", "Book", "Magic", 60, 50);

    //FULL CONSTRUCTOR
    public Scholar(String name, String race, String mount, String minion, int characterLevel, int hitPoints, int defense, Weapon weapon) {
        super(name, race, mount, minion, characterLevel, hitPoints, defense, weapon);
    }

    //DEFAULT CONSTRUCTOR
    public Scholar() {
        this(Scholar.DEFAULT_NAME, Scholar.DEFAULT_RACE, Scholar.DEFAULT_MOUNT, Scholar.DEFAULT_MINION, Scholar.DEFAULT_CHARACTER_LEVEL, Scholar.DEFAULT_HIT_POINTS , Scholar.DEFAULT_DEFENSE, Scholar.DEFAULT_WEAPON);
    }

    public Scholar(Scholar original) {
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
    public boolean offensiveAbility(WarriorOfLight other) { //ability called Broil IV
        //int abilityDamage = (weapon.getAutoAttackDamage() * (other.getCharacterLevel()/4))  - (other.getDefense()/6);
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
            System.out.println("Warrior Of Light successfully casts Broil IV, deals " + abilityDamage + " damage");
            System.out.println(abilityDamage);
            return true;
        } else {
            System.out.println("Warrior Of Light failed to cast Broil IV");
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
    public void defensiveAbility(WarriorOfLight other) { //ability called Consolation
        int consolation = this.getHitPoints() + 500;
        int defenseBoost = this.getDefense() + 3;
        this.setHitPoints(consolation);
        this.setDefense(defenseBoost);
        System.out.println(this.getName() + " casted Consolation, +500HP, +2 Defense");
    }

    // emote
    /*
     * unique dance emote for each character
     *
     * @Param other WarriorOfLight emotes
     */
    @Override
    public void emote(WarriorOfLight other) {
        System.out.println(this.getName() + " performs the Crimson Lotus!");
    }
}