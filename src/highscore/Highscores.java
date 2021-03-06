package highscore;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Creates connection to Highscore database and has methods for adding rows
 * to database and fetching database data.
 *
 * @author id15msd
 * @since 2018-12-10
 */
public class Highscores {
    private final String DBURL = "jdbc:mysql://mysql.cs.umu.se/v135h18g9";
    private final String USER = "v135h18g9";
    private final String PASSWORD = "Shqo9EdI0yjL138n";
    private Connection con;

    /**
     * Constructor of class.
     *
     * @throws SQLException If database connection fails.
     */
    public Highscores() throws SQLException{
        fetchDriver();
        initializeDatabaseConnection();
    }

    /**
     * Fetches highscores from the database and return a sorted list of strings.
     *
     * @param mapName From which map to fetch scores.
     * @return A sorted ArrayList with arrays of strings with database data.
     * @throws SQLException If cannot fetch from database.
     */
    public ArrayList<String[]> getHighscores(String mapName)
                                            throws SQLException {

        PreparedStatement stmt;
        stmt = con.prepareStatement("SELECT * FROM Highscores " +
                "WHERE MapName = ?");
        stmt.setString(1, mapName);
        return sortHighscore(stmt.executeQuery());

    }

    /**
     * Insert a row to the database.
     *
     * @param name Name of user.
     * @param mapName Name of map.
     * @param score Users score on the map.
     * @throws SQLException If insertion fails.
     */
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
                e.printStackTrace();
            }
        }
    }

    /**
     * Creates an ArrayList with arrays of String with the ResultSet from the
     * database and sorts it by highest to lowest score.
     *
     * @param res The ResultSet.
     * @return A sorted ArrayList with arrays of Strings.
     * @throws SQLException If ResultSet method is called and the result set
     * is closed.
     */
    private ArrayList<String[]> sortHighscore(ResultSet res)
            throws SQLException {
        ArrayList<String[]> DBlist = new ArrayList<>();
        ArrayList<Score> scores = new ArrayList<>();

        res.beforeFirst();
        while (res.next()){

            String username = res.getString("User");
            String map = res.getString("MapName");
            int score = res.getInt("Score");

            scores.add(new Score(username, map, score));

        }
        res.close();

        Collections.sort(scores, new CustomComparator());
        for (Score score: scores) {
            String[] s = {score.getName(), score.getMapName(),
                    String.valueOf(score.getScore())};
            DBlist.add(s);
        }

        return DBlist;
    }

    /**
     * Creates a connection with the database.
     *
     * @throws SQLException If connection fails.
     */
    private void initializeDatabaseConnection() throws SQLException{

        con = DriverManager.getConnection(DBURL, USER, PASSWORD);

    }

    /**
     * Fetches JDBC driver for database connection.
     */
    private void fetchDriver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Closes connection to database.
     */
    public void closeCon(){
        try{
            con.close();
        }
        catch (SQLException e){
            System.out.println("Could not close connection");
        }
    }
}
