package consoCarbone;

/**
 * CE objects are the different types of energy consumption classes of accommodations
 * @author Anfel MAZOUZ
 *@version 1.0
 */


public enum CE {
	/**
	 * Classe énergétique A
	 */	
	A(0.005),
	/**
	 * Classe énergétique B
	 */
	B(0.01),
	/**
	 * Classe énergétique C
	 */
	C(0.02),
	/**
	 * Classe énergétique D
	 */
	D(0.035),
	/**
	 * Classe énergétique E
	 */
	E(0.055),
	/**
	 * Classe énergétique F
	 */
	F(0.08),
	/**
	 * Classe énergétique G
	 */
	G(0.1);

	private final double co;
	
	/**
	 * construit un Objet CE
	 * @param la coefficient multiplicatif de la classe énérgétique 
	 */
	private CE(double d) {
		this.co = d;
	}
	
	/**
	 * 
	 * @return la coefficient multiplicatif de la classe énérgétique 
	 */
	public double getCo() {
		return this.co;
	}
}
