package kr.or.ddit.prod.main;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.vo.LprodVO;
import kr.or.ddit.prod.vo.ProdVO;

public class FxmlProdController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<LprodVO> lprodCombo;

    @FXML
    private ComboBox<ProdVO> prodCombo;

    @FXML
    private TableView<ProdVO> table;

    @FXML
    private TableColumn<ProdVO, String> colId;

    @FXML
    private TableColumn<ProdVO, String> colName;

    @FXML
    private TableColumn<ProdVO, String> colLgu;

    @FXML
    private TableColumn<ProdVO, String> colBuyer;

    @FXML
    private TableColumn<ProdVO, String> colCost;

    @FXML
    private TableColumn<ProdVO, String> colPrice;

    @FXML
    private TableColumn<ProdVO, String> colSale;

    @FXML
    private TableColumn<ProdVO, String> colOutline;

    @FXML
    private TableColumn<ProdVO, String> colDetail;

    @FXML
    void lprodClick(ActionEvent event) {
    	LprodVO lprod = lprodCombo.getValue();
    	
    	List<ProdVO> prodList = ProdServiceImpl.getInstance().getAllProd(lprod.getLprod_gu());
	    ObservableList<ProdVO> prodData = FXCollections.observableArrayList(prodList);
	    
	    prodCombo.setItems(prodData);
	    prodCombo.setValue(prodCombo.getItems().get(0));
    	
    }
    
    @FXML
    void prodClick(ActionEvent event) {
    	
    	ProdVO prod = prodCombo.getValue();
    	
    	List<ProdVO> prodList = ProdServiceImpl.getInstance().tableView(prod.getProd_id());
	    ObservableList<ProdVO> prodData = FXCollections.observableArrayList(prodList);
	    
	    table.setItems(prodData);
	    
    }

    @FXML
    void tableClick(ActionEvent event) {

    }
    
   
    //ObservableList<ProdVO> prodData = FXCollections.observableArrayList(prodList);
    List<LprodVO> lprodList = ProdServiceImpl.getInstance().getAllLprod();
    private ObservableList<LprodVO> lprodData = FXCollections.observableArrayList(lprodList);
    
    @FXML
    void initialize() {
    	/*int lprod_index;
    	ProdServiceImpl service = ProdServiceImpl.getInstance();
    	List<LprodVO> lprodList = service.getAllLprod();
    	List<ProdVO> prodList = service.getAllProd();
    	
    	
    	for(int i = 0; i < lprodList.size(); i++) {
    		lprodCombo.getItems().addAll(lprodList.get(i).getLprod_nm());
    	}
    	
    	lprodCombo.getSelectionModel().selectedItemProperty().addListener(e->{
    		prodCombo.setDisable(false);
    		lprod_index = lprodCombo.getSelectionModel().getSelectedIndex();
    		String lprod_gu = lprodList.get(lprod_index).getLprod_gu();
    		
    		for(int i = 0; i<prodList.size();i++) {
    			if(prodList.get(i).getProd_lgu().equals(lprod_gu)) {
    				prodCombo.getItems().add(prodList.get(i).getProd_name());
    			}
    			
    		}
	
    	});
    	*/
    	
    	//lprod콤보 설정
    	lprodCombo.setItems(lprodData);	
		
		lprodCombo.setCellFactory(new Callback<ListView<LprodVO>, ListCell<LprodVO>>() {

			@Override
			public ListCell<LprodVO> call(ListView<LprodVO> param) {
				return new ListCell<LprodVO>() {

					@Override
					protected void updateItem(LprodVO item, boolean empty) {
						super.updateItem(item, empty);
						if (item == null || empty) {
							setText(null);
						} else {
							setText(item.getLprod_nm());
						}
					}
				};
			}
		});
		
		// ComboBox에서 항목을 선택하면 선택된 내용이 나타나는 곳을 ButtonCell이라고 하는데 //이곳의 데이터도 변경되도록 해야한다.
		lprodCombo.setButtonCell(new ListCell<LprodVO>() {

			@Override
			protected void updateItem(LprodVO item, boolean empty) {
				super.updateItem(item, empty);
				if (item == null || empty) {
					setText(null);
				} else {
					setText(item.getLprod_nm());
				}
			}
		});
		
		//초기값보이게
		lprodCombo.setValue(lprodCombo.getItems().get(0));
		
		//prod콤보설정
		List<ProdVO> prodList = ProdServiceImpl.getInstance().getAllProd(lprodCombo.getValue().getLprod_gu());
	    ObservableList<ProdVO> prodData = FXCollections.observableArrayList(prodList);
	    
	    prodCombo.setItems(prodData);
	    
		prodCombo.setCellFactory(new Callback<ListView<ProdVO>, ListCell<ProdVO>>() {

			@Override
			public ListCell<ProdVO> call(ListView<ProdVO> param) {
				return new ListCell<ProdVO>() {

					@Override
					protected void updateItem(ProdVO item, boolean empty) {
						super.updateItem(item, empty);
						if (item == null || empty) {
							setText(null);
						} else {
							setText(item.getProd_name());
						}
					}
				};
			}
		});

		// ComboBox에서 항목을 선택하면 선택된 내용이 나타나는 곳을 ButtonCell이라고 하는데 //이곳의 데이터도 변경되도록해야한다.
		prodCombo.setButtonCell(new ListCell<ProdVO>() {

			@Override
			protected void updateItem(ProdVO item, boolean empty) {
				super.updateItem(item, empty);
				if (item == null || empty) {
					setText(null);
				} else {
					setText(item.getProd_name());
				}
			}
		});

		// 초기값보이게 
		prodCombo.setValue(prodCombo.getItems().get(0));
		
		//테이블에 세팅
		ProdVO prod = prodCombo.getValue();
		prodList = ProdServiceImpl.getInstance().tableView(prod.getProd_id());
		prodData = FXCollections.observableArrayList(prodList);
		
		table.setItems(prodData);
		
		colId.setCellValueFactory(new PropertyValueFactory<ProdVO,String>("prod_id"));
		colName.setCellValueFactory(new PropertyValueFactory<ProdVO,String>("prod_name"));
		colLgu.setCellValueFactory(new PropertyValueFactory<ProdVO,String>("prod_lgu"));
		colBuyer.setCellValueFactory(new PropertyValueFactory<ProdVO,String>("prod_buyer"));
		colCost.setCellValueFactory(new PropertyValueFactory<ProdVO,String>("prod_cost"));
		colPrice.setCellValueFactory(new PropertyValueFactory<ProdVO,String>("prod_price"));
		colSale.setCellValueFactory(new PropertyValueFactory<ProdVO,String>("prod_sale"));
		colOutline.setCellValueFactory(new PropertyValueFactory<ProdVO,String>("prod_outline"));
		colDetail.setCellValueFactory(new PropertyValueFactory<ProdVO,String>("prod_detail"));
		
    }
}
