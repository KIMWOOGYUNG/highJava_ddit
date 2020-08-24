package kr.or.ddit.student.main;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import kr.or.ddit.student.service.StudentServiceImpl;
import kr.or.ddit.student.vo.StudentVO;

public class StudentController {
    static StudentVO clickedList;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<StudentVO> tableView;

    @FXML
    private TableColumn<StudentVO, String> name;

    @FXML
    private TableColumn<StudentVO, Integer> kor;

    @FXML
    private TableColumn<StudentVO, Integer> mat;

    @FXML
    private TableColumn<StudentVO, Integer> eng;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBar;

    @FXML
    void add(ActionEvent event) {
    	try {
			Stage dialog = new Stage();
			dialog.initModality(Modality.WINDOW_MODAL);
			Parent childRoot = FXMLLoader.load(Student.class.getResource("../fxml/addStudent.fxml"));
			
			Scene childScene = new Scene(childRoot);
			dialog.setScene(childScene);
			dialog.setTitle("추가");
			dialog.show();
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void barChart(ActionEvent event) {
    	try {
			Stage dialog = new Stage();
			dialog.initModality(Modality.WINDOW_MODAL);
			Parent childRoot = FXMLLoader.load(Student.class.getResource("../fxml/barChart.fxml"));
			
			Scene childScene = new Scene(childRoot);
			dialog.setScene(childScene);
			dialog.setTitle("막대 그래프");
			dialog.show();
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
   
  
    @FXML
    void tableClicked(MouseEvent event) {
    	clickedList = tableView.getSelectionModel().getSelectedItem();
    	
    	
    	try {
			Stage dialog = new Stage();
			dialog.initModality(Modality.WINDOW_MODAL);
			Parent childRoot = FXMLLoader.load(Student.class.getResource("../fxml/pieChartfxml.fxml"));
			
			
			Scene childScene = new Scene(childRoot);
			
			dialog.setScene(childScene);
			dialog.setTitle("파이그래프");
			dialog.show();
			
			
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    List<StudentVO> studentList = StudentServiceImpl.getInstance().getAllStudent();
    ObservableList<StudentVO> data = FXCollections.observableArrayList(studentList);
    
    
    @FXML
    void initialize() {
       tableView.setItems(data);
       
      
       
       name.setCellValueFactory(new PropertyValueFactory<StudentVO, String>("std_name"));
       kor.setCellValueFactory(new PropertyValueFactory<StudentVO, Integer>("std_kor"));
       eng.setCellValueFactory(new PropertyValueFactory<StudentVO, Integer>("std_eng"));
       mat.setCellValueFactory(new PropertyValueFactory<StudentVO, Integer>("std_mat"));
       
    }
}
