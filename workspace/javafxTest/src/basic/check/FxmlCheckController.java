package basic.check;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class FxmlCheckController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField name;

    @FXML
    private RadioButton male;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton female;

    @FXML
    private CheckBox travel;

    @FXML
    private CheckBox hiking;

    @FXML
    private CheckBox reading;

    @FXML
    private CheckBox baduk;

    @FXML
    private CheckBox jangi;

    @FXML
    private CheckBox game;

    @FXML
    private CheckBox tennis;

    @FXML
    private CheckBox badminton;

    @FXML
    private Button btn;

    @FXML
    private TextArea txtArea;

    private CheckBox[] hobbies; 
    @FXML
    void click(ActionEvent event) {
    	String nameVal = name.getText();
    	male.setUserData("남자");
    	female.setUserData("여자");
    	String genderVal = (String) gender.getSelectedToggle().getUserData();
    	
    	String hobbyVal = "";
    	
    	int lastnum = 0; 
    	
    	for(int i = 0; i < hobbies.length; i++) {
    		if(hobbies[i].isSelected() == true) {
    			lastnum = i;
    		}
    	}
    	
    	for(int i = 0; i < hobbies.length; i++) {
    		if(hobbies[i].isSelected() == true) {
    			if(i == lastnum){
    				hobbyVal += hobbies[i].getText();
    			}
    			else {
    				hobbyVal += hobbies[i].getText() + ",";
    			}
    		}
    	}
    	
    	if(hobbyVal == ""){
    		txtArea.appendText(nameVal + "씨!\n당신은 " + genderVal + "이고,\n취미는 없군요.");
    		
    	}else{
    		txtArea.appendText(nameVal + "씨!\n당신은 " + genderVal + "이고,\n취미는 " + hobbyVal + "이군요.");
    	}
    }

    @FXML
    void initialize() { //초기화 하는 부분
    	hobbies = new CheckBox[]{travel, hiking, reading, baduk, jangi, game, tennis, badminton};
    	
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'fxmlCheck.fxml'.";
        assert male != null : "fx:id=\"male\" was not injected: check your FXML file 'fxmlCheck.fxml'.";
        assert gender != null : "fx:id=\"gender\" was not injected: check your FXML file 'fxmlCheck.fxml'.";
        assert female != null : "fx:id=\"female\" was not injected: check your FXML file 'fxmlCheck.fxml'.";
        assert travel != null : "fx:id=\"travel\" was not injected: check your FXML file 'fxmlCheck.fxml'.";
        assert hiking != null : "fx:id=\"hiking\" was not injected: check your FXML file 'fxmlCheck.fxml'.";
        assert reading != null : "fx:id=\"reading\" was not injected: check your FXML file 'fxmlCheck.fxml'.";
        assert baduk != null : "fx:id=\"baduk\" was not injected: check your FXML file 'fxmlCheck.fxml'.";
        assert jangi != null : "fx:id=\"jangi\" was not injected: check your FXML file 'fxmlCheck.fxml'.";
        assert game != null : "fx:id=\"game\" was not injected: check your FXML file 'fxmlCheck.fxml'.";
        assert tennis != null : "fx:id=\"tennis\" was not injected: check your FXML file 'fxmlCheck.fxml'.";
        assert badminton != null : "fx:id=\"badminton\" was not injected: check your FXML file 'fxmlCheck.fxml'.";
        assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'fxmlCheck.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'fxmlCheck.fxml'.";

    }
}
