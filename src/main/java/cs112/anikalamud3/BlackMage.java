package cs112.anikalamud3;

public class BlackMage extends WarriorOfLight {

    //CONSTANT VARIABLES
    public static final String DEFAULT_NAME = "Y'shtola Rhul", DEFAULT_RACE = "Miqo'te", DEFAULT_MOUNT = "Fatter Cat", DEFAULT_MINION = "Wind-up Y'shtola";
    public static final int DEFAULT_CHARACTER_LEVEL = 50, DEFAULT_HIT_POINTS = 8750, DEFAULT_DEFENSE = 30;
    public static final Weapon DEFAULT_WEAPON = new Weapon("Truth Seeker", "Scepter", "Magic", 53, 50);

    //FULL CONSTRUCTOR
    public BlackMage(String name, String race, String mount, String minion, int characterLevel, int hitPoints, int defense, Weapon weapon) {
        super(name, race, mount, minion, characterLevel, hitPoints, defense, weapon);
    }

    //DEFAULT CONSTRUCTOR
    public BlackMage() {
        this(BlackMage.DEFAULT_NAME, BlackMage.DEFAULT_RACE, BlackMage.DEFAULT_MOUNT, BlackMage.DEFAULT_MINION, BlackMage.DEFAULT_CHARACTER_LEVEL, BlackMage.DEFAULT_HIT_POINTS , BlackMage.DEFAULT_DEFENSE, BlackMage.DEFAULT_WEAPON);
    }

    public BlackMage(BlackMage original) {
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
    public boolean offensiveAbility(WarriorOfLight other) { //ability called Astral Fire IV
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
            System.out.println("Warrior Of Light successfully casts Astral Fire IV, deals " + abilityDamage + " damage");
            return true;
        } else {
            System.out.println("Warrior Of Light failed to cast Astral Fire IV");
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
    public void defensiveAbility(WarriorOfLight other) { //ability called manaward
        int manaWard = this.getHitPoints() + 650;
        this.setHitPoints(manaWard);
        System.out.println(this.getName() + " casted Mana Ward, +650 HP");
    }

    // emote
    /*
     * unique dance emote for each character
     *
     * @Param other WarriorOfLight emotes
     */
    @Override
    public void emote(WarriorOfLight other) {
        System.out.println(this.getName() + " performs the Manderville Mambo!");
    }
}