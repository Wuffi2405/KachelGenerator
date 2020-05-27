package de.spd_bautzen;

public class KachelGenerator {
	
	private static KachelGenerator kachelGenerator;
	private Kachel kachel;
	
	public static void main(String[] args) {
		System.out.println("Hallo");
		
		kachelGenerator = new KachelGenerator();
	}
	
	public KachelGenerator() {
		kachelGenerator.kachel = new KachelFullImage();
	}
}
