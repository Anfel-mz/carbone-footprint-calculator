package consoCarbone;

/**
 * A BienConso object is a ConsoCarbone represents the carbon footprint of spending
 * @author anfel MAZOUZ
 * @version 1.0
 *
 */

public class BienConso extends ConsoCarbone{
private double montant; //dépenses annuelles de l'utilisateur


//constantes
private final static double DEPENSESTONNECO2= 1750;

/**
 * Construit un objet BienConso en initialisant la valeur du montant à 0
 * 
 */
public BienConso() {
	super();
	this.montant = 0;
	this.impact = this.setImpact();
}

/**
 * Construit un objet BienConso
 * 
 * @param montant Le montant des dépenses annuelle de l'utilisateur
 */
public BienConso(double montant) {
	super();
	this.montant = montant; 
	this.impact = this.setImpact();
}

@Override
protected double setImpact() {
	return this.montant/DEPENSESTONNECO2;
}

/**
 * afficher sur la console les détaille de l'empreinte carbone moyenne d'un français vis à vis la consomation du bien
 */
public static void empCarbon() {
    System.out.println("en moyenne les français emettent 2.7 TCO2eq par an liéer à l'achat du bien et des loisirs");

}

//getters and setters 
/**
 * 
 * @return le montant de dépenses annuelles de l'utilisateur en euro
 */
public double getMontant() {
	return montant;
}

/**
 * 
 * @param montant de dépenses annuelles de l'utilisateur en euro 
 */
public void setMontant(double montant) {
	this.montant = montant;
}


@Override
public String toString() {
	   String s = "ID: "+this.getId()+"\n"+"Montant des dépeses annuelles: "+this.getMontant()+"\n"+"impact: "+this.getImpact()+" TCO2"+"\n"+"--------------------------";
	   return s;
}


}
