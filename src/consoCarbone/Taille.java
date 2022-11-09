package consoCarbone;

public enum Taille {
P(4.2), //petite voiture 
G(19); //grosse voiture 
	private double fabrication;
	private Taille(double d) {
		this.fabrication =d;
	}
	
	public double getFabrication() {//retourne le CO2 en tonne emet lors de la fabrication
		return this.fabrication;
	}
}
