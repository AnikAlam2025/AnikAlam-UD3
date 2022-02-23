package cs112.anikalamud3;

//The Weapon class where a weapon and its associated stats will be made
public class Weapon {

    //CONSTANT VARIABLES
    public static final String[] WEAPON_TYPE = {"Rapier", "Polearm", "Scepter", "Book", "Star Globe", "Gunblade", "Sword", "Axe"};
    public static final String DEFAULT_NAME = "Heartless", DEFAULT_WEAPON_TYPE = "Book", DEFAULT_DAMAGE_TYPE = "Magic" ;
    public static final int DEFAULT_AUTO_ATTACK_DAMAGE = 3, DEFAULT_REQUIRED_LEVEL = 5;

    //INSTANT VARAIBLES
    private String name, weaponType, damageType;
    private int autoAttackDamage, requiredLevel;

    //FULL CONSTRUCTOR
    /*
     * Full constructor sets Weapon object to parameter values if valid, if not then displays error message and exits program
     * @param name, weaponType, damageType, autoAttackDamage, requiredLevel
     */
    public Weapon(String name, String weaponType, String damageType, int autoAttackDamage, int requiredLevel) {
        if(!this.setAll(name, weaponType, damageType, autoAttackDamage, requiredLevel)) {
            System.out.println("ERROR: Invalid data given to the weapon constructor.");
            System.exit(0);
        }
    }

    //DEFAULT CONSTRUCTOR
    public Weapon() {
        this(DEFAULT_NAME, DEFAULT_WEAPON_TYPE, DEFAULT_DAMAGE_TYPE, DEFAULT_AUTO_ATTACK_DAMAGE, DEFAULT_REQUIRED_LEVEL);
    }

    // COPY CONSTRUCTOR
    /*
     * Copy constructor creates a deep copy of the original weapon object if not null, if null then displays error and exits program
     */
    public Weapon(Weapon original) {
        if(original != null) {
            this.setAll(original.name, original.weaponType, original.damageType, original.autoAttackDamage, original.requiredLevel);
        } else {
            System.out.println("ERROR: Invalid data given to copy constructor.");
            System.exit(0);
        }
    }

    // SETTERS
    /*
     * Sets name instance variable (checks if name is greater than zero and not
     * null)
     *
     * @param String name: name of weapon
     *
     * @return true if set, false if parameter is not greater than zero or is null
     */
    public boolean setName(String name) {
        if(name != null && name.length() > 0) {
            this.name = name;
            return true;
        } else {
            return false;
        }
    }

    /*
     * Sets type instance variable (checks if type is greater than zero and not
     * null; also checks if weapon type is a valid weapon type from Weapon_Type Array)
     *
     * @param String type: type of weapon
     *
     * @return true if set, false if parameter is not greater than zero or is null
     */
    public boolean setWeaponType(String weaponType) {
        if(this.isValidWeaponType(weaponType)) {
            this.weaponType = this.toTitleCaseWord(weaponType);
            return true;
        } else {
            System.out.println("Invalid weapon chosen. Here is a list of valid races: \nRapier, Polearm, Scepter, Book, Star Globe, Gunblade, Sword, Axe");
            return false;
        }
    }

    /*
     * Sets damageType instance variable (checks if damageType is greater than zero and
     * not null)
     *
     * @param String damageType: damageType of weapon
     *
     * @return true if set, false if parameter is not greater than zero or is null
     */
    public boolean setDamageType(String damageType) {
        if(damageType != null && damageType.length() > 0) {
            this.damageType = damageType;
            return true;
        } else {
            return false;
        }
    }

    /*
     * Sets autoAttackDamage instance variable (checks if autoAttackDamage is greater than zero)
     *
     * @param int name: autoAttackDamage of weapon
     *
     * @return true if set, false if parameter is not greater than zero
     */
    public boolean setAutoAttackDamage(int autoAttackDamage) {
        if(autoAttackDamage > 0 && autoAttackDamage <= 140) {
            this.autoAttackDamage = autoAttackDamage;
            return true;
        } else {
            return false;
        }
    }

    /*
     * Sets requiredLevel instance variable (checks if requiredLevel is greater than zero)
     *
     * @param int name: requiredLevel of weapon
     *
     * @return true if set, false if parameter is not greater than zero
     */
    public boolean setRequiredLevel(int requiredLevel) {
        if(requiredLevel > 0 && requiredLevel <= 80) {
            this.requiredLevel = requiredLevel;
            return true;
        } else {
            return false;
        }
    }

    // SETALL
    /*
     * Sets all instance variables (no error checking, except checks for null) Deep
     * copies object to ensure encapsulation
     *
     * @param name, weaponType, damageType, autoAttackDamage, requiredLevel
     *
     * @return true if set, false if parameter is null
     */
    public boolean setAll(String name, String weaponType, String damageType, int autoAttackDamage, int requiredLevel) {
        return this.setName(name) && this.setWeaponType(weaponType) && this.setDamageType(damageType) && this.setAutoAttackDamage(autoAttackDamage) && this.setRequiredLevel(requiredLevel);
    }

    // GETTERS
    public String getName() {
        return this.name;
    }

    public String getWeaponType() {
        return this.weaponType;
    }

    public String getDamageType() {
        return this.damageType;
    }

    public int getAutoAttackDamage() {
        return this.autoAttackDamage;
    }

    public int getRequiredLevel() {
        return this.requiredLevel;
    }

    // TOSTRING
    /*
     * toString method to set all instance variables with error checking
     *
     *  @return true if all arguments are valid, false if not
     */
    @Override
    public String toString() {
        return String.format("Weapon Name: %s \nWeapon Type: %s \nDamage Type: %s \nautoAttackDamage: %d \nMinimum Required Level: %d", this.name, this.weaponType, this.damageType, this.autoAttackDamage, this.requiredLevel);
    }

    // OTHER METHODS
    @Override
    public boolean equals(Object other) {
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        Weapon otherWeapon = (Weapon) other;
        return this.name.equals(otherWeapon.name) && this.weaponType.equals(otherWeapon.weaponType) && this.damageType.equals(otherWeapon.damageType) && this.autoAttackDamage == otherWeapon.autoAttackDamage && this.requiredLevel == otherWeapon.requiredLevel;
    }

    /*
     * Method checks to see if weapon type from user input is one of the valid weapon types in array WEAPON_TYPE[]
     */
    private boolean isValidWeaponType(String weaponType) {
        boolean isValid = false;
        int count = 0;

        while(count < WEAPON_TYPE.length && !isValid) {
            isValid = WEAPON_TYPE[count].equalsIgnoreCase(weaponType);
            count++;
        }
        return isValid;
    }

    private String toTitleCaseWord(String word) {
        char firstLetter = word.toUpperCase().charAt(0);
        String restOfWord = word.toLowerCase().substring(1);
        return firstLetter + restOfWord;
    }
}
