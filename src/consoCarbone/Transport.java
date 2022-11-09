package consoCarbone;
import java.lang.Math;

public class Transport extends ConsoCarbone {
	private boolean possede = false; //si l'utilisateur poss�de une voiture ou non
    private Taille taille;
    private int kilomAnnee; //nbr de KM parcourus /an
    private int amortissement; //dur�e de conservation du v�hicule
    private double impact = 0 ; 
    
    //constantes
    private static final double CIMPACT = 1.93* Math.pow(10, (-4));
    
    public Transport (Taille taille, int kilomAnnee, int amortissement) {
    	super();
    	this.taille = taille;
    	this.kilomAnnee = kilomAnnee;
    	this.amortissement = amortissement;
    	this.possede = true;
    	this.impact = this.getimpact();
    	this.empcarbonne();//afficher le message � la console 
    }
    
    private double getimpact() {
    	if(this.possede) {
    	return (this.kilomAnnee*CIMPACT)+(this.taille.getFabrication()/this.amortissement);
    	} else {
    		return 0;
    	}
    	
    }
    
    static public void empcarbonne(){
        System.out.println("les transports repr�sentent 31% de l'empreinte carbone des fran�ais soit 2650 kgCO2eq/an. Les v�hicules particuliers sont responsables de plus de la moiti� de cet impact suivi des poids lourds.");
    }
    
       
    
   /////////////////////////// //getters and setters /////////////////////////////////////
    public boolean isPossede() {
		return possede;
	}

	public void setPossede(boolean possede) {
		this.possede = possede;
	}

	public Taille getTaille() {
		return taille;
	}
	public String getT() {
		if(this.taille.equals(Taille.P)) {
			return "petite";
		}else{
			return "grande";
		}
	}

	public void setTaille(Taille taille) {
		this.taille = taille;
	}

	public int getKilomAnnee() {
		return kilomAnnee;
	}

	public void setKilomAnnee(int kilomAnnee) {
		this.kilomAnnee = kilomAnnee;
	}

	public int getAmortissement() {
		return amortissement;
	}

	public void setAmortissement(int amortissement) {
		this.amortissement = amortissement;
	}

	public double getImpact() {
		return impact;
	}

	public void setImpact(double impact) {
		this.impact = impact;
	}
	
	////////////////////////////////////toString//////////////////////////////////////////////////////////
	   public String toString() {
		   String s = "taille de v�hicule: "+this.getT()+"\n"+"nombre de kilom�tres parcourus par an: "+this.getKilomAnnee()+"\n"+"Dur�e de conservation du v�hicule: "+this.getAmortissement()+"\n"+"impacte: "+ this.getImpact()+" TCO2"+"\n"+"--------------------------";
		   if (possede) {
		   return s;
		   }else {
			   return "l'utulisateur ne poss�de pas de voiture";
		   }
	   }

}
