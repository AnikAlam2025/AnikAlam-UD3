package cs112.anikalamud3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class displayScionsController{


    @FXML
    private Label astrologianLabel, blackMageLabel, dragoonLabel, gunbreakerLabel, redMageLabel, scholarLabel;

    @FXML
    private Button displayScionsButton;

    @FXML
    WarriorOfLight ast = new Astrologian(), blm = new BlackMage(), drg = new Dragoon(), gnb = new Gunbreaker(), rdm = new RedMage(), sch = new Scholar();

    @FXML
    public void onDisplayScionsButtonClick() {
        astrologianLabel.setText(String.valueOf(ast));
        blackMageLabel.setText(String.valueOf(blm));
        dragoonLabel.setText(String.valueOf(drg));
        gunbreakerLabel.setText(String.valueOf(gnb));
        redMageLabel.setText(String.valueOf(rdm));
        scholarLabel.setText(String.valueOf(sch));

    }

}
