package consoCarbone;

import java.time.LocalDate;
import java.time.Period;

public class Logement extends ConsoCarbone{
    private int superficie;
	private CE ce;
    private double impact;
    
    public Logement(int superficie, CE ce) {
    	super();
    	this.superficie = superficie;
    	this.ce = ce;
    	this.impact = this.setimpact();
    	this.empcarbonne();//afficher le message � la console 
    }
    
  /* 
   //avoir la valeure energetique � partir de l'impact
   *  public Logement(int superficie, double impact) {
    	this.superficie = superficie;
    	this.impact = impact;
    	this.ce = this.setce();
    }
    
    private CE setce(){
        CE a; 
        if ((this.impact / this.superficie)==0.005){ 
        	return CE.A;
       } else if ((this.impact / this.superficie)==0.01) {
        	return CE.B}
        
    

        
        return a;
    }*/
    
    
    private double setimpact(){
       
        
        return this.ce.getCo() * this.superficie;
    }
    
    static public void empcarbonne(){
        System.out.println("Les francais �mettent en moyenne 1696 kg de CO2 dans l'�nergie et les utilit�s, 675 en construction et gros entretien et 335 en �quipement des logements en moyenne par an.\nC'est un total de 2706 kg d'�mission de CO2 par an d�di� uniquement aux logements.");
    }
    
    //setters and getters
    
    public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public CE getCe() {
		return ce;
	}

	public void setCe(CE ce) {
		this.ce = ce;
	}

	public double getImpact() {
		return impact;
	}

	public void setImpact(double impact) {
		this.impact = impact;
	}

	//toString
	   public String toString() {
		   String s = "ID: "+this.getId()+"\n"+"Superficie: "+this.getSuperficie()+"\n"+"Classe �nerg�tique: "+this.getCe()+"\n"+"impacte: "+ this.getImpact()+ " TCO2"+"\n"+"--------------------------";
		   return s;
	   }
}
