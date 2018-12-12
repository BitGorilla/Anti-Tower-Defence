package highscore;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class Highscores {
    private final String DBURL = "jdbc:mysql://mysql.cs.umu.se/v135h18g9";
    private final String USER = "v135h18g9";
    private final String PASSWORD = "Shqo9EdI0yjL138n";
    private Connection con;
    private ArrayList<Score> scores = new ArrayList<>();


    public Highscores() throws SQLException{
        fetchDriver();
        initializeDatabaseConnection();
    }

    public ArrayList<Score> printHighscore(String mapName) throws SQLException {
        ResultSet res = getHighscores(mapName);

        res.beforeFirst();
        while (res.next()){

            String username = res.getString("User");
            String map = res.getString("MapName");
            int score = res.getInt("Score");

            scores.add(new Score(username, map, score));
        }
        res.close();

        Collections.sort(scores, new CustomComperator());

        return scores;
    }

    public void insertScore(String name, String mapName, int score)
                            throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO Highscores " +
                                        "(User, MapName, Score) " +
                                        "VALUES (?,?,?)");

            stmt.setString(1, name);
            stmt.setString(2, mapName);
            stmt.setInt(3, score);

            stmt.executeUpdate();
        }
        finally {
            try {
                if (stmt != null) { stmt.close(); }
            }
            catch (Exception e) {
                // log this error
            }
        }
    }

    private ResultSet getHighscores(String mapName) throws SQLException {

        PreparedStatement stmt = null;
        stmt = con.prepareStatement("SELECT * FROM Highscores " +
                                        "WHERE MapName = ?");
        stmt.setString(1, mapName);
        return stmt.executeQuery();
    }

    private void initializeDatabaseConnection() throws SQLException{

        con = DriverManager.getConnection(DBURL, USER, PASSWORD);

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
        for (Score u: scores) {
            System.out.println(u.getName());
            System.out.println(u.getMapName());
            System.out.println(u.getScore());
            System.out.println(" ");
        }
    }

    public void closeCon(){
        try{
            con.close();
        }
        catch (SQLException e){
            System.out.println("Could not close connection");
        }
    }

    private void createDB() throws SQLException{
                Statement s = con.createStatement();
        s.execute("CREATE TABLE IF NOT EXISTS Highscores " +
                "(HS_Id int NOT NULL AUTO_INCREMENT," +
                "User varchar(255)," +
                "MapName varchar(255), " +
                "Score int, " +
                "CONSTRAINT PK_Highscore PRIMARY KEY (HS_Id))");
    }
}
