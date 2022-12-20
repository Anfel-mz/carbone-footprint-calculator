package application;

import consoCarbone.*;
/** A Utilisateurs object represents the user of the calculator
 * 
 * @author anfel MAZOUZ
 * @version 1.0
 */

public class Utilisateurs {

private Alimentation alimentation;
private Logement logement ;
private BienConso bienConso;
private Transport transport; 
private ServicesPublics services;

/**
 * Calculate the Carbon footprint of a user
 * @return the value of the impact a user has in TCO2eq
 */

public double calculerEmpreinte() {
	return this.alimentation.getImpact() + this.logement.getImpact() + this.bienConso.getImpact() + this.transport.getImpact() + this.services.getImpact();
}

/**
 * shows the detailed result of the carbon footprint of a user to the console
 */
public void detaillerEmpreinte() {
	System.out.println("Votre Empreinte Carbonne est de "+this.calculerEmpreinte()+" TCO2eq \n");
	System.out.println("impacte d'alimentation: "+ this.alimentation.getImpact() +" TCO2eq");
	System.out.println("impacte de logement: "+ this.logement.getImpact() +" TCO2eq");
	System.out.println("impacte de la consomation du bien: "+ this.bienConso.getImpact() +" TCO2eq");
	System.out.println("impacte de transport: "+ this.transport.getImpact() +" TCO2eq");
	System.out.println("impacte d'utilisation des services publiques: "+ this.services.getImpact() +" TCO2eq");

}

}
