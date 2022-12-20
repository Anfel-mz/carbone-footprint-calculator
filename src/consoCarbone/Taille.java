package consoCarbone;
/**
 * A Taill Object represents the size of a car
 * @author manfe
 *@version 1.0
 */
public enum Taille {
/**
 * Petite voiture
 */
P(4.2), 
/**
 * Grande voiture
 */
G(19);
	
	private double fabrication;
	/**
	 * construit un Objet Taille 
	 * @param le carbone emmit lors de la production de la voiture selon sa taille 
	 */
	private Taille(double d) {
		this.fabrication =d;
	}
	
	/**
	 * 
	 * @return le CO2 en TCO2eq emet lors de la fabrication de la voiture 
	 */
	public double getFabrication() {
		return this.fabrication;
	}
	

	
	@Override
	public String toString() {
		String rslt = (this.equals(Taille.P))?"petite" : "Grande";
		return rslt ;
	}
}
