package consoCarbone;

public abstract class ConsoCarbone implements Comparable <ConsoCarbone>{
	//generating unique ids for every instance 
private static int idcount = 0;
private int id = ++idcount;
protected double impact;


//constructor
protected ConsoCarbone () {
	
}

protected ConsoCarbone (double impact) {
	this.impact = impact;
}

//getters and setters 
public int getId() {
	return this.id;
}

public double getImpact() {
	return impact;
}

protected abstract double setImpact();

@Override
public int compareTo(ConsoCarbone o) {
	/*if the impact of this object is bigger the methode will return a positive number
	 * if the impact is smaller than the compared to object it will return a negative number 
	 * if it's the same it will return 0
	 * instead of an if clauses we return the diffrence
	 */
	
	return (int)(this.impact - o.getImpact());
}

}
