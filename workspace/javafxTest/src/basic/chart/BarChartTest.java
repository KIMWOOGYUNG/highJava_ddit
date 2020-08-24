package basic.chart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BarChartTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		//x축을 담당하는 객체 생성
		CategoryAxis xAxis = new CategoryAxis();
		
		//y축을 담당하는 객체 생성
		NumberAxis yAxis = new NumberAxis();
		
		//x축, y축을 담당하는 객체를 매개값으로 BarChart객체 생성
		BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
		
		bc.setTitle("나라별 Data");	//축의 제목
		xAxis.setLabel("나라이름"); 	//x축 제목
		yAxis.setLabel("Value"); 	//y축 제목
		
		// Chart에 출력할 데이터 구성하기
		
		//1. Series객체 생성 (같은 컬러가 Series)
		XYChart.Series<String, Number> ser1 = new XYChart.Series<String, Number>();
		ser1.setName("2018년"); 		//Series 이름 설정
		
		//2. 데이터 설정(방법1)
		ser1.getData().add(new XYChart.Data<String, Number>("호주",12000));
		ser1.getData().add(new XYChart.Data<String, Number>("영국",10000));
		ser1.getData().add(new XYChart.Data<String, Number>("미국",13000));
		ser1.getData().add(new XYChart.Data<String, Number>("프랑스",18000));
		ser1.getData().add(new XYChart.Data<String, Number>("독일",9000));
		//-----------------------------------------------------------------
		
		//시리즈2
		XYChart.Series<String, Number> ser2 = new XYChart.Series<String, Number>();
		ser2.setName("2019년");
		
		//데이터 설정(방법2)
		ObservableList<XYChart.Data<String, Number>> ser2List = FXCollections.observableArrayList();
		
		ser2List.addAll(
				new XYChart.Data<String, Number>("호주",8000),
				new XYChart.Data<String, Number>("영국",12000),
				new XYChart.Data<String, Number>("미국",19000),
				new XYChart.Data<String, Number>("프랑스",11000),
				new XYChart.Data<String, Number>("독일",13000)
		);
		ser2.setData(ser2List);
		//------------------------------------------------------------------
		//시리즈3
		XYChart.Series<String, Number> ser3 = new XYChart.Series<String, Number>();
		ser3.setName("2020년");
		
		//데이터 설정 (방법3)
		ser3.getData().add(new XYChart.Data<>("호주", 11000));
		ser3.getData().add(new XYChart.Data<>("영국",21000));
		ser3.getData().add(new XYChart.Data<>("미국",16000));
		ser3.getData().add(new XYChart.Data<>("프랑스",19000));
		ser3.getData().add(new XYChart.Data<>("독일",12000));
	
		//3. Series객체를 Chart에 추가한다.
		bc.getData().addAll(ser1, ser2, ser3);
		
		//bc.setBarGap(10); //bar사이의 Gap
		//bc.setCategoryGap(10);	//category사이의 Gap
		
		Scene scene = new Scene(bc);
		primaryStage.setScene(scene);
		primaryStage.setTitle("막대그래프 연습");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
