package t3FX_D6;

public class Auto {
	private String modell;
	private int km;
	private int ps;
	private double preis;
	private String erstZulassung;
	private String bemerkung;
	private String bildPfad;
	public Auto(String modell, int km, int ps, double preis, String erstZulassung, String bemerkung, String bildPfad) {
		super();
		this.modell = modell;
		this.km = km;
		this.ps = ps;
		this.preis = preis;
		this.erstZulassung = erstZulassung;
		this.bemerkung = bemerkung;
		this.bildPfad = bildPfad;
	}
	public String getModell() {
		return modell;
	}
	public int getKm() {
		return km;
	}
	public int getPs() {
		return ps;
	}
	public double getPreis() {
		return preis;
	}
	public String getErstZulassung() {
		return erstZulassung;
	}
	public String getBemerkung() {
		return bemerkung;
	}
	public String getBildPfad() {
		return bildPfad;
	}
	@Override
	public String toString() {
		return modell + " (" + preis + ", " + erstZulassung + ")";
	}
	
	

}
