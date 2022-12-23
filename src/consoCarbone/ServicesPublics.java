package consoCarbone;
/**
 * A ServicePublics Object is a ConsoCarbone that represents the carbon footprint of the use of public services
 * @author anfel MAZOUZ 
 *@version 1.0
 */

public class ServicesPublics extends ConsoCarbone{

	private static ServicesPublics conso;

/**
 * Construit un objet ServicesPublics en imposant la valeur de l'impact de 1.5 TCO2eq
 * 
 */
private ServicesPublics () {
	this.impact = this.setImpact();
}

//we add the synchronized keyword to avoid thread errors
/**
 *créer une instance ServicePublics si elle n'existe pas, 
 *sinon renvoyer celle qu'on a déja
 * 
 * @return unique instance Services publics
 */
public static synchronized ServicesPublics getConso() {
	if (conso == null) {
		conso = new ServicesPublics();
	}
	return conso;
}


@Override
protected double setImpact() {
	return 1.5;
}


@Override
public String toString() {
	return "ServicesPublics id:" + this.getId() + "\n"+"Impact: "+ this.getImpact()+"\n"+"----------------------------";
}



}
