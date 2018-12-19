import highscore.Score;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ScoreTest {
    private Score score;

    @Before
    public void setUp(){
        score = new Score("Name", "mapName", 5);
    }

    @Test
    public void getScoreTest() {
        Assert.assertEquals(5, score.getScore());
    }

    @Test
    public void getNameTest(){
        Assert.assertEquals("Name", score.getName());
    }

    @Test
    public void getMapNameTest(){
        Assert.assertEquals("mapName", score.getMapName());
    }

    @Test (expected = IllegalArgumentException.class)
    public void negativeScoreTest(){
        score = new Score("Name", "mapName", -5);
    }

}
