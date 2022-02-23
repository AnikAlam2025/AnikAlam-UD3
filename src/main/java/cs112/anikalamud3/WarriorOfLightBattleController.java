package cs112.anikalamud3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Scanner;

public class WarriorOfLightBattleController {

    //DECLARE GUI COMPONENTS
    @FXML
    private Label titleLabel, battleMessageLabel, warriorOfLightLabel, opponentLabel;

    @FXML
    private Button autoAttackButton, abilityAttackButton, defendAbilityButton, emoteButton, commenceBattleButton;

    WarriorOfLight user = new Gunbreaker("Ardbert", "Hyur", "Golden Chocobo", "Fat Chocobo", 60, 9500, 40,new Weapon("Bravura Atma", "Axe", "Physical", 75, 55));

    WarriorOfLight ast = new Astrologian(), blm = new BlackMage(), drg = new Dragoon(), gnb = new Gunbreaker(), rdm = new RedMage(), sch = new Scholar();
    WarriorOfLight[] opponents = {ast, blm, drg, gnb, rdm, sch};

    boolean battleDone = false;
    WarriorOfLight winner = null, loser = null, attacker = user, defender = rdm, placeHolder;

    //ArrayList<WarriorOfLight> opponentList = (ArrayList<WarriorOfLight>) Arrays.asList(opponents);

    @FXML
    protected void onCommenceBattleButtonClick() {
        warriorOfLightLabel.setText(String.valueOf(user));
        opponentLabel.setText(String.valueOf(rdm));
    }

    @FXML
    protected void onAutoAttackButtonClick() {
        battleDone = autoAttackChoice(attacker, defender);
        warriorOfLightLabel.setText(String.valueOf(user));
        opponentLabel.setText(String.valueOf(rdm));
        battleMessageLabel.setText(attacker.getName() + " has struck " + defender.getName());

        if (battleDone) {
            winner = attacker;
            loser = defender;

            battleMessageLabel.setText(winner.getName() + " has defeated " + loser.getName());
        }
        placeHolder = attacker;
        attacker = defender;
        defender = placeHolder;

    }

    @FXML
    protected void onAbilityAttackButtonClick() {
        battleDone = offensiveAbilityChoice(attacker, defender);
        warriorOfLightLabel.setText(String.valueOf(user));
        opponentLabel.setText(String.valueOf(rdm));
        battleMessageLabel.setText(attacker.getName() + " has struck " + defender.getName());
        if (battleDone) {
            winner = attacker;
            loser = defender;

            battleMessageLabel.setText(winner.getName() + " has defeated " + loser.getName());
        }
        placeHolder = attacker;
        attacker = defender;
        defender = placeHolder;
    }

    @FXML
    protected void onDefendAbilityButtonClick() {
        defensiveAbilityChoice(attacker);
        warriorOfLightLabel.setText(String.valueOf(user));
        opponentLabel.setText(String.valueOf(rdm));
        battleMessageLabel.setText(attacker.getName() + " used a defensive ability");

        placeHolder = attacker;
        attacker = defender;
        defender = placeHolder;
    }

    @FXML
    protected void onEmoteButtonClick() {
        emoteChoice(attacker);

        battleMessageLabel.setText(attacker.getName() + " performed a dance");

        placeHolder = attacker;
        attacker = defender;
        defender = placeHolder;
    }

    private static boolean autoAttackChoice(WarriorOfLight attacker, WarriorOfLight defender) {
        boolean successfulAttack = attacker.autoAttack(defender);
        if (successfulAttack) {
            System.out.println("Hit successfull! " + defender.getName() + " took damage");
        } else {
            System.out.println("Hit unsuccessfull! " + defender.getName() + " did not take damage");
        }

        return defender.getHitPoints() == 0;
    }

    public static boolean offensiveAbilityChoice(WarriorOfLight attacker, WarriorOfLight defender) {
        boolean successfulAttack = attacker.offensiveAbility(defender);
        if (successfulAttack) {
            System.out.println("Hit successfull! " + defender.getName() + " took damage");
        } else {
            System.out.println("Hit unsuccessfull! " + defender.getName() + " did not take damage");
        }
        return defender.getHitPoints() == 0;
    }

    public static void defensiveAbilityChoice(WarriorOfLight buffUser) {
        buffUser.defensiveAbility(buffUser);
    }

    public static void emoteChoice(WarriorOfLight attacker) {
        attacker.emote(attacker);
    }

}