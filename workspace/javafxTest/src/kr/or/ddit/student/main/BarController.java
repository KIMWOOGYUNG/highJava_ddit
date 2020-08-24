package kr.or.ddit.student.main;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import kr.or.ddit.student.service.StudentServiceImpl;
import kr.or.ddit.student.vo.StudentVO;

public class BarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClose;

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    void close(ActionEvent event) {
    	Stage stage = (Stage) btnClose.getScene().getWindow();
    	stage.close();
    }

    //StudentVO stdVo = new StudentVO();
    List<StudentVO> studentList = StudentServiceImpl.getInstance().getAllStudent();
    ObservableList<StudentVO> data = FXCollections.observableArrayList(studentList);
    @FXML
    void initialize() {
    	
        barChart.setTitle("막대그래프");
        
        XYChart.Series<String, Number> ser1 = new XYChart.Series<String, Number>();
        ser1.setName("국어");
        for(int i = 0; i < data.size(); i++) {
        	ser1.getData().add(new XYChart.Data<String, Number>(data.get(i).getStd_name(),data.get(i).getStd_kor()));      	
        };
        
        XYChart.Series<String, Number> ser2 = new XYChart.Series<String, Number>();
        ser2.setName("영어");
        for(int i = 0; i < data.size(); i++) {
        	ser2.getData().add(new XYChart.Data<String, Number>(data.get(i).getStd_name(),data.get(i).getStd_eng()));      	
        };
        
        XYChart.Series<String, Number> ser3 = new XYChart.Series<String, Number>();
        ser3.setName("수학");
        for(int i = 0; i < data.size(); i++) {
        	ser3.getData().add(new XYChart.Data<String, Number>(data.get(i).getStd_name(),data.get(i).getStd_mat()));      	
        };
        
        
        barChart.getData().addAll(ser1, ser2, ser3);

    }
}
