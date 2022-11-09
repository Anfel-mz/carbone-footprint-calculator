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
    	this.empcarbonne();//afficher le message à la console 
    }
    
  /* 
   //avoir la valeure energetique à partir de l'impact
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
        System.out.println("Les francais émettent en moyenne 1696 kg de CO2 dans l'énergie et les utilités, 675 en construction et gros entretien et 335 en équipement des logements en moyenne par an.\nC'est un total de 2706 kg d'émission de CO2 par an dédié uniquement aux logements.");
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
		   String s = "ID: "+this.getId()+"\n"+"Superficie: "+this.getSuperficie()+"\n"+"Classe énergétique: "+this.getCe()+"\n"+"impacte: "+ this.getImpact()+ " TCO2"+"\n"+"--------------------------";
		   return s;
	   }
}
