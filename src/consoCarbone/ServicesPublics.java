package consoCarbone;
//this class represente le poste de consomation
//carbone induit par les services publiques 
//(justice, police, santé, éducation ...) => la consomation carboinne lors l'utilisation des ser pub
////////////////////////////////////////
//cette classe a la particuliarité que tous 
//les français ont la meme empreinte de 1.5TCO2
//pour ce poste de consomation
////////////////////////////////////////////

//this translate to all users share the same
//instance of this class ==> we use the singleton pattern

public class ServicesPublics extends ConsoCarbone{

	private static ServicesPublics conso;


private ServicesPublics () {
	this.impact = this.setImpact();
}

//we add the synchronized keyword to avoid thread errors 
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



}
