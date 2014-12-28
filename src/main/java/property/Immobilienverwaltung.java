package property;

import java.util.*;

public class Immobilienverwaltung {

	private ArrayList<Immobilie> list;

	private void init() {
		this.list = new ArrayList<Immobilie>();
	}

	public Immobilienverwaltung() {
		init();
	}

	private boolean contains(Immobilie inImmo) {
		for (Immobilie immo : list) {
			if (immo.equals(inImmo))
				return true;
		}
		return false;
	}

	public Immobilienverwaltung(ArrayList<Immobilie> dieImmobilien) {
		list = dieImmobilien;
	}

	public boolean addImmobilie(Immobilie neueImmo) {
		if (this.list.contains(neueImmo))
			return false;
		this.list.add(neueImmo);
		return true;
	}

	public double gibGesamteinnahmen() {
		double result = 0.0;
		for (Immobilie immo : list) {
			result += immo.getBK() + immo.getMiete();
		}
		return result;
	}

	public ArrayList<Immobilie> sucheFreie(int minQm, int maxQm, double maxPreis) {
		ArrayList<Immobilie> foundList = new ArrayList<Immobilie>();
		for (Immobilie immo : list) {
			if (immo.isInRange(minQm, maxQm, maxPreis)) {
				foundList.add(immo);
			}

		}
		return foundList;
	}

	public double gibProzentVermietete() {
		if (list.size() < 1) {
			return 0.0;
		}
		double counter = 0;
		double result = 0.0;
		for (Immobilie immo : list) {
			if (immo.getVermietet()) {
				counter++;
			}
		}
		result = counter / list.size();
		return result;
	}

	public double gibDurchschnittlicheMieteProQm() {
		if (list.size() < 1) {
			return 0.0;
		}
		double counter = 0;
		double result = 0.0;
		for (Immobilie immo : list) {
			counter += immo.getMiete() / immo.getQM();

		}
		result = counter / list.size();
		return result;
	}

	public String gibMehrfachAdresse(int k) {
		String result = "";

		for (Immobilie immo : list) {
			int count = 0;
			for (Immobilie immoN : list) {
				if (immo.getAdresse() == immoN.getAdresse()) {
					count++;
				}
			}

			if (count == k)
				return immo.getAdresse();
		}
		return result;
	}
}
