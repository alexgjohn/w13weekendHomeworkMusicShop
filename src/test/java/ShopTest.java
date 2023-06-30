import People.StaffMember;
import items.Accessory;
import items.StringInstrument;
import items.WindInstrument;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import shop.Shop;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShopTest {

    private Shop shop;
    private WindInstrument flute;
    private StringInstrument guitar;
    private Accessory guitarPick;
    private StaffMember gavin;

    @Before
    public void before(){
        guitar = new StringInstrument("Acoustic guitar", 50.00, 100.00, 6);
        flute = new WindInstrument("Irish flute", 100.00, 180.00, "Wood", 16);
        guitarPick = new Accessory("Shiny plastic guitar pick", 0.20, 3.00);
        gavin = new StaffMember("Gavin", "Clerk", 10.00);
        shop = new Shop();
    }

    @Test
    public void hasEmptyHashMapOfStock(){
        assertTrue(shop.getStock().isEmpty());
    }

    //genuinely not sure why I had to structure the test this way. Should remember to ask about it in submission form.
    @Test
    public void canAddItemToStock() {
        shop.addItemToStock(guitar);
        assertEquals(1L, (long) shop.getStock().get(guitar));
    }


    @Test
    public void canAddMultipleItemsToStock(){
        shop.addItemToStock(guitar);
        shop.addItemToStock(guitar);
        shop.addItemToStock(guitar);
        assertEquals(3L, (long) shop.getStock().get(guitar));
    }

    @Test
    public void hasDailyProfits(){
        assertEquals(0, shop.getDailyProfits(), 0.0);
    }

    @Test
    public void canSellItem_inStock(){
        shop.addItemToStock(guitar);
        shop.addItemToStock(guitar);
        shop.addItemToStock(guitar);
        String result = shop.sellItem(guitar);
        assertEquals(50.00, shop.getDailyProfits(), 0.0);
        assertEquals(2L, (long) shop.getStock().get(guitar));
        assertEquals("Someone bought 1 Acoustic guitar.", result);
    }
    @Test
    public void canSellItem_notInStock(){
        String result = shop.sellItem(guitar);
        assertEquals(0, shop.getDailyProfits(), 0.0);
        assertEquals("The Acoustic guitar is not in stock.", result);
    }

    @Test
    public void canReturnTotalPotentialProfitForStock(){
        shop.addItemToStock(guitar);
        shop.addItemToStock(flute);
        shop.addItemToStock(guitarPick);
        assertEquals(132.80, shop.calculateTotalPotentialProfitForStock(), 0.0);
    }

    @Test
    public void hasStaff(){
        assertEquals(0, shop.getStaff().size());
    }

    @Test
    public void canAddStaff(){
        shop.addStaff(gavin);
        assertEquals(1, shop.getStaff().size());
    }

    @Test
    public void hasStaffOnShift(){
        assertTrue(shop.getStaffOnShift().isEmpty());
    }


    @Test
    public void canAddShift(){
        shop.addStaff(gavin);
        shop.addShift(gavin, 4);
        assertEquals(4L, (long) shop.getStaffOnShift().get(gavin));
    }

    @Test
    public void canPayStaff(){
        shop.addStaff(gavin);
        shop.addShift(gavin, 4);
        shop.payStaff();
        assertEquals(-40.00, shop.getDailyProfits(), 0.0);
    }

    @Test
    public void canEndBusinessDay(){
        shop.addStaff(gavin);
        shop.addShift(gavin, 4);
        shop.addItemToStock(guitar);
        shop.sellItem(guitar);
        shop.endOfDay();
        assertEquals(10.00, shop.getDailyProfits(), 0.0);
        assertTrue(shop.getStaffOnShift().isEmpty());

    }

}
