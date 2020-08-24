package basic.controls;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FxmlGugudanControlloer {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tfMsg;

    @FXML
    private Button btn;

    @FXML
    private TextArea txtArea;

    @FXML
    void btnClick(ActionEvent event) {
    	String str = tfMsg.getText();
    	
    	if(str.isEmpty()) {
    		txtArea.setText("출력할 단을 입력하세요");
    		return;
    	}
    	if(!Pattern.matches("[1-9][0-9]*", str)){
    		txtArea.setText("출력할 단을 입력해야합니다.");
    	}
    	
    	int num = Integer.parseInt(str);
    	
    	txtArea.setText(num + "단\n");
    	for(int i = 1; i <= 9; i++) {
    		txtArea.appendText(num + " * " + i + " = " + (num * i) + "\n");
    	}   	
    }

    @FXML
    void initialize() {
        assert tfMsg != null : "fx:id=\"tfMsg\" was not injected: check your FXML file 'fxmlPrac01.fxml'.";
        assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'fxmlPrac01.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'fxmlPrac01.fxml'.";

    }
}
