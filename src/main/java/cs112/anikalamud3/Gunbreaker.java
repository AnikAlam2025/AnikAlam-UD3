package cs112.anikalamud3;

public class Gunbreaker extends WarriorOfLight {

    //CONSTANT VARIABLES
    public static final String DEFAULT_NAME = "Thancred Waters", DEFAULT_RACE = "Hyur", DEFAULT_MOUNT = "Ixion", DEFAULT_MINION = "Wind-up Thancred";
    public static final int DEFAULT_CHARACTER_LEVEL = 50, DEFAULT_HIT_POINTS = 8750, DEFAULT_DEFENSE = 45;
    public static final Weapon DEFAULT_WEAPON = new Weapon("Lionheart", "Gunblade", "Physical", 114, 80);

    //FULL CONSTRUCTOR
    public Gunbreaker(String name, String race, String mount, String minion, int characterLevel, int hitPoints, int defense, Weapon weapon) {
        super(name, race, mount, minion, characterLevel, hitPoints, defense, weapon);
    }

    //DEFAULT CONSTRUCTOR
    public Gunbreaker() {
        this(Gunbreaker.DEFAULT_NAME, Gunbreaker.DEFAULT_RACE, Gunbreaker.DEFAULT_MOUNT, Gunbreaker.DEFAULT_MINION, Gunbreaker.DEFAULT_CHARACTER_LEVEL, Gunbreaker.DEFAULT_HIT_POINTS, Gunbreaker.DEFAULT_DEFENSE, Gunbreaker.DEFAULT_WEAPON);
    }

    public Gunbreaker(Gunbreaker original) {
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
    public boolean offensiveAbility(WarriorOfLight other) { //ability called Blasting Zone
        //int abilityDamage = (weapon.getAutoAttackDamage() * (other.getCharacterLevel()/2)) - (other.getDefense()/5);
        int abilityDamage = 500;
        int recoilDamage = this.getHitPoints() - abilityDamage/5;
        int updatedHitPoints = other.getHitPoints();
        int diceRoll = (int)(Math.random() * 20);

        if(abilityDamage > updatedHitPoints) {
            abilityDamage = updatedHitPoints;
        }
        //will integrate job specific interactions that boost/detract from roll; will complete basic functionality first
        if(diceRoll > 10) {
            updatedHitPoints -= abilityDamage;
            other.setHitPoints(updatedHitPoints);
            this.setHitPoints(recoilDamage);
            System.out.println("Warrior Of Light successfully casts Blasting Zone, took 1/3 of the damage dealt as recoil and deals " + abilityDamage + " damage");
            System.out.println(abilityDamage);
            return true;
        } else {
            System.out.println("Warrior Of Light failed to cast Blasting Zone");
            return false;
        }
    }

    /*
     * defensiveAbility unique to each job, based on the damage type of the weapon with a modifier for each job
     *
     * @Param other WarriorOfLight uses defensive ability
     */
    @Override
    public void defensiveAbility(WarriorOfLight other) { //ability called Heart of Stone
        int heartOfStone = this.getDefense() + (weapon.getRequiredLevel() / 4);
        this.setDefense(heartOfStone);
        System.out.println(this.getName() + " casted Heart of Stone, " + heartOfStone + " Defense");
    }

    // emote
    /*
     * unique dance emote for each character
     *
     * @Param other WarriorOfLight emotes
     */
    @Override
    public void emote(WarriorOfLight other) {
        System.out.println(this.getName() + " performs the Senor Sabotender!");
    }
}
