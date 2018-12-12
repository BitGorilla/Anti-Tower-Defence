package Main;

import highscore.Highscores;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Linnea on 2018-11-27.
 */
public class AntiTowerDefence {

    public static void main( String[] args ) throws IOException {

        //new TestController();
        try {
            new Highscores();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
