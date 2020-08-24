package basic.menu;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import sun.security.x509.Extension;

public class Menu_ex extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 400);
		
		MenuBar menuBar = new MenuBar();
		TextArea txtArea = new TextArea();
		
		menuBar.prefWidthProperty().bind(primaryStage.maxWidthProperty());
		txtArea.prefWidthProperty().bind(primaryStage.maxWidthProperty());
		root.setTop(menuBar);
		root.setCenter(txtArea);
		
		
		Menu fileMenu = new Menu("File");
	//새로만들기---------------------------------------------------------	
		MenuItem newMenuItem = new MenuItem("새로만들기");
		newMenuItem.setOnAction(e -> {	
			txtArea.clear();
			primaryStage.setTitle("NoName.txt");
		});
	//열기---------------------------------------------------------
		MenuItem openMenuItem = new MenuItem("열기");
		openMenuItem.setOnAction(e->{
			FileChooser fileChooser = new FileChooser();
			fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"), new ExtensionFilter("텍스트문서(*.txt)", "*.txt"));
			
			//열기할 폴더 지정
			File showDir = new File("C:\\Users\\PC-18\\Desktop\\OpenDialog");
			fileChooser.setInitialDirectory(showDir);
			
			//열기창 열고 선택한 파일 구하기
			File selectedFile = fileChooser.showOpenDialog(primaryStage);
			if(selectedFile != null) {
				//txtArea.appendText(selectedFile.get);
				showDir = selectedFile.getParentFile();	//열기한 문서의 폴더를 다음에 열기 할 때 나타나도록 지정
				
				//파일 내용을 읽어와 TextArea에 출력하기
				FileInputStream fis = null;
				try {
					fis =  new FileInputStream(selectedFile);
					int singleCh = 0;
					String str = "";
					while((singleCh = fis.read()) != -1){
						str += (char)singleCh;
					}
					txtArea.setText(str);
					fis.close();
					primaryStage.setTitle(selectedFile.getName());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}else {
				return;
			}
		});
		
	//----------------------------------------------------------	
		MenuItem asSaveMenuItem = new MenuItem("새이름으로저장");
		asSaveMenuItem.setOnAction(e -> {
			String str = txtArea.getText();
			
			FileChooser fileChooser = new FileChooser();
			fileChooser.getExtensionFilters().addAll(
					new ExtensionFilter("Text File", "*.txt"), 
					new ExtensionFilter("Image File", "*.png", "*.jpg", "*.gif"),
					new ExtensionFilter("All Files", "*.*"));
			File showDir = new File("C:\\Users\\PC-18\\Desktop\\OpenDialog");
			fileChooser.setInitialDirectory(showDir);
			
			File selectedFile = fileChooser.showSaveDialog(primaryStage);
			if(selectedFile != null) {
				try {
					FileOutputStream fos = new FileOutputStream(selectedFile);
					for(int i = 0; i < txtArea.getText().length(); i++){
						char ch = txtArea.getText().charAt(i);
						fos.write(ch);	//FileStream으로 출력하기	
					}
					fos.close();	//쓰기 완료 후 스트림 닫기
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		});
	//----------------------------------------------------------
		MenuItem exitMenuItem = new MenuItem("닫기");
		exitMenuItem.setOnAction(e -> {
			Platform.exit();
		});
		
		
		fileMenu.getItems().addAll(newMenuItem, openMenuItem, asSaveMenuItem);
		fileMenu.getItems().addAll(new SeparatorMenuItem(), exitMenuItem);
		
		menuBar.getMenus().addAll(fileMenu);
		
		Scene scene = new Scene(root, 300, 250);
		primaryStage.setScene(scene);
		primaryStage.setTitle("NoName.txt");
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
