package de.spd_bautzen;

public class KachelGenerator {
	
	private static KachelGenerator kachelGenerator;
	
	public static void main(String[] args) {
		LoadInterpreter loadInterpreter = new LoadInterpreter();
		loadInterpreter.readXML(null);
	}
}
