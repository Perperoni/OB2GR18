package fraktaler;

public class FraktalerMain {

	public static void main(String[] args) {
		
		Tegneflate tegneflate = new Tegneflate();
		Tegneflate tegneflate2 = new Tegneflate();
		Tegneflate tegneflate3 = new Tegneflate();
		new Tegneprogram("Fraktaler 1", tegneflate);
		new Tegneprogram("Fraktaler 2", tegneflate2);
		new Tegneprogram("Fraktaler 3", tegneflate3);
		
		/*
		 * Starter tegning på tegneflaten med parametre for 
		 * dybde (20) og forsinkelse (200) i millisekunder (for animasjon).
		 */
		Fraktal fraktal1 = new FraktalKvadrat1(20, 200, tegneflate);
		fraktal1.tegn();
		Fraktal fraktal2 = new FraktalKvadrat2(5, 200, tegneflate2);
		fraktal2.tegn();
 		Fraktal fraktal3 = new FraktalTrekant(5, 200, tegneflate3);
		fraktal3.tegn();
	}
}