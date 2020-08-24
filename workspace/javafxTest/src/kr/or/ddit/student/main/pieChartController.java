package kr.or.ddit.student.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import kr.or.ddit.student.vo.StudentVO;

public class pieChartController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PieChart pieChart;

    @FXML
    private Button btnClose;

    @FXML
    void close(ActionEvent event) {
    	Stage stage = (Stage) btnClose.getScene().getWindow();
    	stage.close();
    }

    @FXML
    void initialize() {

  	  
        StudentVO clickedList = StudentController.clickedList;

        ObservableList<PieChart.Data> pieList = 
    			FXCollections.observableArrayList(
    				new PieChart.Data("국어", clickedList.getStd_kor()),
    				new PieChart.Data("영어", clickedList.getStd_eng()),
    				new PieChart.Data("수학", clickedList.getStd_mat())
    		);
        
        pieChart.setData(pieList);
         
        pieChart.setTitle("파이그래프");

    }
}
