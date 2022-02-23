package cs112.anikalamud3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class characterCreationController {

    @FXML
    private Button finishCharacterButton;

    @FXML
    private TextField characterNameTextField, weaponNameTextField;

    @FXML
    private Slider characterLevelSlider, hitPointsSlider, defenseSlider, baseDamageSlider, weaponLevelSlider;

    @FXML
    ChoiceBox<String> raceChoiceBox = new ChoiceBox<String>(), mountChoiceBox = new ChoiceBox<String>(), minionChoiceBox = new ChoiceBox<String>(),
            weaponTypeChoiceBox = new ChoiceBox<String>(), weaponDamageTypeChoiceBox = new ChoiceBox<String>(),
            jobClassChoiceBox = new ChoiceBox<String>();

    public void initialize() {
        jobClassChoiceBox.getItems().addAll("Astrologian", "Black Mage", "Dragoon", "Gunbreaker", "Red Mage", "Scholar");
        jobClassChoiceBox.setValue("Astrologian");

        raceChoiceBox.getItems().addAll("Hyur", "Miqo'te", "Elezen", "Roegadyn", "Lalafell", "Viera");
        raceChoiceBox.setValue("Hyur");

        mountChoiceBox.getItems().addAll("Chocobo", "Chair", "Goobbue", "The Regalia", "Carbuncle");
        mountChoiceBox.setValue("Chocobo");

        minionChoiceBox.getItems().addAll("Cactuar Cutting", "Fat Cat", "Wind-Up Airship", "Owlet", "Otter");
        minionChoiceBox.setValue("Fat Cat");

        weaponTypeChoiceBox.getItems().addAll("Rapier", "Polearm", "Scepter", "Sceper", "Book", "Star Globe", "Gunblade", "Sword", "Axe");
        weaponTypeChoiceBox.setValue("Book");

        weaponDamageTypeChoiceBox.getItems().addAll("Physical", "Magical");
        weaponDamageTypeChoiceBox.setValue("Physical");

    }

//    private void getChoice(TextField characterNameTextField, TextField weaponNameTextField, Slider characterLevelSlider,
//                           Slider hitPointsSlider, Slider defenseSlider, Slider baseDamageSlider, Slider weaponLevelSlider,
//                           ChoiceBox<String> raceChoiceBox, ChoiceBox<String> mountChoiceBox, ChoiceBox<String> minionChoiceBox,
//                           ChoiceBox<String> weaponTypeChoiceBox, ChoiceBox<String> weaponDamageTypeChoiceBox,
//                           ChoiceBox<String> jobClassChoiceBox) {
//    }

    @FXML
    public void onFinishCharacterButtonClick(ActionEvent event) throws IOException, TooLowLevelException {

        String userJobClass = jobClassChoiceBox.getValue(), userCharacterName = characterNameTextField.getText(),
        userRace = raceChoiceBox.getValue(), userMount = mountChoiceBox.getValue(), userMinion = minionChoiceBox.getValue(),
        userWeaponName = weaponNameTextField.getText(), userWeaponType = weaponTypeChoiceBox.getValue(),
                userWeaponDamageType = weaponDamageTypeChoiceBox.getValue();

        int userCharacterLevel = (int) characterLevelSlider.getValue(), userHitPoints = (int) hitPointsSlider.getValue(),
                userDefense = (int) defenseSlider.getValue(), userBaseDamage = (int) baseDamageSlider.getValue(), userWeaponLevel
                 = (int) weaponLevelSlider.getValue();

        Weapon userWeapon = new Weapon(userWeaponName, userWeaponType, userWeaponDamageType, userBaseDamage, userWeaponLevel);

        if(userJobClass == "Astrologian") {
            WarriorOfLight user = new Astrologian(userCharacterName, userRace, userMount, userMinion, userCharacterLevel, userHitPoints,
                    userDefense, userWeapon);
            user.tooLowLevel(user, user.getWeapon());

            FXMLLoader characterLoader = new FXMLLoader();
            characterLoader.setLocation(getClass().getResource("finishedCharacter-view.fxml"));
            Parent finishedCharacterScene = characterLoader.load();

            finishedCharacterController finishedCharacterController = characterLoader.getController();
            finishedCharacterController.displayUserCharacter(user);

            Stage finishedCharacterStage = new Stage();
            finishedCharacterStage.initModality(Modality.APPLICATION_MODAL);
            finishedCharacterStage.setScene(new Scene(finishedCharacterScene));
            finishedCharacterStage.setResizable(false);
            finishedCharacterStage.show();

        } else if(userJobClass == "Black Mage") {
            WarriorOfLight user = new BlackMage(userCharacterName, userRace, userMount, userMinion, userCharacterLevel, userHitPoints,
                    userDefense, userWeapon);
            user.tooLowLevel(user, user.getWeapon());

            FXMLLoader characterLoader = new FXMLLoader();
            characterLoader.setLocation(getClass().getResource("finishedCharacter-view.fxml"));
            Parent finishedCharacterScene = characterLoader.load();

            finishedCharacterController finishedCharacterController = characterLoader.getController();
            finishedCharacterController.displayUserCharacter(user);

            Stage finishedCharacterStage = new Stage();
            finishedCharacterStage.initModality(Modality.APPLICATION_MODAL);
            finishedCharacterStage.setScene(new Scene(finishedCharacterScene));
            finishedCharacterStage.setResizable(false);
            finishedCharacterStage.show();

        } else if(userJobClass == "Dragoon") {
            WarriorOfLight user = new Dragoon(userCharacterName, userRace, userMount, userMinion, userCharacterLevel, userHitPoints,
                    userDefense, userWeapon);
            user.tooLowLevel(user, user.getWeapon());

            FXMLLoader characterLoader = new FXMLLoader();
            characterLoader.setLocation(getClass().getResource("finishedCharacter-view.fxml"));
            Parent finishedCharacterScene = characterLoader.load();

            finishedCharacterController finishedCharacterController = characterLoader.getController();
            finishedCharacterController.displayUserCharacter(user);

            Stage finishedCharacterStage = new Stage();
            finishedCharacterStage.initModality(Modality.APPLICATION_MODAL);
            finishedCharacterStage.setScene(new Scene(finishedCharacterScene));
            finishedCharacterStage.setResizable(false);
            finishedCharacterStage.show();

        } else if(userJobClass == "Gunbreaker") {
            WarriorOfLight user = new Gunbreaker(userCharacterName, userRace, userMount, userMinion, userCharacterLevel, userHitPoints,
                    userDefense, userWeapon);
            user.tooLowLevel(user, user.getWeapon());

            FXMLLoader characterLoader = new FXMLLoader();
            characterLoader.setLocation(getClass().getResource("finishedCharacter-view.fxml"));
            Parent finishedCharacterScene = characterLoader.load();

            finishedCharacterController finishedCharacterController = characterLoader.getController();
            finishedCharacterController.displayUserCharacter(user);

            Stage finishedCharacterStage = new Stage();
            finishedCharacterStage.initModality(Modality.APPLICATION_MODAL);
            finishedCharacterStage.setScene(new Scene(finishedCharacterScene));
            finishedCharacterStage.setResizable(false);
            finishedCharacterStage.show();

        } else if(userJobClass == "Red Mage") {
            WarriorOfLight user = new RedMage(userCharacterName, userRace, userMount, userMinion, userCharacterLevel, userHitPoints,
                    userDefense, userWeapon);
            user.tooLowLevel(user, user.getWeapon());

            FXMLLoader characterLoader = new FXMLLoader();
            characterLoader.setLocation(getClass().getResource("finishedCharacter-view.fxml"));
            Parent finishedCharacterScene = characterLoader.load();

            finishedCharacterController finishedCharacterController = characterLoader.getController();
            finishedCharacterController.displayUserCharacter(user);

            Stage finishedCharacterStage = new Stage();
            finishedCharacterStage.initModality(Modality.APPLICATION_MODAL);
            finishedCharacterStage.setScene(new Scene(finishedCharacterScene));
            finishedCharacterStage.setResizable(false);
            finishedCharacterStage.show();

        } else if(userJobClass == "Scholar") {
            WarriorOfLight user = new Scholar(userCharacterName, userRace, userMount, userMinion, userCharacterLevel, userHitPoints,
                    userDefense, userWeapon);
            user.tooLowLevel(user, user.getWeapon());

            FXMLLoader characterLoader = new FXMLLoader();
            characterLoader.setLocation(getClass().getResource("finishedCharacter-view.fxml"));
            Parent finishedCharacterScene = characterLoader.load();

            finishedCharacterController finishedCharacterController = characterLoader.getController();
            finishedCharacterController.displayUserCharacter(user);

            Stage finishedCharacterStage = new Stage();
            finishedCharacterStage.initModality(Modality.APPLICATION_MODAL);
            finishedCharacterStage.setScene(new Scene(finishedCharacterScene));
            finishedCharacterStage.setResizable(false);
            finishedCharacterStage.show();
        }
    }
}
