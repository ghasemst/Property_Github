package property;

public class Immobilie {

	private String adresse;
	private int refNr, qm;
	private boolean vermietet;
	private double miete, bk;

	public Immobilie() {
	}

	public Immobilie(String adresse, int refNr, boolean vermietet, int qm,
			double miete, double bk) {
		this.adresse = adresse;
		this.refNr = refNr;
		this.vermietet = vermietet;
		this.qm = qm;
		this.miete = miete;
		this.bk = bk;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + refNr;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Immobilie other = (Immobilie) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (refNr != other.refNr)
			return false;
		return true;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public int getRefNR() {
		return this.refNr;
	}

	public boolean getVermietet() {
		return this.vermietet;
	}

	public int getQM() {
		return this.qm;
	}

	public double getMiete() {
		return this.miete;
	}

	public double getBK() {
		return this.bk;
	}

	public boolean isInRange(int minQm, int maxQm, double maxPreis) {
		if (!this.getVermietet() && this.getQM() >= minQm
				&& this.getQM() <= maxQm && this.getMiete() <= maxPreis) {
			return true;
		}
		return false;
	}
}
