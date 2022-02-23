package cs112.anikalamud3;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Scanner;

public class ffxivInfoController {

    @FXML
    private Label ffxivInfoLabel;

    @FXML
    private Button ffxivButton;

    @FXML
    public void onFfxivButtonClick() {ffxivInfoLabel.setText("Did you know that the critically acclaimed MMORPG Final Fantasy XIV has a free trial, and includes the entirety of A Realm Reborn AND the award-winning Heavensward expansion up to level 60 with no restrictions on playtime? Sign up, and enjoy Eorzea today! https://secure.square-enix.com/account/app/svc/ffxivregister");}

}
