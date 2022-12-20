package application;

import consoCarbone.*;

public class Utilisateurs {

private Alimentation alimentation;
private Logement logement ;
private BienConso bienConso;
private Transport transport; 
private ServicesPublics services;

public double calculerEmpreinte() {
	return this.alimentation.getImpact() + this.logement.getImpact() + this.bienConso.getImpact() + this.transport.getImpact() + this.services.getImpact();
}

public void detaillerEmpreinte() {
	System.out.println("Votre Empreinte Carbonne est de "+this.calculerEmpreinte()+" TCO2eq \n");
	System.out.println("impacte d'alimentation: "+ this.alimentation.getImpact() +" TCO2eq");
	System.out.println("impacte de logement: "+ this.logement.getImpact() +" TCO2eq");
	System.out.println("impacte de la consomation du bien: "+ this.bienConso.getImpact() +" TCO2eq");
	System.out.println("impacte de transport: "+ this.transport.getImpact() +" TCO2eq");
	System.out.println("impacte d'utilisation des services publiques: "+ this.services.getImpact() +" TCO2eq");

}

}
