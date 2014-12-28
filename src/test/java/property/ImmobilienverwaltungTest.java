package property;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import property.Immobilie;
import property.Immobilienverwaltung;

public class ImmobilienverwaltungTest {

	private ArrayList<Immobilie> dieImmos;
	private Immobilienverwaltung verwaltung;

	@Before
	public void setUp() {
		dieImmos = new ArrayList<Immobilie>();

		Immobilie immo1 = new Immobilie("Masssenberg", 20, false, 65, 750, 200);
		Immobilie immo2 = new Immobilie("Langgasse 19", 30, true, 48, 250, 100);
		Immobilie immo3 = new Immobilie("Hauptplatz 1", 40, true, 30, 200, 50);
		Immobilie immo4 = new Immobilie("Hauptplatz 1", 50, false, 30, 200, 50);

		dieImmos.add(immo1);
		dieImmos.add(immo2);
		dieImmos.add(immo3);
		dieImmos.add(immo4);

		verwaltung = new Immobilienverwaltung(dieImmos);
	}

	@Test
	public void addImmobilieTest() {
		Immobilie immo3 = new Immobilie("Rossegasse", 20, false, 65, 750, 200);
		Immobilie immo4 = new Immobilie("Graz", 30, false, 48, 250, 100);
		Immobilie immo5 = new Immobilie("Graz", 35, false, 48, 250, 100);

		Assert.assertEquals(true, verwaltung.addImmobilie(immo3));
		Assert.assertEquals(true, verwaltung.addImmobilie(immo4));
		Assert.assertEquals(true, verwaltung.addImmobilie(immo5));

		Assert.assertEquals(false, verwaltung.addImmobilie(immo3));
		Assert.assertEquals(false, verwaltung.addImmobilie(immo4));
		Assert.assertEquals(false, verwaltung.addImmobilie(immo5));

		Assert.assertFalse(verwaltung.addImmobilie(immo5));
		Assert.assertFalse(verwaltung.addImmobilie(immo4));
		Assert.assertFalse(verwaltung.addImmobilie(immo3));
	}

	@Test
	public void gibGesamteinnahmenTest() {

		Assert.assertEquals(1800, verwaltung.gibGesamteinnahmen(), 0.001);
	}

	@Test
	public void sucheFreieTest() {
		Assert.assertEquals(1, verwaltung.sucheFreie(40, 100, 1000).size());
		Assert.assertEquals(2, verwaltung.sucheFreie(30, 100, 1000).size());
		Assert.assertEquals(1, verwaltung.sucheFreie(30, 100, 250).size());
		Assert.assertEquals(2, verwaltung.sucheFreie(30, 65, 1000).size());
		Assert.assertEquals(1, verwaltung.sucheFreie(30, 64, 1000).size());
		Assert.assertEquals(2, verwaltung.sucheFreie(25, 100, 1000).size());
	}

	@Test
	public void gibProzentVermieteteTest() {
		Assert.assertEquals(0.5, verwaltung.gibProzentVermietete(), 0.001);
		verwaltung.addImmobilie(new Immobilie("Rossegasse", 20, false, 65, 750,
				200));
		verwaltung.addImmobilie(new Immobilie("Graz", 30, false, 48, 250, 100));
		Assert.assertEquals(0.33, verwaltung.gibProzentVermietete(), 0.01);
		verwaltung.addImmobilie(new Immobilie("Wien", 30, true, 48, 250, 100));
		Assert.assertEquals(0.42, verwaltung.gibProzentVermietete(), 0.01);
	}

	@Test
	public void gibProzentVermieteteWennKeinObjektTest() {
		verwaltung = new Immobilienverwaltung();
		Assert.assertEquals(0, verwaltung.gibProzentVermietete(), 0.001);
	}

	@Test
	public void gibProzentVermieteteWennNurEinObjektVermietetTest() {
		verwaltung = new Immobilienverwaltung();
		verwaltung.addImmobilie(new Immobilie("Masssenberg 20", 2, true, 65,
				750, 200));
		Assert.assertEquals(1, verwaltung.gibProzentVermietete(), 0.001);
	}

	@Test
	public void gibProzentVermieteteWennMehrAlsEinObjektUndNurEineVermietetTest() {
		verwaltung = new Immobilienverwaltung();
		Assert.assertTrue(verwaltung.addImmobilie(new Immobilie(
				"Masssenberg 19", 20, false, 65, 750, 200)));
		Assert.assertEquals(0, verwaltung.gibProzentVermietete(), 0.001);
		Assert.assertTrue(verwaltung.addImmobilie(new Immobilie(
				"Masssenberg 20", 2, true, 65, 750, 200)));
		Assert.assertEquals(0.5, verwaltung.gibProzentVermietete(), 0.001);
	}

	@Test
	public void gibProzentVermieteteWennKeineVermietetTest() {
		verwaltung = new Immobilienverwaltung();
		verwaltung.addImmobilie(new Immobilie("Masssenberg 19", 20, false, 65,
				750, 200));
		verwaltung.addImmobilie(new Immobilie("Masssenberg 20", 2, false, 65,
				750, 200));
		Assert.assertEquals(0, verwaltung.gibProzentVermietete(), 0.001);
	}

	@Test
	public void gibProzentVermieteteWennAlleVermietetTest() {
		verwaltung = new Immobilienverwaltung();
		verwaltung.addImmobilie(new Immobilie("Masssenberg 19", 20, true, 65,
				750, 200));
		verwaltung.addImmobilie(new Immobilie("Masssenberg 20", 2, true, 65,
				750, 200));
		Assert.assertEquals(1, verwaltung.gibProzentVermietete(), 0.001);
	}

	@Test
	public void gibDurchschnittlicheMieteProQmTest() {
		Assert.assertEquals(7.520, verwaltung.gibDurchschnittlicheMieteProQm(),
				0.001);
	}

	@Test
	public void gibMehrfachAdresseTest() {
		Assert.assertEquals("Hauptplatz 1", verwaltung.gibMehrfachAdresse(2));
	}

}
