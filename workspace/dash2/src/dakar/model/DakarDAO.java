package dakar.model;


import java.sql.*;
import java.util.ArrayList;


public class DakarDAO {
    final static String URL = "jdbc:mysql://localhost:3306/db?serverTimezone=UTC";

    public String add(Dakar dakar){
        String query = "insert into dakar (team_name, name_surname, sponsors, racing_cars, members, user_id)" +
                "values (?,?,?,?,?,?)";
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, dakar.getTeamName());
            preparedStatement.setString(2, dakar.getNameSurname());
            preparedStatement.setString(3, dakar.getSponsors());
            preparedStatement.setString(4, dakar.getRacingCars());
            preparedStatement.setInt(5, dakar.getMembers());
            preparedStatement.setInt(6, dakar.getUserid());
            preparedStatement.executeUpdate();
            return "Successfully created new entry";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Failure creating new entry";
        }
    }
    public static ResultSet dakarSql(User user, String action, String colName) {
        ResultSet resS = null;
        String setQuery ="";
        if (user.isAdmin()) {
            if (action.equals("select all")) {
                setQuery = "SELECT id, team_name, name_surname, sponsors, racing_cars, members FROM dakar;";
            } else if (action.equals("select by team name")) {
                setQuery = "SELECT id, team_name, name_surname, sponsors, racing_cars, members FROM dakar WHERE team_name LIKE \"%" + colName + "%\" ";
            } else if (action.equals("edit by id")) {
                setQuery = "SELECT id, team_name, name_surname, sponsors, racing_cars, members FROM dakar WHERE id =" + colName + " ";
            }
        } else {
            if (action.equals("select all")) {
                setQuery = "SELECT id, team_name, name_surname, sponsors, racing_cars, members from dakar WHERE user_id = " + user.getId();
            } else if (action.equals("select by team name")) {
                setQuery = "SELECT id, team_name, name_surname, sponsors, racing_cars, members FROM dakar WHERE user_id = " + user.getId() + " AND team_name LIKE \"%" + colName + "%\" ";
            } else if (action.equals("edit by id")) {
                setQuery = "SELECT id, team_name, name_surname, sponsors, racing_cars, members FROM dakar WHERE user_id = " + user.getId() + " AND id =" + colName + " ";
            }
        }

        System.out.println("Column name in DakarDAO: " + colName);
        System.out.println("Fetch užkalusa: " + setQuery);
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            resS = connection.createStatement().executeQuery(setQuery);
            return resS;
        } catch (SQLException e) {
            e.printStackTrace();
            return resS = null;
        }
    }

    public ResultSet searchByTeamName(String teamName, User user) {
        String query2 = "";
        ArrayList<Dakar> dakar = new ArrayList<>();
        if (user.isAdmin()) {
            if (teamName.equals("")) {
                query2 = "SELECT id, team_name, name_surname, sponsors, racing_cars, members FROM dakar;";
            } else query2 = "SELECT id, team_name, name_surname, sponsors, racing_cars, members FROM dakar WHERE team_name LIKE \"%" + teamName + "%\" ";
        } else {
        if (teamName.equals("")) {
            query2 = "SELECT id, team_name, name_surname, sponsors, racing_cars, members FROM dakar WHERE user_id = " + user.getId();
        } else query2 = "SELECT id, team_name, name_surname, sponsors, racing_cars, members FROM dakar WHERE user_id = " + user.getId() + " AND team_name LIKE \"%" + teamName + "%\" ";
        }
        System.out.println("is admin? " + user.isAdmin());
        System.out.println(query2);

        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(URL, "root", "");
            preparedStatement = connection.prepareStatement(query2);
            resultSet = preparedStatement.executeQuery(query2);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public static void searchByTeamNameQuery(String teamQuery, ArrayList arrayList, User user){
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(teamQuery);
            ResultSet resultSet = preparedStatement.executeQuery(teamQuery);
            int id=0;
            while (resultSet.next()){
                id = resultSet.getInt("id");
                String teamName2 = resultSet.getString("team_name");
                String nameSurname = resultSet.getString("name_surname");
                String sponsors = resultSet.getString("sponsors");
                String racingCars = resultSet.getString("racing_cars");
                int members = resultSet.getInt("members");

                arrayList.add(new Dakar(id, teamName2, nameSurname, sponsors, racingCars, members, user.getId()));
                //System.out.println("rastas įrašas: " + id + "-" + teamName2 + "-" + nameSurname + "-" + sponsors + "-" + racingCars + "-" + members);
                //
            }
            preparedStatement.close();
            connection.close();
            System.out.println("Pavyko atlikti paieska pagal Dakaro komandos pavadinima");
            //System.out.println("rastas įrašas: " + id);
            System.out.println(arrayList);
        } catch (SQLException e) {
            System.out.println("Ivyko klaida atliekant paieska pagal Dakaro komandos pavadinima");
            e.printStackTrace();
        }
    }
    public void editById(Dakar dakar){
        String query = "update dakar set team_name=?, name_surname=?, sponsors=?, racing_cars=?, members=? " +
                " where id=?";
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, dakar.getTeamName());
            preparedStatement.setString(2, dakar.getNameSurname());
            preparedStatement.setString(3, dakar.getSponsors());
            preparedStatement.setString(4, dakar.getRacingCars());
            preparedStatement.setInt(5, dakar.getMembers());
            preparedStatement.setInt(6, dakar.getId());
            preparedStatement.executeUpdate();

            System.out.println("Pavyko paredaguoti esama irasa");
        } catch (SQLException e) {
            System.out.println("Ivyko klaida redaguojant esama irasa");
            e.printStackTrace();
        }
    }
    public void deleteById(int id){
        String query = "delete from dakar where id=?";
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Pavyko istrinti esama irasa");
        } catch (SQLException e) {
            System.out.println("Ivyko klaida istrinant esama irasa");
            e.printStackTrace();
        }
    }



}
