package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

import consoCarbone.*;
/** A Utilisateurs object represents the user of the calculator
 * 
 * @author anfel MAZOUZ
 * @version 1.0
 */

public class Utilisateurs {

private Alimentation alimentation;
private TreeMap<Integer,Logement> logement = new TreeMap <Integer, Logement>() ;
private BienConso bienConso;
private TreeMap<Integer,Transport> transport =new TreeMap <Integer, Transport>(); 
private ServicesPublics services;
private double empreinte;

/**
 * Constructeur par défaut de la calsse Utilisateurs
 */
public Utilisateurs () {

}

/**
 * constructure de la classe Utilisateurs qui initialise une instance à partir d'un fichier
 * @param file le nom du fichier ou son chemain
 */
public Utilisateurs (String file) {
    this();
	try {
		Scanner input = new Scanner(new File(file));
		input.useDelimiter("-|\n");
		
		while(input.hasNext()) {
			if (input.next().equals("Alimentation")) {
				double txB = input.nextDouble();
				double txV = input.nextDouble();
				this.setAlimentation(new Alimentation(txB, txV));
			}else if (input.next().equals("Logement")) {
				int superficie = input.nextInt();
				CE ce = CE.valueOf(input.next());
				this.setLogement(new Logement(superficie,ce));
			}else if (input.next().equals("BienConso")) {
				int montant = input.nextInt();
				this.setBienConso(new BienConso(montant));
			}else if (input.next().equals("Transport")) {
				Taille t = Taille.valueOf(input.next());
				int kmParAn = input.nextInt();
				int amor = input.nextInt();
				this.setTransport(new Transport(t,kmParAn, amor));
			}


	    }
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


/**
 * constructeur d'un utilisateur avec tous les données 
 * @param alimentation
 * @param bienConso
 * @param logement
 * @param transport
 */
public Utilisateurs (Alimentation alimentation, BienConso bienConso, Logement logement, Transport transport) {
	this.alimentation = alimentation;
	this.logement.put(logement.getId(), logement);
	this.bienConso= bienConso;
	this.transport.put(transport.getId(), transport);
	this.services= ServicesPublics.getConso();
	this.empreinte = this.CalculerEmpreinte();
}

/**
 * Calculate the Carbon footprint of a user 
 * @return the value of the impact a user has in TCO2eq
 */

public double CalculerEmpreinte() {
	return this.alimentation.getImpact() + this.calculerImpactLogement(this.logement.values()) + calculerImpactTransport(this.transport.values()) + this.bienConso.getImpact()+ this.services.getImpact();
}



/**
 * methode d'aide pour calculerEmpreinte
 * @param collection une collection d'objet Logement
 * @return l'empreinte de toute les consomations logement de l'utilisateur
 */
public double calculerImpactLogement(Collection<Logement> collection) {
	
	double consoImpact = 0;
    for (ConsoCarbone value: collection) {
        consoImpact += value.getImpact();
    }
    
    return consoImpact;
}



/**
 * methode d'aide pour calculerEmpreinte
 * @param collection une collection d'objet Transport
 * @return l'empreinte de toute les consomations de transport de l'utilisateur
 */
public double calculerImpactTransport(Collection<Transport> collection) {
	
	double consoImpact = 0;
    for (ConsoCarbone value: collection) {
        consoImpact += value.getImpact();
    }
    
    return consoImpact;
}


/**
 * shows the detailed result of the carbon footprint of a user to the console
 */
public String detaillerEmpreinte() {
	String detaille = "Votre Empreinte Carbonne est de "+this.empreinte+" TCO2eq \n"+ "\n"+ "impacte d'alimentation: "+ this.alimentation.getImpact()+" TCO2eq"
			+"\n"+"impacte de logement: "+ this.calculerImpactLogement(this.logement.values())+" TCO2eq"+"\n"+
			"impacte de la consomation du bien: "+ this.bienConso.getImpact() +" TCO2eq"+"\n"
			+"impacte de transport: "+ this.calculerImpactTransport(this.transport.values()) +" TCO2eq"+ "\n"+
			"impacte d'utilisation des services publiques: "+ this.services.getImpact() +" TCO2eq";
System.out.println(detaille);
return detaille;

}

/**
 * ordonne les consomations carbone de l'utilisateur dans une liste 
 * afficher les informations de la liste
 * donner des recommandations pour un mode de vie plus durable
 */
public void ordonneConso() {
	ArrayList<ConsoCarbone> liste = new ArrayList<ConsoCarbone>();
	liste.add(alimentation);
	liste.add(bienConso);
	liste.addAll(this.logement.values());
	liste.addAll(this.transport.values());
	liste.add(services);
	Collections.sort(liste);

	for (ConsoCarbone c : liste) {
		System.out.println(c); 
	}
	
	System.out.println("pour un mode de vie plus durable, nous vous conseillons :");
	recomendations (liste.get(liste.size()-1));
  
}

/**
 * une methode d'aide pour la methode ordonneConso
 * elle génère une recomendation par rapport à l'objet donner en paramètre
 * @param c une consomation carbone
 * @return String qui contient une recommendation en fonction de la classe de l'argument donner à la methode
 */
public String recomendations (ConsoCarbone c) {
	if(c.getClass() == (new Logement()).getClass()) {
		return "demenagez à un logement d'une classe energetique plus élevée ou d'une superficie plus petite \n";
	}else if(c.getClass() == (new Alimentation().getClass())) {
		return "Déminuez les repas à base de viande et manger plus végétarien \n";

	}else if(c.getClass() == (new BienConso()).getClass()) {
		return "déminuez vos dépenses du bien annuelles\n";

	}else if(c.getClass() == (new Transport()).getClass()) {
		return "Utilisez plus les transports en commun ou le vélo \n";
	}else {
		return "Evitez de beaucoup utiliser les services publiques \n";

	}
}
/**
 * 
 * @return l'empreinte de l'utilisateur de  l'utilisateur
 */
public double getEmpreinte() {
	return empreinte;
}
/**
 * 
 * @return l'alimentation de l'utilisateur
 */
public Alimentation getAlimentation() {
	return alimentation;
}
/**
 * modifie la valeur de l'objet alimentation de l'utilisateur et update l'empreinte
 * @param alimentation objet alimentation qu'on veut modifier
 */
public void setAlimentation(Alimentation alimentation) {
	this.alimentation = alimentation;
	this.empreinte = this.CalculerEmpreinte();
}
/**
 * 
 * @return la liste des elements logement de l'utilisateur
 */
public TreeMap<Integer, Logement> getLogement() {
	return logement;
}
/**
 * ajouter une instance logement à l'utilisateur et update l'empreinte
 * @param log un objet logement
 */
public void setLogement(Logement log) {
	this.logement.put(log.getId(), log);
	this.empreinte = this.CalculerEmpreinte();

}
/**
 * 
 * @return l'objet bienConos de l'utilisateur
 */
public BienConso getBienConso() {
	return bienConso;
}
/**
 * modifie l'objet bienConso de l'utilisateur et update l'empreinte
 * @param bienConso un objet BienConso
 */
public void setBienConso(BienConso bienConso) {
	this.bienConso = bienConso;
	this.empreinte = this.CalculerEmpreinte();

}
/**
 * 
 * @returnla liste des véhicules de l'utilisateur
 */
public TreeMap<Integer, Transport> getTransport() {
	return transport;
}
/**
 * ajouter un véhicule à l'utilisateur et update l'empreinte
 * @param t un objet transport
 */
public void setTransport(Transport t) {
	this.transport.put(t.getId(), t);
	this.empreinte = this.CalculerEmpreinte();

}



}
