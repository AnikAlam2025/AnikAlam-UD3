package cs112.anikalamud3;

// WarriorOfLight Class is an abstract class for the user's character creation process  where the user will create a name, select a valid race from an array, create their weapon, and optional second weapon > It will be extended by 6 concrete "Job" classes which are several examples of a massive multiplayer online role-playing game
// Requires a weapon object, second weapon is optional

public abstract class WarriorOfLight{

    //CONSTANT VARIABLES
    public static final String DEFAULT_NAME = "Ardbert", DEFAULT_RACE = "Hyur", DEFAULT_MOUNT = "Chocobo", DEFAULT_MINION = "Windup Airship";
    public static final int DEFAULT_CHARACTER_LEVEL = 50, DEFAULT_HIT_POINTS = 10000, DEFAULT_DEFENSE = 75;
    public static final Weapon DEFAULT_WEAPON = new Weapon("Bravura Atma", "Axe", "Physical", 53, 50);

    public static final String[] VALID_RACE = {"Hyur", "Miqo'te", "Elezen", "Roegadyn", "Lalafell", "Viera"};

    //INSTANT VARAIBLES
    private String name, race, mount, minion;
    private int characterLevel, hitPoints, defense;
    public Weapon weapon;

    //FULL CONSTRUCTOR
    public WarriorOfLight(String name, String race, String mount, String minion, int characterLevel, int hitPoints, int defense, Weapon weapon){
        if (!this.setAll(name, race, mount, minion, characterLevel, hitPoints, defense, weapon)) {
            System.out.println("ERROR: Invalid data given to Warrior of Light constructor");
            System.exit(0);
        }
    }

    //DEFAULT CONSTRUCTOR
    public WarriorOfLight(){
        this(DEFAULT_NAME, DEFAULT_RACE, DEFAULT_MOUNT, DEFAULT_MINION, DEFAULT_CHARACTER_LEVEL, DEFAULT_HIT_POINTS, DEFAULT_DEFENSE, DEFAULT_WEAPON);
    }

    // COPY CONSTRUCTOR
    public WarriorOfLight(WarriorOfLight original) {
        if (original == null) {
            System.out.println("ERROR: invalid data given to copy Warrior of Light constructor");
            System.exit(0);
        } else {
            this.setAll(original.name, original.race, original.mount, original.minion,  original.characterLevel, original.hitPoints, original.defense, original.weapon);
        }
    }

    // SETTERS
    /*
     * Sets name instance variable (checks if name is greater than zero and not
     * null)
     *
     * @param String name: name of WarriorOfLight
     *
     * @return true if set, false if parameter is not greater than zero or is null
     */
    public boolean setName(String name) {
        if (name != null && name.length() >= 0) {
            this.name = name;
            return true;
        } else {
            return false;
        }
    }

    /*
     * Sets race instance variable (checks if race is greater than zero and not
     * null)
     *
     * @param String race: race of WarriorOfLight
     *
     * @return true if set, false if parameter is not greater than zero or is null
     */
    public boolean setRace(String race) {
        if (WarriorOfLight.isInArray(VALID_RACE, race)) {
            this.race = race;
            return true;
        } else {
            System.out.println("Invalid race chosen. Here is a list of valid races: \nHyur, Miqo'te, Elezen, Roegadyn, Lalafell, and Viera");
            return false;
        }
    }

    /*
     * Sets mount instance variable (checks if mount is greater than zero and not
     * null)
     *
     * @param String mount: mount of WarriorOfLight
     *
     * @return true if set, false if parameter is not greater than zero or is null
     */
    public boolean setMount(String mount) {
        if (mount != null && mount.length() >= 0) {
            this.mount = mount;
            return true;
        } else {
            return false;
        }
    }

    /*
     * Sets minion instance variable (checks if minion is greater than zero and not
     * null)
     *
     * @param String race: race of WarriorOfLight
     *
     * @return true if set, false if parameter is not greater than zero or is null
     */
    public boolean setMinion(String minion) {
        if (minion != null && minion.length() >= 0) {
            this.minion = minion;
            return true;
        } else {
            return false;
        }
    }

    /*
     * Sets characterLevel instance variable (checks if characterLevel is greater than zero)
     *
     * @param int characterLevel: characterLevel of WarriorOfLight
     *
     * @return true if set, false if parameter is not greater than zero or is null
     */
    public boolean setCharacterLevel(int characterLevel) {
        if (characterLevel > 0 && characterLevel <= 80) {
            this.characterLevel = characterLevel;
            return true;
        } else {
            return false;
        }
    }

    /*
     * Sets hitPoints instance variable (checks if hitPoints is greater than zero)
     *
     * @param int hitPoints: hitPoints of WarriorOfLight
     *
     * @return true if set, false if parameter is not greater than zero or is null
     */
    public boolean setHitPoints(int hitPoints) {
        if (hitPoints >= 0 && hitPoints <= 15000) {
            this.hitPoints = hitPoints;
            return true;
        } else {
            return false;
        }
    }

