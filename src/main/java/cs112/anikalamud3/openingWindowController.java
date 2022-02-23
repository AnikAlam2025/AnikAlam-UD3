package cs112.anikalamud3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class openingWindowController {

    @FXML
    private Button createCharacterButton, scionDisplayButton, commenceBattleButton, ffxivPageButton, exitProgramButton;

    @FXML
    WarriorOfLight user = new Gunbreaker("Ardbert", "Hyur", "Golden Chocobo", "Fat Chocobo", 60, 9500, 40,new Weapon("Bravura Atma", "Axe", "Physical", 75, 55));

    @FXML
    public void onCreateCharacterButtonClick(ActionEvent createCharacterEvent) throws IOException {
        Parent createCharacterView = FXMLLoader.load(getClass().getResource("characterCreation-view.fxml"));
        Scene createCharacterScene = new Scene(createCharacterView);

        Stage window = (Stage)((Node)createCharacterEvent.getSource()).getScene().getWindow();

        window.setScene(createCharacterScene);
        window.show();
    }

    @FXML
    public void onScionDisplayButtonClick(ActionEvent displayScionsEvent) throws IOException {
        Parent displayScionsView = FXMLLoader.load(getClass().getResource("displayScions-view.fxml"));
        Scene displayScionsScene = new Scene(displayScionsView);

        Stage window = (Stage)((Node)displayScionsEvent.getSource()).getScene().getWindow();

        window.setScene(displayScionsScene);
        window.show();
    }

    @FXML
    public void onCommenceBattleButtonClick(ActionEvent openBattleEvent) throws IOException{
        Parent warriorOfLightBattleView = FXMLLoader.load(getClass().getResource("warriorOfLightBattle-view.fxml"));
        Scene warriorOfLightBattleScene = new Scene(warriorOfLightBattleView);

        Stage window = (Stage)((Node)openBattleEvent.getSource()).getScene().getWindow();

        window.setScene(warriorOfLightBattleScene);
        window.show();
    }

    @FXML
    public void onffxivPageButtonClick(ActionEvent openInfoPageEvent) throws IOException {
        Parent ffxivInfoView = FXMLLoader.load(getClass().getResource("ffxivInfo-view.fxml"));
        Scene ffxivInfoScene = new Scene(ffxivInfoView);

        Stage window = (Stage)((Node)openInfoPageEvent.getSource()).getScene().getWindow();

        window.setScene(ffxivInfoScene);
        window.show();
    }

    @FXML
    public void onExitProgramButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) exitProgramButton.getScene().getWindow();
        stage.close();
    }
}
