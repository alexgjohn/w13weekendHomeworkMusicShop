import items.Accessory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccessoryTest {

    private Accessory guitarPick;

    @Before
    public void before(){
        guitarPick = new Accessory("Shiny plastic guitar pick", 0.20, 3.00);
    }

    @Test
    public void hasDescription(){
        assertEquals("Shiny plastic guitar pick", guitarPick.getDescription());

    }

    @Test
    public void hasBoughtAtValue(){
        assertEquals(0.20, guitarPick.getBoughtAt(), 0.0);
    }

    @Test
    public void hasSoldForValue(){
        assertEquals(3.00, guitarPick.getSoldFor(), 0.0);
    }

    @Test
    public void hasMarkUpValue(){
        assertEquals(2.80, guitarPick.calculateMarkup(), 0.0);
    }

}
