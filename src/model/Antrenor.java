package model;

public class Antrenor {
	private int id;
	private String ad;
	private String uzmanlik;
	
	public Antrenor(int id, String ad, String uzmanlik) {
		this.id=id;
		this.ad=ad;
		this.uzmanlik=uzmanlik;
	}
	
	@Override
	public String toString() {
		return ad+ " - " + uzmanlik;
	}
	
	public int getId() {
		return id;
	}

}
