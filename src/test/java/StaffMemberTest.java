import People.StaffMember;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class StaffMemberTest {

    private StaffMember gavin;

    @Before
    public void before(){
        gavin = new StaffMember("Gavin", "Clerk", 10.00);
    }

    @Test
    public void hasName(){
        assertEquals("Gavin", gavin.getName());
    }

    @Test
    public void hasTitle(){
        assertEquals("Clerk", gavin.getTitle());
    }

    @Test
    public void hasHourlyWage(){
        assertEquals(10.00, gavin.getHourlyWage(), 0.0);
    }

    @Test
    public void canGetPaid(){
        double payment = gavin.getPaid(4);
        assertEquals(40.00, payment, 0.0);
    }
}
