package consoCarbone;

/**
 * CE objects are the different types of energy consumption classes of accommodations
 * @author Anfel MAZOUZ
 *@version 1.0
 */


public enum CE {
	/**
	 * Classe �nerg�tique A
	 */	
	A(0.005),
	/**
	 * Classe �nerg�tique B
	 */
	B(0.01),
	/**
	 * Classe �nerg�tique C
	 */
	C(0.02),
	/**
	 * Classe �nerg�tique D
	 */
	D(0.035),
	/**
	 * Classe �nerg�tique E
	 */
	E(0.055),
	/**
	 * Classe �nerg�tique F
	 */
	F(0.08),
	/**
	 * Classe �nerg�tique G
	 */
	G(0.1);

	private final double co;
	
	/**
	 * construit un Objet CE
	 * @param la coefficient multiplicatif de la classe �n�rg�tique 
	 */
	private CE(double d) {
		this.co = d;
	}
	
	/**
	 * 
	 * @return la coefficient multiplicatif de la classe �n�rg�tique 
	 */
	public double getCo() {
		return this.co;
	}
}