    /*
     * Sets defense instance variable (checks if defense is greater than zero)
     *
     * @param int defense: defense of WarriorOfLight
     *
     * @return true if set, false if parameter is not greater than zero or is null
     */
    public boolean setDefense(int defense) {
        if (defense > 0 && defense <= 75) {
            this.defense = defense;
            return true;
        } else {
            return false;
        }
    }

    /*
     * instanciates weapon(checks if characterLevel is not null)
     *
     * @param Weapon weapon: weapon of WarriorOfLight
     *
     * @return true if set, false if parameter is null
     */
    public boolean setWeapon(Weapon weapon) {
        if (weapon != null) {
            this.weapon = new Weapon(weapon);
            return true;
        } else {
            System.out.println("Invalid weapon chosen. Here is a list of valid races: \nRapier, Polearm, Scepter, Book, Star Globe, Gunblade, Sword, Axe");
            return false;
        }
    }


    public boolean setAll(String name, String race, String mount, String minion, int characterLevel, int hitPoints, int defense, Weapon weapon) {
        return this.setName(name) && this.setRace(race) && this.setMount(mount) && this.setMinion(minion) && this.setCharacterLevel(characterLevel) && this.setHitPoints(hitPoints) && this.setDefense(defense) &&  this.setWeapon(weapon);
    }

    // GETTERS
    public String getName() {
        return this.name;
    }

    public String getRace() {
        return this.race;
    }

    public String getMount() {
        return this.mount;
    }

    public String getMinion() {
        return this.minion;
    }

    public int getCharacterLevel() {
        return this.characterLevel;
    }

    public int getHitPoints() {
        return this.hitPoints;
    }

    public int getDefense() {
        return this.defense;
    }

    public Weapon getWeapon() {
        return new Weapon(this.weapon);
    }


    // TOSTRING
    @Override
    public String toString() {

        String equippedWeapon = "\n" + this.weapon + "\n";

        return String.format("Warrior Of Light: \nName = %s \nRace = %s \nMount = %s \nMinion = %s \nCharacter Level = %d \nHit Points = %d \nDefense = %d \n%s %n\t", this.name, this.race, this.mount, this.minion, this.characterLevel, this.hitPoints, this.defense, equippedWeapon);
    }


    // OTHER METHODS
    /*
     * Method created to check if a certain value is within an array; specifically if the race of the Warrior Of Light is one of the valid options within the VALID_RACE array
     */
    private static boolean isInArray(String [] values, String value) {
        if(values == null || value == null) {
            return false;
        }

        int location = 0;
        boolean isPresent = false;

        while(!isPresent && location < values.length) {
            isPresent = values[location].equalsIgnoreCase(value);
            location++;
        }

        return isPresent;
    }

    public boolean equals(Object other) {
        if(other == null || !(other instanceof WarriorOfLight)) {
            return false;
        }
        WarriorOfLight otherWarriorOfLight = (WarriorOfLight)other;

        return this.name.equals(otherWarriorOfLight.name) && this.race.equals(otherWarriorOfLight.race) && this.mount.equals(otherWarriorOfLight.mount) && this.minion.equals(otherWarriorOfLight.minion) && this.characterLevel == otherWarriorOfLight.characterLevel && this.hitPoints == otherWarriorOfLight.hitPoints && this.defense == otherWarriorOfLight.defense && this.weapon.equals(otherWarriorOfLight.weapon);
    }

    public void tooLowLevel(WarriorOfLight newWOL, Weapon newWeapon) throws TooLowLevelException {
        if(newWeapon.getRequiredLevel() > newWOL.getCharacterLevel()) {
            throw new TooLowLevelException();
        }
    }


    public String toAscii() {
        final String BAR ="___________________________________________", DIVIDER = "|" + BAR + "|";
        final int BAR_LENGTH = BAR.length();

        String identity = this.name + " (" + this.getRace() + ")";
        String hp = "HP: " + this.hitPoints, level = "Level: " + this.characterLevel, defense = "Defense: " + this.defense;
        int identityCenterWidth = (identity.length() + BAR_LENGTH) / 2;
        int specWidth = BAR.length() / 4;

        String ascii = BAR + "\n";
        ascii += String.format("|%" + identityCenterWidth + "s%" + (BAR_LENGTH - identityCenterWidth) + "s|%n", identity, "");
        ascii += DIVIDER + "\n";

        ascii += String.format("|  %-" +(specWidth - 2) + "s", hp);
        ascii += String.format("    | %-" +(specWidth - 2) + "s", level);
        ascii += String.format("     | %-" +(specWidth - 2) + "s", defense);

        //ascii += BAR;

        return ascii;
    }


    // ABSTRACT METHODS
    public abstract boolean autoAttack(WarriorOfLight other);
    public abstract boolean offensiveAbility(WarriorOfLight other);
    public abstract void defensiveAbility(WarriorOfLight other);
    public abstract void emote(WarriorOfLight other);

}
