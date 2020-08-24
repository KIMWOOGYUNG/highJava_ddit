package kr.or.ddit.student.main;

import java.net.URL;
import java.util.ResourceBundle;

import basic.util.AlertUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kr.or.ddit.student.service.IStudentService;
import kr.or.ddit.student.service.StudentServiceImpl;
import kr.or.ddit.student.vo.StudentVO;

public class AddStudentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField taName;

    @FXML
    private TextField taKor;

    @FXML
    private TextField taMat;

    @FXML
    private TextField taEng;

    @FXML
    void cancel(ActionEvent event) {
    	Stage stage = (Stage) btnCancel.getScene().getWindow();
    	stage.close();
    }
    
    @FXML
    void save(ActionEvent event) {
    	String name = taName.getText();
    	int kor = Integer.parseInt(taKor.getText());
    	int eng = Integer.parseInt(taEng.getText());
    	int mat = Integer.parseInt(taMat.getText());
		
    	StudentVO stdVo = new StudentVO(name, kor, eng, mat);
    	
    	IStudentService service = StudentServiceImpl.getInstance();
    	service.addStudent(stdVo);
    	
    	Stage stage = (Stage) btnCancel.getScene().getWindow();
    	stage.close();

    }

    @FXML
    void initialize() {

    }
}
