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
        cityCoins.setCities(ta_input.getText());
        String answer="";
        for (String s:cityCoins.getOutput()) {
            answer+=s+"\n";
        }
        ta_output.setText(answer);
    }

}
