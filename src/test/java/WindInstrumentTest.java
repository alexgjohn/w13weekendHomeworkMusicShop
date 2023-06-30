import items.WindInstrument;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WindInstrumentTest {

    private WindInstrument flute;

    @Before
    public void before(){
        flute = new WindInstrument("Irish flute", 100.00, 180.00, "Wood", 16);
    }

    @Test
    public void hasDescription(){
        assertEquals("Irish flute", flute.getDescription());
    }

    @Test
    public void hasBoughtAtValue(){
        assertEquals(100.00, flute.getBoughtAt(), 0.0);
    }

    @Test
    public void hasSoldForValue(){
        assertEquals(180.00, flute.getSoldFor(), 0.0);
    }

    @Test
    public void hasMarkUpValue(){
        assertEquals(80.00, flute.calculateMarkup(), 0.0);
    }

    @Test
    public void canPlay(){
        assertEquals("Toodle-doodle-doo!", flute.play());
    }
}
