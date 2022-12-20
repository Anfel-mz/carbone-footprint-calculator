package consoCarbone;

/**
 * A BienConso object is a ConsoCarbone represents the carbon footprint of spending
 * @author anfel MAZOUZ
 * @version 1.0
 *
 */

public class BienConso extends ConsoCarbone{
private double montant; //d�penses annuelles de l'utilisateur


//constantes
private final static double DEPENSESTONNECO2= 1750;

/**
 * Construit un objet BienConso en initialisant la valeur du montant � 0
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
 * @param montant Le montant des d�penses annuelle de l'utilisateur
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
 * afficher sur la console les d�taille de l'empreinte carbone moyenne d'un fran�ais vis � vis la consomation du bien
 */
public static void empCarbon() {
    System.out.println("en moyenne les fran�ais emettent 2.7 TCO2eq par an li�er � l'achat du bien et des loisirs");

}

//getters and setters 
/**
 * 
 * @return le montant de d�penses annuelles de l'utilisateur en euro
 */
public double getMontant() {
	return montant;
}

/**
 * 
 * @param montant de d�penses annuelles de l'utilisateur en euro 
 */
public void setMontant(double montant) {
	this.montant = montant;
}


@Override
public String toString() {
	   String s = "ID: "+this.getId()+"\n"+"Montant des d�peses annuelles: "+this.getMontant()+"\n"+"impact: "+this.getImpact()+" TCO2"+"\n"+"--------------------------";
	   return s;
}


}
