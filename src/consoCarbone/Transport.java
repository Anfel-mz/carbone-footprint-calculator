package consoCarbone;
import java.lang.Math;

public class Transport extends ConsoCarbone {
	private boolean possede = false; //si l'utilisateur possède une voiture ou non
    private Taille taille;
    private int kilomAnnee; //nbr de KM parcourus /an
    private int amortissement; //durée de conservation du véhicule
   
    
    //constantes
    private static final double CIMPACT = 1.93* Math.pow(10, (-4));
    
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
    
    static public void empcarbonne(){
        System.out.println("les transports représentent 31% de l'empreinte carbone des français soit 2650 kgCO2eq/an. Les véhicules particuliers sont responsables de plus de la moitié de cet impact suivi des poids lourds.");
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
	
	@Override
	   public String toString() {
		   String s = "taille de véhicule: "+this.getT()+"\n"+"nombre de kilomètres parcourus par an: "+this.getKilomAnnee()+"\n"+"Durée de conservation du véhicule: "+this.getAmortissement()+"\n"+"impacte: "+ this.getImpact()+" TCO2"+"\n"+"--------------------------";
		   if (possede) {
		   return s;
		   }else {
			   return "l'utulisateur ne possède pas de voiture";
		   }
	   }

}
