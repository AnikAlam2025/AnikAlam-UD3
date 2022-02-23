package cs112.anikalamud3;

public class TooLowLevelException extends Exception {
    Weapon unusableWeapon;

    public TooLowLevelException() {
        super("Warrior of Light is too low level to use this piece of equipment");
    }

    //overloaded constructor for custom message
    public TooLowLevelException(String message, Weapon unusableWeapon) {
        super(message + " Unusable Weapon = " + unusableWeapon);
        this.unusableWeapon = unusableWeapon;
    }

    public Weapon getUnusableWeapon () {
        return this.unusableWeapon;
    }
}