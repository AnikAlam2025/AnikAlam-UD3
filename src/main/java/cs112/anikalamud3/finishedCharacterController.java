package cs112.anikalamud3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class finishedCharacterController {

    private characterCreationController user;

    @FXML
    private Label finishedCharacterLabel;

    public void displayUserCharacter(WarriorOfLight userCharacter) {
        finishedCharacterLabel.setText(String.valueOf(userCharacter));

    }
}
