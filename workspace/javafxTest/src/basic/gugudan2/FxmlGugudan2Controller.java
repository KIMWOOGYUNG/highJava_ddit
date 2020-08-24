package basic.gugudan2;

import java.net.URL;
import java.util.ResourceBundle;

import basic.util.AlertUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.util.Callback;

public class FxmlGugudan2Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Integer> comboBox;

    @FXML
    private Button btn;

    @FXML
    private TextArea txtArea;

    @FXML
    void btnClick(ActionEvent event) {
    	Integer dan = comboBox.getValue();
    	if(dan == null) {
			/*
			 * Alert alert = new Alert(AlertType.ERROR); alert.setTitle("오류");
			 * alert.setHeaderText("작업 오류"); alert.setContentText("출력할 단을 선택하세요.");
			 * alert.showAndWait();
			 */
    		AlertUtil.errorMsg("작업오류", "출력할 단을 선택하세요");
    		return;
    	}
    	
    	for(int i = 1; i <= 9; i++) {
    			txtArea.appendText(dan + "*" + i + "=" + dan*i + "\n");
    	}
    }

    @FXML
    void initialize() {
    	ObservableList<Integer> data = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9);
    	comboBox.setItems(data);
    	
    	comboBox.setCellFactory(new Callback<ListView<Integer>, ListCell<Integer>>() {

			@Override
			public ListCell<Integer> call(ListView<Integer> param) {
				return new ListCell<Integer>(){
					@Override
					protected void updateItem(Integer item, boolean empty) {
						super.updateItem(item, empty);
						if(empty) {
							setText(null);
						}else {
							setText(item + "단");
						}
					}
				};
			}
		});
    	
    	comboBox.setButtonCell(new ListCell<Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
               // TODO Auto-generated method stub
               super.updateItem(item, empty);
               if(empty) {
                setText(null);
             }else {
                setText(item + "단");
             }
            }
         });
    }
    
}
