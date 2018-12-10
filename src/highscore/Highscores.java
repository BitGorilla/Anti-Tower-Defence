package highscore;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class Highscores {
    final String DBURL = "jdbc:mysql://mysql.cs.umu.se/v135h18g9";
    final String USER = "v135h18g9";
    final String PASSWORD = "Shqo9EdI0yjL138n";
    private Connection con;
    private Statement s;
    private ArrayList<User> users = new ArrayList<>();


    public Highscores() throws SQLException{
        fetchDriver();
        initializeDatabaseConnection();
    }

    public ArrayList<User> printHighscore() throws SQLException {
        ResultSet res = getHighscores();

        res.beforeFirst();
        while (res.next()){

            String username = res.getString("User");
            String mapName = res.getString("MapName");
            int score = Integer.parseInt(res.getString("Score"));

            users.add(new User(username, mapName, score));
        }

        Collections.sort(users, new CustomComperator());
        printSortedUsers();

        return users;
    }

    public void insertScore(String name, String mapName, int score)
                            throws SQLException {

        String scoreString = String.valueOf(score);
        s.execute("INSERT INTO Highscore VALUES " +
                "(NULL,'"+name+"','"+mapName+"','"+scoreString+"')");
    }

    private ResultSet getHighscores() throws SQLException {
        return s.executeQuery("SELECT * FROM Highscore");
    }

    private void initializeDatabaseConnection() throws SQLException{

        con = DriverManager.getConnection(DBURL, USER, PASSWORD);
        s = con.createStatement();
        s.execute("CREATE TABLE IF NOT EXISTS Highscore " +
                "(HS_Id int NOT NULL AUTO_INCREMENT," +
                "User varchar(255)," +
                "MapName varchar(255), " +
                "Score varchar(255), " +
                "CONSTRAINT PK_Highscore PRIMARY KEY (HS_Id))");

    }

    private void fetchDriver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("nooo");
            e.printStackTrace();
        }
    }

    private void printSortedUsers(){
        for (User u: users) {
            System.out.println(u.getName());
            System.out.println(u.getMapName());
            System.out.println(u.getScore());
            System.out.println("");
        }
    }
}
