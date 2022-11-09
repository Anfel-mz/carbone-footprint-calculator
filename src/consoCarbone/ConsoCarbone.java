package consoCarbone;

public class ConsoCarbone {
	//generating unique ids for every instance 
private static int idcount = 0;
private int id = ++idcount;

public int getId() {
	return this.id;
}
}
