package basic.gugudan2;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxmlGugudan2 extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(FxmlGugudan2.class.getResource("fxmlGugudan2.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("구구단 콤보박스 연습");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
