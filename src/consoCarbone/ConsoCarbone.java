package consoCarbone;

/**
 * A cosoCarbone object is the carbon footprint of a specified child object
 * @author Anfel MAZOUZ
 *
 */

public abstract class ConsoCarbone implements Comparable <ConsoCarbone>{
	//generating unique ids for every instance 
private static int idcount = 0;
private int id = ++idcount;
protected double impact;


/**
 * Construit un objet ConsoCarbone
 * 
 */
protected ConsoCarbone () {
	
}

/**
 * Construit un objet ConsoCarbone
 * 
 * @param impact L'impact carbonne associé au poste de consommation ConsoCarbone
 */
protected ConsoCarbone (double impact) {
	this.impact = impact;
}

//getters and setters 
/**
 * 
 * @return the id of the instance (object)
 */
public int getId() {
	return this.id;
}

/**
 * 
 * @return l'impact de l'objet en termes d'émissions de GES en TCO2eq
 */
public double getImpact() {
	return impact;
}

/**
 * 
 * @return l'impacte calculer selon l'objet
 */
protected abstract double setImpact();

@Override
public int compareTo(ConsoCarbone o) {
	/*if the impact of this object is bigger the methode will return a positive number
	 * if the impact is smaller than the compared to object it will return a negative number 
	 * if it's the same it will return 0
	 * instead of an if clauses we return the diffrence
	 */
	
	return (int)(this.impact - o.getImpact());
}

}
