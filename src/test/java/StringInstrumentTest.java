import items.StringInstrument;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringInstrumentTest {

    private StringInstrument guitar;

    @Before
    public void before(){
        guitar = new StringInstrument("Acoustic guitar", 50.00, 100.00, 6);
    }

    @Test
    public void hasDescription(){
        assertEquals("Acoustic guitar", guitar.getDescription());
    }

    @Test
    public void hasBoughtAtValue(){
        assertEquals(50.00, guitar.getBoughtAt(), 0.0);

    }

    @Test
    public void hasSoldForValue(){
        assertEquals(100.00, guitar.getSoldFor(), 0.0);
    }

    @Test
    public void hasMarkUpValue(){
        assertEquals(50.00, guitar.calculateMarkup(), 0.0);
    }

    @Test
    public void canPlay(){
        assertEquals("struuuuuuuum!", guitar.play());
    }
}
