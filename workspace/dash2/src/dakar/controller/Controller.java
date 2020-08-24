package dakar.controller;

import dakar.model.Dakar;
import dakar.model.DakarDAO;
import dakar.model.User;
import dakar.model.UserDAO;
import dakar.utils.Validation;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {

    @FXML
    private TextField password;
    @FXML
    private TextField username;
    @FXML
    private Label error;
    @FXML
    private Button close;
    @FXML
    private TextField regUser;
    @FXML
    private PasswordField regPassw;
    @FXML
    private PasswordField regConfPassw;
    @FXML
    private TextField regEmail;
    @FXML
    private Label regError;
    @FXML
    private CheckBox cbFrance;
    @FXML
    private CheckBox cbAqua;
    @FXML
    private CheckBox cbSaudi;
    @FXML
    private RadioButton rbToyota;
    @FXML
    private RadioButton rbMini;
    @FXML
    private RadioButton rbPeugeot;
    @FXML
    private ComboBox comboNum;
    @FXML
    private TextField teamName;
    @FXML
    private TextField nameSurname;
    @FXML
    private Label warning;
    @FXML
    private TableView table;
    @FXML
    private TextField id;
    @FXML
    private  CheckBox admin;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private Label logname;
    @FXML
    private Label role;

    ResultSet rsAllEntries;
    ObservableList<ObservableList> data = FXCollections.observableArrayList();

    public void login(ActionEvent event) {
        if (Validation.isValidUsername(username.getText()) && Validation.isValidPassword(password.getText())) {
            UserDAO userDAO = new UserDAO();
            String msg = userDAO.login(username.getText(), password.getText());
            if (msg.contains("Successful")) {
                User user = userDAO.getUser(username.getText());
                dashboard(event, user);
            } else {
                error.setText(msg);
            }

        } else {
            error.setText("Wrong user name or password!");
        }
        error.setVisible(true);
    }

    // button 'X' closes stage(window)
    public void closeWindow(ActionEvent event) {
        if (event.getSource() == close) {
            System.exit(0);
        }
    }

    public void register(ActionEvent event) {
        try {
            // we are in controller folder, but our view is not here, so we need to go one step up - ../
            Parent root = FXMLLoader.load(getClass().getResource("../view/register.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Register");
            stage.setScene(new Scene(root, 450, 350));
            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerLogin(ActionEvent event) {
        boolean isRegistered = true;

        // clear errors on btn pressed
        regError.setText("");
        if (!Validation.isValidUsername(regUser.getText())) {
            regError.setText("Username is incorrect (letters and numbers only, at least 5 char)");
            isRegistered = false;
        } else if (!Validation.isValidPassword(regPassw.getText())) {
            regError.setText("Password is incorrect (letters and numbers only, at least 5 char)");
            isRegistered = false;
        } else if (!regConfPassw.getText().equals(regPassw.getText())) {
            regError.setText("Password doesn't match");
            isRegistered = false;
        } else if (!Validation.isValidEmail(regEmail.getText())) {
            regError.setText("Email is not correct, pattern- dakar@one.lt");
            isRegistered = false;
        }

        if (isRegistered) {
            User user = new User(regUser.getText(), regPassw.getText(), regEmail.getText(), admin.isSelected());
            UserDAO userDAO = new UserDAO();
            String msg = userDAO.register(user);
            if (msg.contains("successfully")) {
                try {
                    loadLogin();
                    // hides current stage (window)
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                regError.setText(msg);
            }
        }
    }

    public void dashboard(ActionEvent event, User user) {
        try {
            // we are in controller folder, but our view is not here, so we need to go one step up - ../
            Parent root = FXMLLoader.load(getClass().getResource("../view/dashboard.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Dashboard");

            // scrollBar is added into dashboard
            ScrollPane sp = new ScrollPane();
            sp.setContent(root);
            stage.setScene(new Scene(sp, 1300, 850));

            //style.css is uploaded, because disabled buttons(update & delete) should be displayed with opacity
            if (!user.isAdmin()) {
                sp.getStylesheets().add(String.valueOf(getClass().getResource("../view/style.css")));
            }

            Label lblLoginName = (Label) root.lookup("#logname");
            Label lblLoginRole = (Label) root.lookup("#role");
            if (lblLoginName != null) lblLoginName.setText(user.getUsername());
            if (lblLoginRole != null) lblLoginRole.setText(user.isAdmin() ? "Admin" : "User");

            stage.show();
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void create() {
        String teamName1 = teamName.getText();
        String nameSurname1 = nameSurname.getText();

        String sponsors = "";

        if (cbFrance.isSelected()) {
            sponsors += cbFrance.getText() + ",";
        }
        if (cbAqua.isSelected()) {
            sponsors += cbAqua.getText() + ",";
        }
        if (cbSaudi.isSelected()) {
            sponsors += cbSaudi.getText() + ",";
        }

        String racingCar = "";
        if (rbMini.isSelected()) {
            racingCar += rbMini.getText();
        } else if (rbPeugeot.isSelected()) {
            racingCar += rbPeugeot.getText();
        } else if (rbToyota.isSelected()) {
            racingCar += rbToyota.getText();
        }
        int members = 0;
        if (!comboNum.getSelectionModel().isEmpty()) {
            members = Integer.parseInt((String) comboNum.getValue());
        } else {
            warning.setText("Please check team members");
        }

        if (!Validation.isValidTeamName(teamName1)) {
            warning.setText("TeamName Required");
        } else if (!Validation.isValidSurName(nameSurname1)) {
            warning.setText("SureName Required");
        } else {
            UserDAO userDAO = new UserDAO();
            User user = userDAO.getUser(logname.getText());
            DakarDAO dakarDAO = new DakarDAO();
            Dakar dakar = new Dakar(teamName1, nameSurname1, sponsors, racingCar, members, user.getId());
            String msg = dakarDAO.add(dakar);
            warning.setText(msg);
        }
        updateTableFromDB(teamName1);
    }

    public void searchTeam() {
        updateTableFromDB(teamName.getText());
    }

    public void updateTableFromDB(String teamName) {
        DakarDAO dakarDAO = new DakarDAO();
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUser(logname.getText());
        try {
            rsAllEntries = dakarDAO.searchByTeamName(teamName, user);
        } catch (NullPointerException e) {
            warning.setText("No rows to display");
        }
        clearFields();
        fetColumnList();
        fetRowList();
    }
    public void update() {
        if(role.getText().equals("Admin")) {

            String teamName1 = teamName.getText();
            String nameSurname1 = nameSurname.getText();

            String sponsors = "";
            if (cbFrance.isSelected()) {
                sponsors += cbFrance.getText() + ",";
            }
            if (cbAqua.isSelected()) {
                sponsors += cbAqua.getText() + ",";
            }
            if (cbSaudi.isSelected()) {
                sponsors += cbSaudi.getText() + ",";
            }

            String racingCar = "";
            if (rbMini.isSelected()) {
                racingCar += rbMini.getText();
            } else if (rbPeugeot.isSelected()) {
                racingCar += rbPeugeot.getText();
            } else if (rbToyota.isSelected()) {
                racingCar += rbToyota.getText();
            }
            int members = 0;
            if (!comboNum.getSelectionModel().isEmpty()) {
                members = Integer.parseInt((String) comboNum.getValue());
            } else {
                warning.setText("Please check number of team members");
            }

            if (!Validation.isValidTeamName(teamName1)) {
                warning.setText("TeamName Required");
            } else if (!Validation.isValidSurName(nameSurname1)) {
                warning.setText("SureName Required");
                //updateTableFromDB(""); // get all entries after entry update (including newly updated)
            } else {
                String tId = id.getText();
                int teamid = Integer.parseInt(id.getText());
                //we don't know user's id at this point, but we must to assign any integer value
                int userid = 0;
                Dakar dakar = new Dakar(teamid, teamName1, nameSurname1, sponsors, racingCar, members, userid);
                DakarDAO dakarDAO = new DakarDAO();

                dakarDAO.editById(dakar);
                updateTableFromDB(teamName1);

            }
        }else {
            clearFields();
            warning.setText("Update feature is only for admins");
        }
    }

    public void delete() {
        if (role.getText().equals("Admin")) {
        DakarDAO dakarDAO = new DakarDAO();
        dakarDAO.deleteById(Integer.parseInt((String) id.getText()));
        updateTableFromDB("");

        } else {
            clearFields();
            warning.setText("Delete feature is only for admins");
        }
    }

    // po duomenų įvedimo išvalo nurodytus laukus, kad būtų patogiau suvesti naujus duomenis
    private void clearFields() {
        id.clear();
        teamName.clear();
        nameSurname.clear();
        comboNum.valueProperty().set(null);
    }

    public void fetColumnList() {

        try {

            table.getColumns().clear();
            if (rsAllEntries != null) {
                //SQL FOR SELECTING ALL OF CUSTOMER

                for (int i = 0; i < rsAllEntries.getMetaData().getColumnCount(); i++) {
                    //We are using non property style for making dynamic table
                    final int j = i;
                    TableColumn col = new TableColumn();
                    switch (rsAllEntries.getMetaData().getColumnName(i + 1)) {
                        case "id":
                            col.setText("Id");
                            break;
                        case "team_name":
                            col.setText("Team Name");
                            break;
                        case "name_surname":
                            col.setText("Name Surname");
                            break;
                        case "sponsors":
                            col.setText("Sponsors");
                            break;
                        case "racing_cars":
                            col.setText("Racing Cars");
                            break;
                        case "members":
                            col.setText("Members");
                            break;
                    /*case "user_id":
                        col.setText("User Id");
                        break;*/
                        default:
                            col.setText(rsAllEntries.getMetaData().getColumnName(i + 1)); //if column name in SQL Database is not found, then TableView column receive SQL Database current column name (not readable)
                            break;
                    }
                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                            return new SimpleStringProperty(param.getValue().get(j).toString());
                        }
                    });

                    table.getColumns().removeAll(col);
                    table.getColumns().addAll(col);
                    System.out.println("Column [" + i + "] ");
                }

            } else {
                warning.setText("No columns to display");
            }
        }catch (SQLException e) {
            System.out.println("Failure getting column data from SQL ");
        }
    }

    //fetches rows and data from the list
    public void fetRowList() {

    try {
        data .clear();
        if (rsAllEntries != null) {
            while (rsAllEntries.next()) {
                //Iterate Row
                ObservableList row = FXCollections.observableArrayList();
                for (int i = 1; i <= rsAllEntries.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(rsAllEntries.getString(i));
                }
                System.out.println("Row [1] added " + row);
                data.add(row);
            }
            //connects table with list
            table.setItems(data);
        } else {
            warning.setText("No rows to display");
        }
        } catch (SQLException ex) {
            System.out.println("Failure getting row data from SQL ");
        }
    }

    public void logOutDashboard(ActionEvent event) {

            loadLogin();
            // hides current stage (window)
            ((Node) (event.getSource())).getScene().getWindow().hide();

    }

    public void loadLogin(){
        try {
        Parent root = FXMLLoader.load(getClass().getResource("../view/login.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 450, 350));
        stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}