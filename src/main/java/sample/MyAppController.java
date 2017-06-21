package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class MyAppController {
    @FXML
    public void initialize() {
    }

    @FXML
    TextArea ta_input, ta_output;

    public void on_click(){
        CityCoins cityCoins = new CityCoins();
        StringBuilder answer= new StringBuilder();
        for (String s: cityCoins.setCities(ta_input.getText()))
            answer.append(s).append("\n");

        ta_output.setText(answer.toString());
    }

}
