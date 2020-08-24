package kr.or.ddit.zipcode.main;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import kr.or.ddit.zipcode.service.IzipcodeService;
import kr.or.ddit.zipcode.vo.ZipcodeVo;

public class ZipcodeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cbBox;

    @FXML
    private Button btn;

    @FXML
    private TextField txtField;
    
    @FXML
    private TableView<ZipcodeVo> table;

    @FXML
    private TableColumn<ZipcodeVo, String> zipcode;

    @FXML
    private TableColumn<ZipcodeVo, String> sido;

    @FXML
    private TableColumn<ZipcodeVo, String> gugun;

    @FXML
    private TableColumn<ZipcodeVo, String> dong;

    @FXML
    private TableColumn<ZipcodeVo, String> bunji;
    
    

    @FXML
    void btnClick(ActionEvent event) {
    	try {
	    	String txt = txtField.getText();
	    	List<ZipcodeVo> zipList = null;
	    	ObservableList<ZipcodeVo> data;
	    	if(cbBox.getValue().equals("동이름")) {
	    		data = FXCollections.observableArrayList(service.searchDong(txt));	    		
	    	}else { 			
	    		data = FXCollections.observableArrayList(service.searchZipcode(txt));;
	    	}
	    	
			table.setItems(data);
    		
    	} catch (Exception e) {
    		// TODO: handle exception
    	}
    }
    
    //IzipcodeService service = ZipcodeServiceImpl.getInstance();
    @FXML
    void cbBoxClick(ActionEvent event) {
    	select = cbBox.getValue();
    }
    
    IzipcodeService service;
    String select = "";
//    List<ZipcodeVo> zipList = ZipcodeServiceImpl.getInstance().
    @FXML
    void initialize() throws NotBoundException {
    	//Service 객체 생성
    	try {
			Registry reg = LocateRegistry.getRegistry(9999);
			
			service = (IzipcodeService) reg.lookup("zipService");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
    	
       cbBox.getItems().addAll("동이름","우편번호");
       cbBox.setValue(cbBox.getItems().get(0));       
       zipcode.setCellValueFactory(new PropertyValueFactory<ZipcodeVo, String>("zipcode"));
       sido.setCellValueFactory(new PropertyValueFactory<ZipcodeVo, String>("sido"));
       gugun.setCellValueFactory(new PropertyValueFactory<ZipcodeVo, String>("gugun"));
       dong.setCellValueFactory(new PropertyValueFactory<ZipcodeVo, String>("dong"));
       bunji.setCellValueFactory(new PropertyValueFactory<ZipcodeVo, String>("bunji"));
    }
}
