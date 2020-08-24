package basic.chart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class PieChartTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		PieChart pc = new PieChart();	//파이차트 생성
		
		ObservableList<PieChart.Data> pieList = 
			FXCollections.observableArrayList(	//데이터 리스트에 셋팅
				new PieChart.Data("사과", 100),
				new PieChart.Data("귤", 40),
				new PieChart.Data("포도", 60),
				new PieChart.Data("딸기", 30),
				new PieChart.Data("복숭아", 80)
			);
		
		pc.setData(pieList);	//리스트를 파이차트에 셋팅
		
		pc.setTitle("과일별 재고량");
		
		Scene scene = new Scene(pc);
		primaryStage.setScene(scene);
		primaryStage.setTitle("원그래프 연습");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
