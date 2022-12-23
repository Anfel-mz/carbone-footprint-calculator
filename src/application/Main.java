package application;

import java.util.Scanner;

import consoCarbone.*;

/**
 * the main class that implements an interactive menu with the user in the console
 * @author Anfel MAZOUZ
 *
 */
public class Main {

	/**
	 * this method implements a console interactive menu
	 * @param args the arguments given to the main method
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 

		// LOGEMENT
		Logement.empCarbon();

		System.out.println("enregistrement de la donn�e logement:"); 

		System.out.println("Saisir la superificie du logement (en m2) : "); 
		int superficie = sc.nextInt(); 

		sc.nextLine(); 

		System.out.println("Saisir la classe �nerg�tique du logement : "); // Affichage msg console
		CE ce = CE.valueOf(sc.nextLine()); 
		

		Logement logement = new Logement(superficie, ce); 

		// ALIMENTATION
		Alimentation.empCarbon();

		System.out.println("Enregistrement de la donn�e Alimentation:"); 
		
		System.out.println("Saisir le taux de repas � base de boeuf (valeur entre 0 et 1) : "); 
		
		double txB = Double.parseDouble(sc.next()); 

		sc.nextLine();

		System.out.println("Saisir le taux de repas v�g�tarien: "); 
		double txV = Double.parseDouble(sc.next());

		Alimentation alimentation = new Alimentation(txB, txV);

		
		// BIENCONSO
		BienConso.empCarbon();

		System.out.println("Enregistrement de la donn�e consomation du bien:"); 
																									
		System.out.println("le montant de vos d�penses annuelles: "); 
		double montant = sc.nextDouble(); 

		sc.nextLine();

		BienConso bienConso = new BienConso(montant); 
	

		// TRANSPORT
		Transport.empcarbonne();
		Transport transport;
		System.out.println("Enregistrement de votre consomation par rapport aux transports:"); // Affichage message console
		System.out.println("avez vous une voiture (false/true) : "); 
		boolean possede = sc.nextBoolean(); 

		sc.nextLine();
		if(possede) {

		System.out.println("La taille de votre v�hicule (petit ou grand):"); 
		Taille taille = (sc.nextLine().toLowerCase().contains("p"))?Taille.P:Taille.G; 

		System.out.println("Nombre de kilom�tre votre v�hicule parcourt par an: "); 
		
		int kmA = sc.nextInt();

		sc.nextLine();

		System.out.println("La dur�e de conservation de votre v�hicule: "); 
		int amo = sc.nextInt();

		transport = new Transport(taille, kmA, amo);
		
		}else {
			transport = new Transport();
		}

		sc.close();
		
		Utilisateurs user = new Utilisateurs(alimentation, bienConso,logement, transport);
		user.detaillerEmpreinte();
		user.ordonneConso();


        

	}
	

}
