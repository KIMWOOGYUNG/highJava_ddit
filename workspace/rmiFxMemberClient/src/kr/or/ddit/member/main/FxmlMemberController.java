package kr.or.ddit.member.main;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.AlertUtil;

public class FxmlMemberController {
	IMemberService service;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfTel;

    @FXML
    private TextField tfAddr;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnDel;

    @FXML
    private Button btnOk;

    @FXML
    private Button btnCancel;

    @FXML
    private TableView<MemberVO> table;

    @FXML
    private TableColumn<MemberVO, String> colID;

    @FXML
    private TableColumn<MemberVO, String> colName;

    @FXML
    private TableColumn<MemberVO, String> colTel;

    @FXML
    private TableColumn<MemberVO, String> colAddr;
    
    @FXML
    void tableClick(MouseEvent event) {
    	try {
			
	    	if(table.getSelectionModel().isEmpty()) {
	    		AlertUtil.warnMsg("경고", "테이블에서 데이터가 있는 곳을 선택하세요.");
	    		return;
	    	}else {
	    		tfId.setText(table.getSelectionModel().getSelectedItem().getMem_id());
	    		tfName.setText(table.getSelectionModel().getSelectedItem().getMem_name());
	    		tfTel.setText(table.getSelectionModel().getSelectedItem().getMem_tel());
	    		tfAddr.setText(table.getSelectionModel().getSelectedItem().getMem_addr());
	    	}
	
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    boolean addClicked;
    boolean editClicked;
    boolean deleteClicked;
    boolean addstart = false;
    
    @FXML
    void add(ActionEvent event) {
    	try {
			
	    	tfId.setDisable(false);
	    	tfName.setDisable(false);
	    	tfTel.setDisable(false);
	    	tfAddr.setDisable(false);
	    	
	    	btnAdd.setDisable(true);
	    	btnEdit.setDisable(true);
	    	btnDel.setDisable(true);
	    	
	    	btnOk.setDisable(false);
	    	btnCancel.setDisable(false);
	    	
	    	addClicked = true;
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void cancel(ActionEvent event) {
    	try {
    		Stage stage = (Stage) btnCancel.getScene().getWindow(); 	  
    		stage.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void delete(ActionEvent event) {
    	try {
			
	    	String id = tfId.getText();
	    	String name = tfName.getText();
	    	String tel = tfTel.getText();
	    	String addr = tfAddr.getText();
	    	
	    	if(table.getSelectionModel().isEmpty()) {
	    		AlertUtil.errorMsg("작업오류", "삭제할 항목을 선택한 후 진행하세요.");
	    		return;
	    	}
	    	   	
	    	btnOk.setDisable(false);
	    	btnCancel.setDisable(false);
	    	
	    	deleteClicked = true;
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void edit(ActionEvent event) {
    	try {
	    	if(table.getSelectionModel().isEmpty()) {
	    		AlertUtil.errorMsg("작업오류", "수정할 항목을 선택한 후 진행하세요.");
	    		return;
	    	}
	    	
	    	tfId.setDisable(false);
	    	tfName.setDisable(false);
	    	tfTel.setDisable(false);
	    	tfAddr.setDisable(false);
	
	    	MemberVO memVo = table.getSelectionModel().getSelectedItem();
	    	tfId.setText(memVo.getMem_id());
	    	tfName.setText(memVo.getMem_name());
	    	tfTel.setText(memVo.getMem_tel());
	    	tfAddr.setText(memVo.getMem_addr());
	    	
	    	tfId.setEditable(false);
	    	
	    	
	    	editClicked = true;
	    	
	    	btnAdd.setDisable(true);
	    	btnDel.setDisable(true);
	    	
	    	btnOk.setDisable(false);
	    	btnCancel.setDisable(false);
	    	   	
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void ok(ActionEvent event) {
    	try {
			
	    	if(addClicked == true) {
	    		
	    		//insert
	    		String id = tfId.getText();
	        	String name = tfName.getText();
	        	String tel = tfTel.getText();
	        	String addr = tfAddr.getText();
	        		
	        	if(id.isEmpty() || name.isEmpty() || tel.isEmpty() || addr.isEmpty()) {
	        		AlertUtil.errorMsg("입력오류", "빈 항목이 있습니다.");
	        		return;
	        	}
	        	
	        	MemberVO memVo = new MemberVO(id, name, tel, addr);
	    		/*
	    		MemberVO memVo = new MemberVO();
	    		memVo.setMem_id(tfId.getText());
	    		memVo.setMem_name(tfName.getText());
	    		memVo.setMem_tel(tfTel.getText());
	    		memVo.setMem_addr(tfAddr.getText());
	    		*/
	    		service.insertMember(memVo);
	    		
	    		AlertUtil.infoMsg("작업결과", name + "씨의 정보를 수정했습니다.");
	    	}else if(editClicked == true) {
	    		//edit
	    		String id = tfId.getText();
	    		String name = tfName.getText();
	    		String tel = tfTel.getText();
	    		String addr = tfAddr.getText();
	    		
	    		MemberVO memVo = new MemberVO();
	    		memVo.setMem_id(id);
	    		memVo.setMem_name(name);
	    		memVo.setMem_tel(tel);
	    		memVo.setMem_addr(addr);
	    		
	    		int index = table.getSelectionModel().getSelectedIndex();
	    		data.set(index, memVo);
	    		
	    		AlertUtil.infoMsg("작업결과", name + "씨의 정보를 수정했습니다.");
	    		
	    		service.updateMember(memVo);
	        	
	    		
	    	}else if(deleteClicked == true) {
	    		//delete
	    		String id = table.getSelectionModel().getSelectedItem().getMem_id();
	    		String name = table.getSelectionModel().getSelectedItem().getMem_name();
	    		
	    		int index = table.getSelectionModel().getSelectedIndex();
	    		data.remove(index);
	    		
	    		service.deleteMember(id);
	    		
	    		AlertUtil.infoMsg("작업결과", name + "씨의 정보를 삭제했습니다.");
	    	}
			
			  Stage stage = (Stage) btnOk.getScene().getWindow(); stage.close();
			 
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

    List<MemberVO> memList;
    ObservableList<MemberVO> data;
    @FXML
    void initialize() throws NotBoundException{
    	try {
			Registry reg = LocateRegistry.getRegistry(9999);
			
			service = (IMemberService) reg.lookup("MemberService");
			
			memList = service.getAllMember();
			 data = FXCollections.observableArrayList(memList);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
    	
    	
    	tfId.setDisable(true);
        tfName.setDisable(true);
        tfTel.setDisable(true);
        tfAddr.setDisable(true);
    	
    	table.setItems(data);
    	
    	colID.setCellValueFactory(
				new PropertyValueFactory<MemberVO, String>("mem_id"));
    	colName.setCellValueFactory(
    			new PropertyValueFactory<MemberVO, String>("mem_name"));
    	colTel.setCellValueFactory(
    			new PropertyValueFactory<MemberVO, String>("mem_tel"));
    	colAddr.setCellValueFactory(
    			new PropertyValueFactory<MemberVO, String>("mem_addr"));
    }
  
}
