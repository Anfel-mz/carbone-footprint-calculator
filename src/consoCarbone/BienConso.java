package consoCarbone;

public class BienConso extends ConsoCarbone{
private double montant; //dépenses annuelles de l'utilisateur


//constantes
private final static double DEPENSESTONNECO2= 1750;

public BienConso(double montant) {
	super();
	this.montant = montant; 
	this.impact = this.setImpact();
}

@Override
protected double setImpact() {
	return this.montant/DEPENSESTONNECO2;
}

static public void empcarbonne(){
    System.out.println("en moyenne les français emettent 2.7 TCO2eq par an liéer à l'achat du bien et des loisirs");
}
//getters and stters 

public double getMontant() {
	return montant;
}

public void setMontant(double montant) {
	this.montant = montant;
}


@Override
public String toString() {
	   String s = "Montant des dépeses annuelles: "+this.getMontant()+"\n"+"impact: "+this.getImpact()+" TCO2"+"\n"+"--------------------------";
	   return s;
}

}
