package consoCarbone;
import java.lang.Math;

/**
 * a Transport object is a ConsoCarbone representing the carbon footprint of our vehicle
 * @author Anfel MAZOUZ
 *
 */

public class Transport extends ConsoCarbone {
	private boolean possede = false; //si l'utilisateur poss�de une voiture ou non
    private Taille taille;
    private int kilomAnnee; //nbr de KM parcourus /an
    private int amortissement; //dur�e de conservation du v�hicule
   
    
    //constantes
    private static final double CIMPACT = 1.93* Math.pow(10, (-4));
	
    /**
	 * Construit un objet transport sans param�tres
	 * 
	 * Par d�faut, l'utilisateur ne poss�de pas de voiture, la taille du v�hicule
	 * est null, et le nombre de kilom�tre parcouru par an et la dur�e de
	 * conservation du v�hicule sont initialis�s � 0
	 */
	public Transport() {
		super();
		this.possede = false;
		this.taille = null;
		this.kilomAnnee = 0;
		this.amortissement = 0;
	}
	
	/**
	 * Construit un objet transport en initialisant les param�tres
	 * 
	 * @param taille La taille du v�hicule de l'utilisateur
	 * @param kilomAnnee Le nombre de kilom�tres parcourus par an
	 * @param amortissement La dur�e de conservation du v�hicule
	 */
    public Transport (Taille taille, int kilomAnnee, int amortissement) {
    	super();
    	this.taille = taille;
    	this.kilomAnnee = kilomAnnee;
    	this.amortissement = amortissement;
    	this.possede = true;
    	this.impact = this.setImpact();
    	
    }
    
    @Override
protected double setImpact() {
    	double rslt = (this.possede)?(this.kilomAnnee*CIMPACT)+(this.taille.getFabrication()/this.amortissement):0;
    	return rslt;
    }
    
    /**
     * afficher sur la console les d�taille de l'empreinte carbone moyenne d'un fran�ais vis � vis la consomation de soin v�hicule
     */
    static public void empcarbonne(){
        System.out.println("les transports repr�sentent 31% de l'empreinte carbone des fran�ais soit 2650 kgCO2eq/an. Les v�hicules particuliers sont responsables de plus de la moiti� de cet impact suivi des poids lourds.");
    }
    
       
    //getters and setters 
    /**
     * 
     * @return true si l'utilisateur poss�de une voiture, false sinon
     */
       public boolean isPossede() {
		return possede;
	}

       /**
        * 
        * @param possede true si l'utilisateur poss�de une voiture, false sinon
        */
	public void setPossede(boolean possede) {
		this.possede = possede;
	}

	/**
	 * 
	 * @return La taille du v�hicule
	 */
	public Taille getTaille() {
		return taille;
	}
	

/**
 * 
 * @param taille la taille du v�hicule 
 */
	public void setTaille(Taille taille) {
		this.taille = taille;
	}

	/**
	 * 
	 * @return Le nombre de kilom�tres parcouru par an 
	 */
	public int getKilomAnnee() {
		return kilomAnnee;
	}

	/**
	 * 
	 * @param kilomAnnee Le nombre de kilom�tres parcouru par an 

	 */
	public void setKilomAnnee(int kilomAnnee) {
		this.kilomAnnee = kilomAnnee;
	}

	/**
	 * 
	 * @return La dur�e de conservation du v�hicule 
	 */
	public int getAmortissement() {
		return amortissement;
	}

	/**
	 * 
	 * @param amortissement La dur�e de conservation du v�hicule 
	 */
	public void setAmortissement(int amortissement) {
		this.amortissement = amortissement;
	}


	@Override
	   public String toString() {
		   String s = "ID: "+this.getId()+"\n"+"taille de v�hicule: "+this.getTaille()+"\n"+"nombre de kilom�tres parcourus par an: "+this.getKilomAnnee()+"\n"+"Dur�e de conservation du v�hicule: "+this.getAmortissement()+"\n"+"impacte: "+ this.getImpact()+" TCO2"+"\n"+"--------------------------";
		   if (possede) {
		   return s;
		   }else {
			   return "ID: "+this.getId()+"\n"+"l'utilisateur ne poss�de pas de voiture" + "\n"+this.getImpact()+" TCO2"+"\n"+"--------------------------";
		   }
	   }

}
