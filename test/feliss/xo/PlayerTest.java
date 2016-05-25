package feliss.xo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    @Test
    public void getName() throws Exception {
        final String TEST_VALUE = "Slava";
        final String EXPECTED_VALUE = TEST_VALUE;

        final Player player = new Player(TEST_VALUE, null);
        final String value = player.getName();

        assertEquals(EXPECTED_VALUE, value);
    }

    @Test
    public void getFigure() throws Exception {
        final Figure TEST_VALUE = Figure.X;
        final Figure EXPECTED_VALUE = TEST_VALUE;

        final Player player = new Player(null, TEST_VALUE);
        final Figure value = player.getFigure();

        assertEquals(EXPECTED_VALUE, value);
    }

}