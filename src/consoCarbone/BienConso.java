package consoCarbone;

public class BienConso extends ConsoCarbone{
private double montant; //d�penses annuelles de l'utilisateur
private double impact; //tonne de CO2

//constantes
private final static double DEPENSESTONNECO2= 1750;

public BienConso(double montant) {
	super();
	this.montant = montant; 
	this.impact = this.getimpact();
	this.empcarbonne(); //afficher le message � la console
}

private double getimpact() {
	return this.montant/DEPENSESTONNECO2;
}

static public void empcarbonne(){
    System.out.println("en moyenne les fran�ais emettent 2.7 TCO2eq par an li�er � l'achat du bien et des loisirs");
}
//getters and stters 

public double getMontant() {
	return montant;
}

public void setMontant(double montant) {
	this.montant = montant;
}

public double getImpact() {
	return impact;
}

public void setImpact(double impact) {
	this.impact = impact;
}



//toString
public String toString() {
	   String s = "Montant des d�peses annuelles: "+this.getMontant()+"\n"+"impact: "+this.getimpact()+" TCO2"+"\n"+"--------------------------";
	   return s;
}

}
