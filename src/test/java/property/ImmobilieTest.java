package property;


import org.junit.Assert;
import org.junit.Test;

import property.Immobilie;


public class ImmobilieTest {

	@Test
	public void equalsTest(){
		Immobilie immo1 = new Immobilie("Masssenberg", 20, false, 65, 750, 200);
		Immobilie immo2 = new Immobilie("Langgasse 19", 30, true, 48, 250, 100);
		Immobilie immo3 = new Immobilie("Hauptpatz 1", 40, true, 30, 200, 50);
		Immobilie immo4 = new Immobilie("Hauptpatz 1", 50, false, 30, 200, 50);		
		Immobilie immo5 = new Immobilie("Hauptpatz 1", 50, false, 30, 200, 50);
		
		Assert.assertNotEquals(immo3,immo4);
		Assert.assertNotEquals(immo3,immo5);
		Assert.assertEquals(immo4, immo5);
	}
}
